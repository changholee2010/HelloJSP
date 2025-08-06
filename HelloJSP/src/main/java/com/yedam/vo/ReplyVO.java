package com.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private int replyNo;
	private int boardNo; //getBoardNo(), setBoardNo(int bno)
	private String reply;
	private String replyer;
	private Date replyDate;
}
