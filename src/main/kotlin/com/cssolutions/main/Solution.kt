package com.cssolutions.main

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