package com.test.codechallenge;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.app.codechallenge.service.SortingService;

public class SortingServiceTest {

	SortingService sortingService = new SortingService();

	@Test
	public void sortOddEvenNumbersTest() {
		int[] array = new int[] { 1, 5, 6, 3, 8, 12, 7, 0 };
		List<Integer> expectedList = Arrays.asList(new Integer[] { 1, 3, 5, 7, 0, 6, 8, 12 });
		List<Integer> sortedList = sortingService.sortOddEvenNumbers(array);
		assertEquals(expectedList, sortedList);
	}

	@Test
	public void sortOddEvenNumbersWithNullTest() {
		List<Integer> sortedList = sortingService.sortOddEvenNumbers(null);
		assertEquals(Collections.emptyList(), sortedList);
	}

	@Test
	public void sortOddEvenNumbersWithEmptyArrayTest() {
		List<Integer> sortedList = sortingService.sortOddEvenNumbers(new int[0]);
		assertEquals(Collections.emptyList(), sortedList);
	}

	@Test
	public void sortOddEvenNumbersWithSingleElementTest() {
		int[] inputArray = new int[] { 2 };
		List<Integer> uniquePermutationsList = sortingService.sortOddEvenNumbers(inputArray);
		assertEquals(uniquePermutationsList, Arrays.asList(Arrays.stream(inputArray).boxed().toArray(Integer[]::new)));
	}
}