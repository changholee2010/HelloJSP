package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class LoginFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 요청재지정.
		req.getRequestDispatcher("WEB-INF/html/login_form.jsp")//
				.forward(req, resp);
	}

}
