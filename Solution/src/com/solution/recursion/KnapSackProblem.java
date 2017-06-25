package com.solution.recursion;

import java.util.Scanner;

import com.solution.main.ReadInput;

public class KnapSackProblem {

	public void run() {

		Scanner sc = ReadInput.getScanner("knapsack");
		sc.useDelimiter("\n");
		int size = sc.nextInt();
		int rw = sc.nextInt();

		
		String[] weight = sc.next().split(" ");
		String[] val = sc.next().split(" ");

		int[] w = new int[size];
		int[] v = new int[size];
		
		for(int i=0; i < size ; i++){
			w[i] = Integer.parseInt(weight[i]);
			v[i] = Integer.parseInt(val[i]);
		}
		
		System.out.println(doRun(w,v,rw,0,0));
		
	}
	/**
	 * 
	 * @param weight array
	 * @param val array
	 * @param w required weight
	 * @param v required value
	 * @param itemNumber current Item 
	 */
	private int doRun(int[] weight , int[] val , int w , int v , int itemNumber){
		if(w ==0 || itemNumber == weight.length ){
			return 0;
		}
		
		if(w < weight[itemNumber]) {
			return doRun(weight, val, w, v, itemNumber+1);
		}
		
		int lmax = val[itemNumber] + doRun(weight, val, w - weight[itemNumber] , v + val[itemNumber], itemNumber+1);
		int rmax = doRun(weight, val, w , v , itemNumber+1);
				
		return Math.max(lmax, rmax);
	}

}
