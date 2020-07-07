package com.solution.dynamicProgramming;

import java.util.Scanner;

import com.solution.main.ReadInput;

public class SubsetSum {

	public void run() {
		Scanner sc = ReadInput.getScanner("subsetSum");

		int sum = sc.nextInt();

		int intArrSize = sc.nextInt();

		int[] arr = ReadInput.getIntArray(intArrSize, sc.next());

		System.out.println(doSubsetSum(arr, sum));
		System.out.println(isSubsetSum(arr, sum, arr.length-1));
	}

	private boolean doSubsetSum(int[] arr, int sum) {

		boolean[][] T = new boolean[arr.length][sum + 1];

		for (int i = 0; i < T.length; i++) {
			for (int j = 0; j < T[0].length; j++) {
				if (j == 0) {
					T[i][j] = true;
				} else {
					if (i > 0) {
						if (j >= arr[i]) {
							T[i][j] = T[i - 1][j] || T[i - 1][j - arr[i]];
						} else {
							T[i][j] = T[i - 1][j];
						}
					} else {
						if (j - arr[i] == 0) {
							T[i][j] = true;
						} else {
							T[i][j] = false;
						}
					}
				}
			}
		}
		return T[arr.length - 1][sum];
	}
	
	public boolean isSubsetSum(int[] c , int sum , int index){
		if(index == 0 ){
			return true;
		}
		return isSubsetSum(c, sum - c[index], index - 1) || isSubsetSum(c, sum, index-1);
	}
}



