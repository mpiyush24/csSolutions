package com.solution.dynamicProgramming;

import java.util.Scanner;

import com.solution.main.ReadInput;

public class LongestIncreasingSubset {
	public void run() {

		Scanner sc = ReadInput.getScanner("longestIncreasingSubset");

		int size = sc.nextInt();

		int[] arr = ReadInput.getIntArray(size, sc.next());

		System.out.println(doRun(arr));
	}

	private int doRun(int[] arr) {

		int[] T = new int[arr.length];

		for (int i = 0; i < T.length; i++) {
			T[i] = 1;
		}

		for (int i = 1; i < arr.length;i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					T[i] = Math.max(T[i], T[j] + 1);
				}
			}
		}

		int max = T[0];
		for(int i = 1 ; i < T.length; i ++){
			max = Math.max(max,T[i]);
		}
		
		return max;
	}
	
	
	

}
