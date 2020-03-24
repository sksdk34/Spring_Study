package com.ms.board.Vo;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVo {
	
	@Id
	private String id;
	private int bno; //mysql¸¸ Á¸Àç
	private String title;
	private String content;
	private int count;
	private String writer;
	private LocalDate createTime;
	private LocalDate editTime;
}
