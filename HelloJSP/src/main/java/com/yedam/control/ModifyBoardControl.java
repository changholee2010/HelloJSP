package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyBoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// addBoard.do?title=???&writer=????&content=????
		String bno = req.getParameter("bno");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String page = req.getParameter("page");

		//
		BoardVO param = new BoardVO();
		param.setBoardNo(Integer.parseInt(bno));
		param.setTitle(title);
		param.setContent(content);

		BoardService svc = new BoardServiceImpl();
		if (svc.modifyBoard(param)) { // 수정.
			// 목록이동.
			resp.sendRedirect("boardList.do?page=" + page);
		} else {
			System.out.println("에러발생.");
		}

	}

}
