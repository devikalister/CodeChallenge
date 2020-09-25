package com.app.codechallenge.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingService {

	/**
	 * To sort a list of numbers that odd numbers are sorted before even numbers
	 * 
	 * @param arr contains list of integer values
	 * @return sorted array list with odd numbers sorted first and then even numbers
	 */
	public List<Integer> sortOddEvenNumbers(int arr[]) {
		if (arr != null && arr.length > 0) {
			List<Integer> evenList = new ArrayList<Integer>();
			List<Integer> oddList = new ArrayList<Integer>();
			List<Integer> finalList = new ArrayList<Integer>();
			for (int i = 0; i < arr.length; i++) {
				// segregate odd and even numbers in the array as a separate list
				if (arr[i] % 2 == 0)
					evenList.add(arr[i]);
				else
					oddList.add(arr[i]);
			}
			oddList = sortList(oddList.toArray(new Integer[oddList.size()]));
			evenList = sortList(evenList.toArray(new Integer[evenList.size()]));
			finalList.addAll(oddList);
			finalList.addAll(evenList);
			return finalList;
		} else if (arr != null && arr.length == 1) {
			return new ArrayList<Integer>(Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new)));
		}
		return Collections.emptyList();
	}

	/**
	 * @param arr contains list of integer values
	 * @return sorted array list
	 */
	private List<Integer> sortList(Integer[] arr) {
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}

			}
		}

		return new ArrayList<Integer>(Arrays.asList(arr));
	}
}