package com.san.learn.scope;

import java.util.List;
import java.util.Random;

import javax.enterprise.inject.Disposes;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class LuckyDishRaffle {

	@Inject
	private List<String> luckyDishes;

	private final Random random = new Random();

	public String getYourLuckyDish() {
		return luckyDishes.get(random.nextInt(3)); 
	}

	/*public void dispose(@Disposes List<String> dishes) {
		dishes = null;
	}*/
}
