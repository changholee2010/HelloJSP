package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		// 권한확인. (로그인아이디 vs. 작성자아이디)
		HttpSession session = req.getSession();
		String logId = (String) session.getAttribute("logId");

		if (logId != null && logId.equals(board.getWriter())) {
			// view영역(jsp)로 값을 전달.
			req.setAttribute("board_info", board);

			// 요청재지정.
			req.getRequestDispatcher("WEB-INF/html/modify_board.jsp")//
					.forward(req, resp);

		} else {
			// 권한없을경우.

			// board_info
			req.setAttribute("board_info", board);
			req.setAttribute("msg", "권한이 없습니다.");

			// 요청재지정.
			req.getRequestDispatcher("WEB-INF/html/board.jsp")//
					.forward(req, resp);
		}

	}

}
