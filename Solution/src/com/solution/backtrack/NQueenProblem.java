package com.solution.backtrack;

import com.solution.main.*;

import java.util.*;

public class NQueenProblem {

	public void run() {

		Scanner sc = ReadInput.getScanner("nQueen");

		int m = sc.nextInt();
		int n = sc.nextInt();

		int[][] board = new int[m][m];

		boolean isPossible = placeQueens(board, m, n);

		if (isPossible)
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < m; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
		else {
			System.out.println("Not Possible");
		}

	}

	public boolean placeQueens(int[][] board, int m, int n) {
		if (n == 0) {
			return true;
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				if (isSafeSquare(board, m, i, j)) {
					//if we found a safe square assign
					board[i][j] = 1;
					if (placeQueens(board, m, n - 1)) {
						return true;
					} else { // undo the assignment , eval next square
						board[i][j] = 0;
					}

				}
			}
		}
		return false;
	}

	private boolean isSafeSquare(int[][] board, int m, int i, int j) {

		for (int p = 0; p < m; p++) {
			if (board[p][j] == 1 || board[i][p] == 1) {
				return false;
			}
		}

		//Todo Optimize this loop. n^2 can be brought down to n.
		for (int p = 0; p < m; p++) {
			for (int q = 0; q < m; q++) {
				if (isDiagonalSquare(p, q, i, j)) {
					if (board[p][q] == 1) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private boolean isDiagonalSquare(int p, int q, int i, int j) {
		return p + q == i + j || p - q == i - j;
	}
}
