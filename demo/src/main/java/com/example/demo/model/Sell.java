package com.example.demo.model;

import java.time.LocalDateTime;

import lombok.Getter;

public class Sell {
	@Getter
	private int amount;
	@Getter
	private LocalDateTime when;
}
