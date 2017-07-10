package com.solution.array;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RotateArray {

	public void run() throws FileNotFoundException {

		Scanner sc = new Scanner(new File("resource/matrixRotate"));
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] a = new int[m][n];

		while (sc.hasNextInt()) {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			}
		}

		//dorun(a);
		inPlaceRotation(a);
	}

	private void dorun(int[][] a) {
		int m = a.length;
		int n = a[0].length;

		int[][] b = new int[n][m];

		for (int i = 0; i < m; i++) {
			int[] temp = new int[n];

			for (int j = 0; j < n; j++) {
				temp[j] = a[i][j];
			}

			for (int j = m - i - 1; j >= 0; j--) {
				for (int k = 0; k < n; k++) {
					b[k][j] = temp[k];
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void inPlaceRotation(int[][] a) {

		int m = a.length;
		int n = a[0].length;

		int iter = 0;
		if (m % 2 == 0) {
			iter = m / 2 - 1;

		} else {
			iter = m / 2;
		}

		for (int x = 0; x <= iter; x++) {

			int low_bound_row = x;
			int low_bound_col = x;
			int up_bound_col = n-x-1;
			int up_bound_row = m-x-1;

			for (int i = low_bound_row; i < up_bound_row; i++) {
				//from right top corner we are moving down
				// preserve value from right most column 
				/*
				 *  1 2 3
				 *  4 5 6
				 *  7 8 9
				 *  temp1 = 3
				 *  (0,2) = 1
				 *  temp2 = 9
				 *  (2,2) = temp1
				 *  temp1 = 7
				 *  (3,0) = temp2 
				 *  (0,0) = temp1 
				 */
				
				int temp1 = a[i][up_bound_col];
				
				a[i][up_bound_col] = a[low_bound_row][i];
				
				//preserve value from last row position
				int temp2 = a[up_bound_row][up_bound_col - i];
				
				// assign the value preserved from right most column to this row
				a[up_bound_row][up_bound_col - i] = temp1;
				
				//from lower left corner we are moving up 
				temp1 = a[up_bound_row-i][low_bound_col];
				
				// from lower left corner we moving upwards.
				a[up_bound_row-i][low_bound_col] = temp2;
				
				a[low_bound_col][i] = temp1;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

}
