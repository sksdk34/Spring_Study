package com.ms.board.Vo;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Orders {

	private int ono;
	private Timestamp orderDate;
	private int amount;
	private int cno;
}
