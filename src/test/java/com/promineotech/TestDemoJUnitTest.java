/**
 * 
 */
package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

/**
 * 
 */
class TestDemoJUnitTest {

	
	private TestDemo testDemo;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}
		else {
			assertThatThrownBy(() -> 
			testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	public static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
				arguments(2, 4, 6, false),  // 2 + 4 = 6, no exception expected
	            arguments(0, 5, 0, true),  // 0 + 5, exception expected
	            arguments(-3, 7, 0, true), // -3 + 7, exception expected
	            arguments(10, 20, 30, false), // 10 + 20 = 30, no exception
	            arguments(-1, -2, 0, true) // Both negative, exception expected
				);
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		TestDemo testDemo = new TestDemo();

        // Test cases for positive numbers
        assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
        assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
        assertThat(testDemo.addPositive(1, 1)).isEqualTo(2);

	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreMultipliedCorrectly(int a, int b, int expected, boolean expectException) {
		TestDemo testDemo = new TestDemo();
		
		// Test cases for positive numbers
		assertThat(testDemo.multiplyIfPositive(4, 5)).isEqualTo(20);
		assertThat(testDemo.multiplyIfPositive(40, 50)).isEqualTo(2000);
		assertThat(testDemo.multiplyIfPositive(1, 1)).isEqualTo(2);
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		// use the testDemo object we made and wrap it in a spy so it doesn't affect the real method
		TestDemo mockDemo = spy(testDemo);
		// stub the random number with 5 so we know the expected result
		doReturn(5).when(mockDemo).getRandomInt();
		// call the method
		int fiveSquared = mockDemo.randomNumberSquared();
		// assert that the result is the expected value
		assertThat(fiveSquared).isEqualTo(25);
	}

}




















