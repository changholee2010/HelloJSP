package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.ReplyVO;

public interface ReplyMapper {
	List<ReplyVO> replyList(@Param("boardNo") int boardNo, @Param("page") int page); // 목록.
	int deleteReply(int replyNo); // 삭제.
	int insertReply(ReplyVO reply); // 등록.
	int selectCount(int boardNo); // 댓글건수계산.
	// 목록, 추가, 삭제. -> mapper.xml 에 추가.
	List<Map<String, Object>> selectEvents();
	int insertEvent(Map<String, String> map);
	int deleteEvent(String title);
}
