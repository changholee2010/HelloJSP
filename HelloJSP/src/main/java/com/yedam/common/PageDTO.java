package com.yedam.common;

import lombok.Data;

// 페이징정보.
// 
@Data
public class PageDTO {

	private int currPage; // 현재페이지.
	private int start, end; // 시작, 끝페이지.
	private boolean previous, next; // 이전, 이후 여부.

	public PageDTO(int page, int totalCnt) {
		currPage = page; // 1 ... 3 ... 10
		end = (int) Math.ceil(page * 1.0 / 10) * 10;
		start = end - 9;

		// 실제 마지막 페이지.
		int realEnd = (int) Math.ceil(totalCnt * 1.0 / 5);
		end = end > realEnd ? realEnd : end;

		// 이전, 이후.
		previous = start > 1;
		next = end < realEnd;

	}

}
