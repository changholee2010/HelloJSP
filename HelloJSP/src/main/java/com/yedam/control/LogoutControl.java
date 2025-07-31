package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;

public class LogoutControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 세션객체 초기화.
		HttpSession session = req.getSession();
		session.invalidate();

		resp.sendRedirect("boardList.do");

	}

}
