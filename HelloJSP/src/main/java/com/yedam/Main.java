package com.yedam;

import org.apache.ibatis.session.SqlSession;

import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class Main {
	public static void main(String[] args) {

		BoardService svc = new BoardServiceImpl(); // 업무기능.

		int searchNo = 1;

		// 조회. 조회수증가. => 업무(조회: 글번호조회 + 조회카운트)
		BoardVO board = svc.searchBoard(searchNo);

		System.out.println(board.toString());

	}
}
