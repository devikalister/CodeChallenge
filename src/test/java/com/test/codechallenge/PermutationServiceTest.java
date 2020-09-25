package com.test.codechallenge;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.app.codechallenge.service.PermutationService;

public class PermutationServiceTest {

	PermutationService permutationService = new PermutationService();

	@Test
	public void generateUniquePermutationsTest() {
		int[] inputArray = new int[] { 1, 2, 3, 2 };
		List<List<Integer>> uniquePermutationsList = permutationService.generatePermutations(inputArray);
		List<List<Integer>> expectedList = Arrays.asList(Arrays.asList(1, 2, 3, 2), Arrays.asList(1, 2, 2, 3),
				Arrays.asList(1, 3, 2, 2), Arrays.asList(2, 1, 3, 2), Arrays.asList(2, 1, 2, 3),
				Arrays.asList(2, 3, 1, 2), Arrays.asList(2, 3, 2, 1), Arrays.asList(2, 2, 3, 1),
				Arrays.asList(2, 2, 1, 3), Arrays.asList(3, 2, 1, 2), Arrays.asList(3, 2, 2, 1),
				Arrays.asList(3, 1, 2, 2));
		assertEquals(expectedList, uniquePermutationsList);
		assertEquals(uniquePermutationsList.size(), 12);
	}

	@Test
	public void generateUniquePermutationsWithNullTest() {
		List<List<Integer>> uniquePermutationsList = permutationService.generatePermutations(null);
		assertEquals(Collections.emptyList(), uniquePermutationsList);
	}

	@Test
	public void generateUniquePermutationsWithEmptyArrayTest() {
		List<List<Integer>> uniquePermutationsList = permutationService.generatePermutations(new int[0]);
		assertEquals(Collections.emptyList(), uniquePermutationsList);
	}
}