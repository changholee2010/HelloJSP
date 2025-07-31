package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// param 처리=> uname, psw
		String id = req.getParameter("uname");
		String pw = req.getParameter("psw");

		// DB 처리.
		MemberService svc = new MemberServiceImpl();
		MemberVO member = svc.userCheck(id, pw);

		// 페이지이동.
		if (member == null) {

		} else {
			// 세션을 활용하여 정보저장.
			// 정상 id, pw 입력.
			HttpSession session = req.getSession(); //
			session.setAttribute("logId", id); // 속성(logId)=로그인아이디.
			resp.sendRedirect("boardList.do");
		}

	} // end of execute.

}
