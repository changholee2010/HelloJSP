package com.yedam.service;

import java.util.List;

import com.yedam.vo.BoardVO;

// 업무(process)
public interface BoardService {
	public List<BoardVO> boardList(int page); // 업무단위표기.
	public BoardVO searchBoard(int boardNo); // 조회(조회+카운트증가)
	public boolean registerBoard(BoardVO board); // 등록
	public boolean removeBoard(int boardNo); // 삭제
	
}
