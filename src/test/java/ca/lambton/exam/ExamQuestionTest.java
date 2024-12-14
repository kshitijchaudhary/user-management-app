package ca.lambton.exam;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExamQuestionsTest {

	@Test
	void testCountConsonants() {
		assertEquals(2, ExamQuestions.countConsonants("food"));
		assertEquals(3, ExamQuestions.countConsonants("hello"));
		assertEquals(0, ExamQuestions.countConsonants("aeiou"));
	}

	@Test
	void testIsPrime() {
		assertTrue(ExamQuestions.isPrime(7));
		assertTrue(ExamQuestions.isPrime(17));
		assertFalse(ExamQuestions.isPrime(4));
		assertFalse(ExamQuestions.isPrime(1));
	}
}
