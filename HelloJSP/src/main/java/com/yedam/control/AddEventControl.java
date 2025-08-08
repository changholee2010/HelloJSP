package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class AddEventControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = req.getParameter("title");
		String start = req.getParameter("start");
		String end = req.getParameter("end");

		Map<String, String> map = new HashMap<>();
		map.put("title", title);
		map.put("start", start);
		map.put("end", end);

		ReplyService svc = new ReplyServiceImpl();
		try {
			svc.addEvent(map);
			resp.getWriter().print("{\"retCode\":\"OK\"}"); // {"retCode":"OK"}
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().print("{\"retCode\":\"NG\"}"); // {"retCode":"NG"}
		}

	} // end of execute.

} // end of class.
