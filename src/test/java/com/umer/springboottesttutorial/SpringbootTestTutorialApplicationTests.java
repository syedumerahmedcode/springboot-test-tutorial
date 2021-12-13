package com.umer.springboottesttutorial;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class SpringbootTestTutorialApplicationTests {

	Calculator underTest = new Calculator();

	@Test
	void contextLoads() {
	}

	class Calculator {
		int add(int a, int b) {
			return a + b;
		}
	}

}
