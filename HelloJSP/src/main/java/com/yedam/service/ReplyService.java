package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.vo.ReplyVO;

public interface ReplyService {
	List<ReplyVO> replyList(int boardNo, int page); // 목록.
	boolean removeReply(int replyNo); // 삭제.
	boolean addReply(ReplyVO reply); // 등록.
	int replyCount(int boardNo); // 댓글건수.
	// 목록, 추가, 삭제 -> ReplyServiceImpl에 구현.
	List<Map<String, Object>> eventList();
	boolean addEvent(Map<String, String> map);
	boolean removeEvent(String title);
}
