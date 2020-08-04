package com.solution.array;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MatrixSpiralForm {
;
	public void run() throws FileNotFoundException {

		Scanner sc = new Scanner (new File("resource/spiralMatrix"));
		int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] a = new int [m][n];
        
        while (sc.hasNextInt()){
            for (int i=0;i<m;i++){
                for (int j=0;j<n;j++)
                    a[i][j]= sc.nextInt();
            }   
        }
		dorun(a);

	}
  
	private void dorun(int[][] a) {

		boolean doSpiral = true;
		int i = 0, j = 0;
		int TR = -1;
		int BR = a.length;
		int LC = -1;
		int RC = a[0].length;

		while (doSpiral) {
			while(j<RC){
				System.out.println(a[i][j]); j++;
			}
			TR = i ; j-- ; i++;
			while(i<BR){
				System.out.println(a[i][j]); i++;
			}
			RC = j ; j-- ; i--;
			while(j>LC){
				System.out.println(a[i][j]); j--;
			}
			BR = i ; j++ ; i--;
			while(i>TR){
				System.out.println(a[i][j]); i--;
			}
			LC = j ; j++ ; i++;
			
			//Check for odd and even no. of row and columns
			doSpiral = BR - TR > 1 && RC - LC > 1;
		}

	}

}
