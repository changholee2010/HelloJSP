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

public class ChartControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<>();
		map.put("user01", 39);
		map.put("user03", 27);
		map.put("user06", 123);
		map.put("user14", 223);
		map.put("user23", 12);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(map);

		resp.getWriter().print(json);

	}

}
