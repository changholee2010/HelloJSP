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

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		// addBoard.do?title=???&writer=????&content=????
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");

		//
		BoardVO param = new BoardVO();
		param.setTitle(title);
		param.setContent(content);
		param.setWriter(writer);

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
