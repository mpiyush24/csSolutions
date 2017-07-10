package com.solution.main;

import java.io.FileNotFoundException;

import com.solution.array.LocalMaxima;
import com.solution.array.MatrixSpiralForm;
import com.solution.array.RotateArray;
import com.solution.backtrack.NQueenProblem;
import com.solution.backtrack.StringPermeutation;
import com.solution.dynamicP.MimimumCoinChange;
import com.solution.dynamicP.RodCuttingMinimizeCost;
import com.solution.dynamicP.KnapSack01;
import com.solution.dynamicP.LCSeq;
import com.solution.dynamicP.LCSubString;
import com.solution.dynamicP.LongestIncreasingSubset;
import com.solution.dynamicP.LongestPalindromSubsequence;
import com.solution.dynamicP.SubsetSum;
import com.solution.tree.LevelOrderTraversal;
import com.solution.tree.TopView;
import com.solution.tree.ValidBST;
import com.solution.ds.BalancedExpression;;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {

		/**** Back Tracking ********/
		// new NQueenProblem().run();
		/**** Tree *****************/
		// new ValidBST().run();
		// new KnapSack01().run();
		// new LCSeq().run();
		// new LCSubString().run();
		// new MimimumCoinChange().run();
		// new StringPermeutation().run();
		// new SubsetSum().run();
		// new LongestIncreasingSubset().run();
		// new LongestPalindromSubsequence().run();
		// new MatrixSpiralForm().run();
		// new RotateArray().run();
		// new BalancedExpression().run();
		//new RodCuttingMinimizeCost().run();
		//new LevelOrderTraversal().run();
		//new TopView().run();
		new LocalMaxima().run();
		
	}

}
