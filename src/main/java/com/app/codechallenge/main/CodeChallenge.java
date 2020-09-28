package com.app.codechallenge.main;

import java.util.List;
import java.util.logging.Logger;
import com.app.codechallenge.service.PermutationService;
import com.app.codechallenge.service.SortingService;

public class CodeChallenge {
	public static final Logger logger = Logger.getLogger("CodeChallenge");

	public static void main(String[] args) {
		int[] inputArray = new int[] { 1, 2, 3, 2 };
		// To sort the array using sorting service
		SortingService sortingService = new SortingService();
		List<Integer> sortedList = sortingService.sortOddEvenNumbers(inputArray);
		logger.info("The sorted list is ");
		sortedList.forEach(i -> logger.info(i.toString()));
		// To generate unique permutations using permutation service
		PermutationService permutationService = new PermutationService();
		List<List<Integer>> uniquePermutationsList = permutationService.generatePermutations(inputArray);
		logger.info("The unique permutations are ");
		uniquePermutationsList.forEach(i -> logger.info(i.toString()));
	}
}