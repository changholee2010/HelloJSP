package com.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVO;

public class Main {
	public static void main(String[] args) {
		SqlSession sqlSession = DBUtil.getInstance().openSession();
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);

		List<ReplyVO> list = mapper.replyList(146);
		for (ReplyVO reply : list) {
			System.out.println(reply);
		}

	}
}
