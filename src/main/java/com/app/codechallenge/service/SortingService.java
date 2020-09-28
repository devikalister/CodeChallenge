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
		if (arr == null || arr.length == 0)
			return Collections.emptyList();
		if (arr.length == 1)
			return Arrays.asList(arr[0]);
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
		oddList = sortList(oddList);
		evenList = sortList(evenList);
		finalList.addAll(oddList);
		finalList.addAll(evenList);
		return finalList;
	}

	/**
	 * @param arr contains list of integer values
	 * @return sorted array list
	 */
	private List<Integer> sortList(List<Integer> list) {
		int temp = 0;
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(j) < list.get(i)) {
					temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
		return list;
	}
}