package com.yedam.control;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		// key=value + 파일 => 처리.
		// cos.jar 활용해서 Multipart요청을 처리.
		// 게시글 DB Insert.

		// 서버상의 upload 폴더에 저장.
		String upload = req.getServletContext().getRealPath("upload");
		System.out.println(upload);

		MultipartRequest mr = new MultipartRequest(//
				req, // 요청정보
				upload, // 업로드경로
				1024 * 1024 * 5, // 최대파일크기
				"UTF-8", // 인코딩방식
				new DefaultFileRenamePolicy() // 리네임정책.
		);

		// addBoard.do?title=???&writer=????&content=????
		String title = mr.getParameter("title");
		String writer = mr.getParameter("writer");
		String content = mr.getParameter("content");
		String img = mr.getFilesystemName("images"); // 파일이름.

		//
		BoardVO param = new BoardVO();
		param.setTitle(title);
		param.setContent(content);
		param.setWriter(writer);
		param.setImage(img);

		BoardService svc = new BoardServiceImpl();
		if (svc.registerBoard(param)) {
			// 목록이동.
			resp.sendRedirect("boardList.do");
		} else {
			System.out.println("에러발생.");
		}

	} // end of execute.

	void upload(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		// db insert를 위한 map 선언.
		Map<String, String> map = new HashMap<>();

		if (!ServletFileUpload.isMultipartContent(req)) {
			throw new ServletException("Not multipart/form-data");
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024 * 1024 * 5);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(1024 * 1024 * 5);
		upload.setSizeMax(1024 * 1024 * 50);

		String uploads = req.getServletContext().getRealPath("/uploads");

		try {
			List<FileItem> formItems = upload.parseRequest(req);

			if (formItems != null && formItems.size() > 0) {
				for (FileItem item : formItems) {

					if (!item.isFormField()) {
						String fileName = new File(item.getName()).getName();
						String fileExtension = "";
						int dotIdx = fileName.lastIndexOf('.');
						if (dotIdx > 0 && dotIdx < fileName.length() - 1) {
							fileExtension = fileName.substring(dotIdx);
						}

						String uniqFileName = UUID.randomUUID().toString() + fileExtension;
						String filePath = uploads + File.separator + uniqFileName;
						File storeFile = new File(filePath);

						if (!storeFile.getParentFile().exists()) {
							storeFile.getParentFile().mkdirs();
						}

						item.write(storeFile);

					} else {
						String key = item.getFieldName();
						String val = item.getString("utf-8");

						map.put(key, val);

					}
				}
				// 전체값을 가져와서 db insert.
				BoardService svc = new BoardServiceImpl();
				if (svc.registerMap(map)) {
					// 목록이동.
					resp.sendRedirect("boardList.do");
				} else {
					System.out.println("에러발생.");
				}
			}

		} catch (Exception e) {
			System.out.println("multipart/form-data가 아닙니다.");
			e.printStackTrace();
		}
	}

}
