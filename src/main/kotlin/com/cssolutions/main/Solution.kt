package com.cssolutions.main

import com.cssolutions.array.LocalMaxima
import com.cssolutions.array.MatrixSpiralForm
import com.cssolutions.array.RotateArray
import com.cssolutions.backtrack.NQueenProblem
import com.cssolutions.backtrack.StringPermutation
import com.cssolutions.ds.BalancedExpression
import com.cssolutions.dynamicProgramming.KnapSack01
import com.cssolutions.dynamicProgramming.LCSeq
import com.cssolutions.dynamicProgramming.LCSubString
import com.cssolutions.dynamicProgramming.LongestIncreasingSubset
import com.cssolutions.dynamicProgramming.LongestPalindromSubsequence
import com.cssolutions.dynamicProgramming.MimimumCoinChange
import com.cssolutions.dynamicProgramming.RodCuttingMinimizeCost
import com.cssolutions.dynamicProgramming.SubsetSum
import com.cssolutions.tree.LevelOrderTraversal
import com.cssolutions.tree.TopView
import com.cssolutions.tree.ValidBST
import java.io.FileNotFoundException

object Solution {
    @Throws(FileNotFoundException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        /**** Back Tracking  */
        NQueenProblem().run()
        ValidBST().run()
        KnapSack01().run()
        LCSeq().run()
        LCSubString().run()
        MimimumCoinChange().run()
        StringPermutation().run()
        SubsetSum().run()
        LongestIncreasingSubset().run()
        LongestPalindromSubsequence().run()
        MatrixSpiralForm().run()
        RotateArray().run()
        BalancedExpression().run()
        RodCuttingMinimizeCost().run()
        LevelOrderTraversal().run()
        TopView().run()
    }
}