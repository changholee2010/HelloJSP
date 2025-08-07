package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class TotalCntControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ?bno=145 => {"totalCnt": 78}
		String bno = req.getParameter("bno"); // parameter.

		ReplyService svc = new ReplyServiceImpl();
		int cnt = svc.replyCount(Integer.parseInt(bno));
		// {"totalCnt": 12}
		resp.getWriter().print("{\"totalCnt\": " + cnt + "}");

	}

}
