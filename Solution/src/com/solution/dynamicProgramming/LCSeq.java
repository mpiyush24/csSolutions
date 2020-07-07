package com.solution.dynamicProgramming;

import java.util.Scanner;

import com.solution.main.ReadInput;

public class LCSeq {
	public void run() {
		Scanner sc = ReadInput.getScanner("lcs");

		String seq1 = sc.next();
		String seq2 = sc.next();

		System.out.println("Rec: " + doRunrec(seq1, seq2, seq1.length() - 1, seq2.length() - 1));
		System.out.println("DP: " + doRunDP(seq1, seq2));
	}

	private int doRunrec(String seq1, String seq2, int i, int j) {
		if (i == -1 || j == -1) {
			return 0;
		}
		if (seq1.charAt(i) == seq2.charAt(j)) {

			return 1 + doRunrec(seq1, seq2, i - 1, j - 1);
		} else {
			return Math.max(doRunrec(seq1, seq2, i - 1, j), doRunrec(seq1, seq2, i, j - 1));
		}
	}

	private int doRunDP(String seq1, String seq2) {

		int[][] T = new int[seq1.length()+1][seq2.length()+1];

		for (int i = 0; i <= seq1.length(); i++) {
			for (int j = 0; j <= seq2.length(); j++) {

				if (i == 0 || j == 0) {
					T[i][j] = 0;
				} else {
					if (seq1.charAt(i - 1) == seq2.charAt(j - 1)) {
						T[i][j] = 1 + T[i - 1][j - 1];
					} else {
						T[i][j] = Math.max(T[i - 1][j], T[i][j - 1]);
					}

				}

			}
		}
		for (int i = 1; i <= seq1.length(); i++) {

			for (int j = 1; j <= seq2.length(); j++) {

				System.out.print(T[i][j] + "<" + seq1.charAt(i - 1) + seq2.charAt(j - 1) + "> ");
			}
			System.out.println();
		}
		return T[seq1.length()][seq2.length()];

	}

}
