package com.yedam.common;

import lombok.Data;

// 글목록에 사용되는 파라미터르 담는 클래스.
@Data
public class SearchDTO {
	private int page;
	private String searchCondition;
	private String keyword;
}
