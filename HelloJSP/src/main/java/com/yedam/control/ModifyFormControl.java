package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 수정화면. bno=3
		String bno = req.getParameter("bno");

		// DB조회.
		BoardService svc = new BoardServiceImpl();
		BoardVO board = svc.searchBoard(Integer.parseInt(bno));

		// view영역(jsp)로 값을 전달.
		req.setAttribute("board_info", board);

		// 요청재지정.
		req.getRequestDispatcher("WEB-INF/html/modify_board.jsp")//
				.forward(req, resp);

	}

}
