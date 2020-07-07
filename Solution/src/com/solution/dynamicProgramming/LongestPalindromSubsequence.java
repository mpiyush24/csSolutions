package com.solution.dynamicProgramming;

import java.util.Scanner;

import com.solution.main.ReadInput;

public class LongestPalindromSubsequence {

	public void run() {
		Scanner sc = ReadInput.getScanner("longestPalindromeSubsequence");

		String str = sc.next();
		System.out.println("DP:"+doRun(str));
		System.out.println("recur:"+longestPalindrome(str, 0, str.length() - 1));
	}

	private int doRun(String str) {

		int[][] T = new int[str.length()][str.length()];

		for (int j = 0; j < str.length(); j++) {
			for (int i = j; i >= 0; i--) {
				if (i == j) {
					T[i][j] = 1;
				} else {
					T[i][j] = 0;
				}

			}
		}

		for (int k = 1; k < str.length(); k++) {
			for (int i = 0, j = k; i < str.length()-1 && j < str.length(); i++,j++) {
				if (str.charAt(i) == str.charAt(j)) {
					T[i][j] = 2 + T[i + 1][j - 1];
				} else {
					T[i][j] = Math.max(T[i][j - 1], T[i + 1][j]);
				}
			}
		}

		return T[0][str.length() - 1];
	}

	public int longestPalindrome(String str, int begin, int end) {

		if (begin > end) {
			return 0;
		}

		if (begin == end) {
			return 1;
		}

		if (str.charAt(begin) == str.charAt(end)) {
			return 2 + longestPalindrome(str, begin + 1, end - 1);
		} else {
			return Math.max(longestPalindrome(str, begin + 1, end), longestPalindrome(str, begin, end - 1));
		}
	}
}
