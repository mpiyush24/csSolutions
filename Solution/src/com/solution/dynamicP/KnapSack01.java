package com.solution.dynamicP;

import java.util.Scanner;

import com.solution.main.ReadInput;

public class KnapSack01 {

	public void run() {

		Scanner sc = ReadInput.getScanner("knapsack");
		sc.useDelimiter("\n");
		int size = sc.nextInt();
		int rw = sc.nextInt();

		String[] weight = sc.next().split(" ");
		String[] val = sc.next().split(" ");

		int[] w = new int[size];
		int[] v = new int[size];

		for (int i = 0; i < size; i++) {
			w[i] = Integer.parseInt(weight[i]);
			v[i] = Integer.parseInt(val[i]);
		}

		System.out.println("Recursion: " + doRunRec(w, v, rw, 0, 0));
		System.out.println("DP: " + doRunDP(w, v, rw));

	}

	/**
	 * 
	 * @param weight
	 *            array
	 * @param val
	 *            array
	 * @param w
	 *            required weight
	 * @param v
	 *            required value
	 * @param itemNumber
	 *            current Item
	 */
	private int doRunRec(int[] weight, int[] val, int w, int v, int itemNumber) {
		if (w == 0 || itemNumber == weight.length) {
			return 0;
		}

		if (w < weight[itemNumber]) {
			return doRunRec(weight, val, w, v, itemNumber + 1);
		}

		int lmax = val[itemNumber] + doRunRec(weight, val, w - weight[itemNumber], v + val[itemNumber], itemNumber + 1);
		int rmax = doRunRec(weight, val, w, v, itemNumber + 1);

		return Math.max(lmax, rmax);
	}

	private int doRunDP(int[] weight, int[] val, int rw) {

		int[][] T = new int[weight.length][rw + 1];

		for (int i = 0; i < weight.length; i++) {
			T[i][0] = 0;
			if (weight[i] < i) {
				T[0][i] = val[i];
			} else {
				T[0][i] = 0;
			}

		}

		for (int i = 1; i < weight.length; i++) {
			for (int j = 1; j < T[0].length; j++) {

				if (j < weight[i - 1]) {
					T[i][j] = T[i - 1][j]; // 'i-1' because we are 1 index ahead
											// of weight array.
				} else {
					T[i][j] = Math.max(val[i - 1] + T[i - 1][j - weight[i - 1]], T[i - 1][j]);
				}
			}
		}

		return T[weight.length - 1][rw];
	}

}
