package com.solution.dynamicP;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.solution.main.ReadInput;

public class RodCuttingMinimizeCost {

	public void run() throws FileNotFoundException {
		Scanner sc = ReadInput.getScanner("rodCutting");
		int sum = sc.nextInt();
		int size = sc.nextInt();
		
		String arr = sc.next();
		String arrw = sc.next();

		int[] w = ReadInput.getIntArray(size, arr);
		int [] v  = ReadInput.getIntArray(size, arrw);

		System.out.println(dorun(sum, w , v));

	}

	private int dorun(int sum, int[] a, int[] v) {

		int[][] T = new int[a.length][sum + 1];

		for (int i = 0; i < T.length; i++) {
			for (int j = 0; j < T[0].length; j++) {
				if (i == 0) {
					if (j == 0) {
						T[i][j] = 0;
					} else if (j < a[0]) {
						T[i][j] = 0;
					} else {
						T[i][j] = j * v[i];
					}
				}
				else {
					
					if(j < a[i-1]){
						T[i][j] = T[i-1][j];
					} else {
						T[i][j] = Math.min(T[i-1][j], v[i-1] + T[i][j-a[i-1]]);
					}
				}
			}
		}

		return T[T.length - 1][sum];

	}
}
