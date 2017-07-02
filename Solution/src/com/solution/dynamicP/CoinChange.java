package com.solution.dynamicP;

import java.util.Scanner;

import com.solution.main.ReadInput;

public class CoinChange {

	public void run() {

		Scanner sc = ReadInput.getScanner("coinChange");

		sc.useDelimiter("\n");
		int sum = sc.nextInt();
		int size = sc.nextInt();

		int[] c = ReadInput.getIntArray(size, sc.next());

		int ways = dorun(c, sum);

		System.out.println(ways);
	}

	private int dorun(int[] c, int sum) {
		int[][] T = new int[c.length][sum + 1];
		for (int i = 0; i < T.length; i++) {
			for (int j = 0; j < T[0].length; j++) {

				if (i == 0 || j == 0) {
					T[i][j] = 1;
				} else {
					if (j >= c[i]) {
						T[i][j] = T[i - 1][j] + T[i][j - c[i]];
					} else {
						T[i][j] = T[i - 1][j];
					}
				}
			}
		}
		return T[c.length - 1][sum];
	}
}
