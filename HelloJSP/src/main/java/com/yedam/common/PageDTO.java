package com.yedam.common;

import lombok.Data;

// 페이징정보.
// 
@Data
public class PageDTO {

	private int currPage; // 현재페이지.
	private int start, end; // 시작, 끝페이지.

	public PageDTO(int page, int totalCnt) {
		currPage = page; // 1 ... 3 ... 10
		end = (int) Math.ceil(page * 1.0 / 10) * 10;
		start = end - 9;
	}

}
