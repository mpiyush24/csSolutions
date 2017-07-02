package com.solution.dynamicP;

import java.util.Scanner;

import com.solution.main.ReadInput;

public class MimimumCoinChange {

	public void run() {

		Scanner sc = ReadInput.getScanner("coinChange");

		int sum = sc.nextInt();
		int size = sc.nextInt();

		int[] c = ReadInput.getIntArray(size, sc.next());

		int ways = dorun(c, sum);

		System.out.println(ways);
	}

	private int dorun(int[] c, int sum) {

		int[] T = new int[sum + 1];

		for (int i = 1; i < T.length; i++) {
			T[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < c.length; i++) {
			for (int j = 1; j < T.length; j++) {
				if(j >= c[i]){
					T[j] = Math.min(T[j],getVal(T[j-c[i]]));
				}
			}
			/*for(int k =0 ; k < T.length ; k++){
				System.out.print(T[k]+" ");
			}
			System.out.println();*/
		}
		
		return T[T.length-1];

	}

	private int getVal(int i) {
		if(i== Integer.MAX_VALUE){
			return Integer.MAX_VALUE;
		}
		return 1+i;
	}
}
