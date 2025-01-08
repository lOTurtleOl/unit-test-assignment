/**
 * 
 */
package com.promineotech;

import java.util.Random;

/**
 * 
 */
public class TestDemo {

	public int addPositive(int a, int b) {
		if (a <= 0 || b <= 0) {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
		return a + b;
	}
	
	//multiplies two integers if both are positive
	public int multiplyIfPositive(int a, int b) {
		if (a <= 0 || b <= 0) {
			throw new IllegalArgumentException("Both parameters must be positive");
		}
		return a * b;
	}
	
	public int randomNumberSquared() {
		int randomNum = getRandomInt();
		return randomNum * randomNum;
	}
	
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
	
}
