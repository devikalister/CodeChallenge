package com.app.codechallenge.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PermutationService {
	/**
	 * To generate the unique permutations based on the given array
	 * 
	 * @param arr contains list of integer values
	 * @return unique permutations list
	 */
	public List<List<Integer>> generatePermutations(int[] arr) {
		if (Objects.isNull(arr) || arr.length == 0) {
			return Collections.emptyList();
		}
		List<List<Integer>> uniquePermutationsList = new ArrayList<>();
		generatePermutationsRecursive(arr, 0, arr.length, uniquePermutationsList);
		return uniquePermutationsList;
	}

	/**
	 * To check whether swap is needed or not for the current Index
	 * 
	 * @param arr          contains list of integer values
	 * @param start        defines the start position of the array
	 * @param currentIndex defines the current index
	 */
	private boolean isSwapNeeded(int start, int currentIndex, int[] arr) {
		for (int i = start; i < currentIndex; i++) {
			if (arr[i] == arr[currentIndex]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Recursive method to generate the unique permutations
	 * 
	 * @param arr                    contains list of integer values
	 * @param currentIndex           defines the position of the current index
	 * @param n                      defines the size of the array
	 * @param uniquePermutationsList contains the unique permutations list
	 */
	private void generatePermutationsRecursive(int[] arr, int currentIndex, int n,
			List<List<Integer>> uniquePermutationsList) {
		if (currentIndex == n - 1) {
			uniquePermutationsList.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
			return;
		} else {
			for (int i = currentIndex; i < arr.length; i++) {
				if (isSwapNeeded(currentIndex, i, arr)) {
					swap(arr, i, currentIndex);
					generatePermutationsRecursive(arr, currentIndex + 1, n, uniquePermutationsList);
					swap(arr, i, currentIndex);
				}
			}
		}
	}

	/**
	 * Swaps the elements in the given array using the position
	 * 
	 * @param arr contains list of integer values
	 * @param i   defines the element position
	 * @param j   defines the element position
	 */
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}