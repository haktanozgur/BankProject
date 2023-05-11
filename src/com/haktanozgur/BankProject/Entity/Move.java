package com.haktanozgur.BankProject.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Move {

	private String senderAccountNo;
	private String receiverAccountNo;
	private double money;
	private String source;
	private String target;
	private double lastPrice;
}
