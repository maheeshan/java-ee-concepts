package com.san.learn.producer;

import java.util.List;

import javax.enterprise.inject.Produces;

public class LuckyDishProducer {

	@Produces
	public List<String> produceLuckyDish() {
		return List.of(
				"Carbonara",
				"Bolegnese",
				"Ricotta",
				"Parmegano melansane"
		);
	}
}
