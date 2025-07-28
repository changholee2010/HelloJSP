package com.yedam;

import lombok.AllArgsConstructor;
import lombok.Data;

// 생성자, getter/setter
// lombok 라이브러리 1)설치 2)lib
@Data
@AllArgsConstructor
public class Book {
	private int id;
	private String title;
	private String author;
	private int price;
}
