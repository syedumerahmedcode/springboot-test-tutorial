package com.umer.springboottesttutorial;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class SpringbootTestTutorialApplicationTests {

	Calculator underTest = new Calculator();

	@Test//Junit annotation
	void itShouldAddTwoNumbers() {
		// given
		int numberOne=20;
		int numberTwo=30;
		
		// when
		int result= underTest.add(numberOne, numberTwo);
		
		// then
		final int expected = 50;
		assertThat(result).isEqualTo(expected);
		
	}

	class Calculator {
		int add(int a, int b) {
			return a + b;
		}
	}

}
