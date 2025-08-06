package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.ReplyVO;

public interface ReplyMapper {
	List<ReplyVO> replyList(@Param("boardNo") int boardNo, @Param("page") int page); // 목록.
	int deleteReply(int replyNo); // 삭제.
	int insertReply(ReplyVO reply); // 등록.
}
