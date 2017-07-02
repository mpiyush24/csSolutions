package com.solution.dynamicP;

import java.util.Scanner;

import com.solution.main.ReadInput;

public class LCSubString {

	public void run() {

		Scanner sc = ReadInput.getScanner("lcs");

		String seq1 = sc.next();
		String seq2 = sc.next();

		System.out.println("Recursion:" + doRun(seq1, seq2, seq1.length() - 1, seq2.length() - 1, false));
		System.out.println("DP:" + doRun(seq1, seq2));
		
	}

	private int doRun(String seq1, String seq2, int i, int j, boolean found) {

		if (i < 0 || j < 0) {
			return 0;
		}

		if (found == true) {
			if (seq1.charAt(i) == seq2.charAt(j)) {
				return 1 + doRun(seq1, seq2, i - 1, j - 1, true);
			} else {
				return 0;
			}
		}

		int r1 = 0;

		if (seq1.charAt(i) == seq2.charAt(j)) {
			r1 = 1 + doRun(seq1, seq2, i - 1, j - 1, true);
		}

		return Math.max(r1, Math.max(doRun(seq1, seq2, i - 1, j, false), doRun(seq1, seq2, i, j - 1, false)));

	}

	private int doRun(String seq1, String seq2) {

		int[][] T = new int[seq1.length() + 1][seq1.length() + 1];
		int max = 0;

		for (int i = 0; i <= seq1.length(); i++) {
			for (int j = 0; j <= seq2.length(); j++) {

				if (i == 0 || j == 0) {
					T[i][j] = 0;
				} else {
					if (seq1.charAt(i-1) == seq2.charAt(j-1)) {
						T[i][j] = T[i - 1][j - 1] + 1;
						max = Math.max(max, T[i][j]);
					} else {
						T[i][j] = 0;
					}
				}
			}
		}
		return max;
	}
}
