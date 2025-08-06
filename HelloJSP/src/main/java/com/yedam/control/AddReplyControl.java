package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class AddReplyControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");

		// param: addReply.do?bno=145&reply=test&replyer=user01
		String bno = req.getParameter("bno");
		String reply = req.getParameter("reply");
		String replyer = req.getParameter("replyer");

		// addReply(ReplyVO reply)
		ReplyVO rvo = new ReplyVO();
		rvo.setBoardNo(Integer.parseInt(bno)); //"145" -> 145
		rvo.setReply(reply);
		rvo.setReplyer(replyer);

		// retCode, bno, reply, replyer => Map<키, 값>
		Map<String, Object> map = new HashMap<String, Object>();

		// DB 처리. => 반환.
		ReplyService svc = new ReplyServiceImpl();
		if (svc.addReply(rvo)) {
			map.put("retCode", "OK");
			map.put("retVal", rvo);
			// resp.getWriter().print("{\"retCode\":\"OK\"}");
		} else {
			map.put("retCode", "NG");
			// resp.getWriter().print("{\"retCode\":\"NG\"}");
		}

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(map); // 자바객체 -> json문자열.
		resp.getWriter().print(json);

	}

}
