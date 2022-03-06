package com.cssolutions.dsalgo.main

import com.cssolutions.dsalgo.dynamicProgramming.LCSeq
import com.cssolutions.dynamicProgramming.LCSubString
import com.cssolutions.dynamicProgramming.LongestIncreasingSubset
import com.cssolutions.dsalgo.dynamicProgramming.LongestPalindromSubsequence
import com.cssolutions.dsalgo.dynamicProgramming.MimimumCoinChange
import com.cssolutions.dsalgo.dynamicProgramming.RodCuttingMinimizeCost
import com.cssolutions.dynamicProgramming.SubsetSum
import com.cssolutions.dsalgo.tree.LevelOrderTraversal
import com.cssolutions.dsalgo.tree.TopView
import com.cssolutions.dsalgo.tree.ValidBST
import java.io.FileNotFoundException

object Solution {
    @Throws(FileNotFoundException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        /**** Back Tracking  */
        ValidBST().run()
        LCSeq().run()
        LCSubString().run()
        MimimumCoinChange().run()
        SubsetSum().run()
        LongestIncreasingSubset().run()
        LongestPalindromSubsequence().run()
        RodCuttingMinimizeCost().run()
        LevelOrderTraversal().run()
        TopView().run()
    }
}