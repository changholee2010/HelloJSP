package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) //
			throws ServletException, IOException {
		// parameter(?bno=3)
		String bno = req.getParameter("bno");

		BoardService svc = new BoardServiceImpl();
		BoardVO board = svc.searchBoard(Integer.parseInt(bno));

		// board_info
		req.setAttribute("board_info", board);

		// 요청재지정.
		req.getRequestDispatcher("WEB-INF/html/board.jsp")//
				.forward(req, resp);
	}

}
