package com.ms.board.Vo;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVo {
	
	private int bno;
	private String title;
	private String content;
	private int count;
	private String writer;
	private LocalDate createTime;
	private LocalDate editTime;
}
