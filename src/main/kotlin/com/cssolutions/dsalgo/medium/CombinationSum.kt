package com.cssolutions.dsalgo.medium

object CombinationSum {

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val results = mutableListOf<List<Int>>();
        getCombinationSum(candidates, results, mutableListOf(), target, 0)
        return results
    }
    fun getCombinationSum(
        candidates: IntArray,
        results: MutableList<List<Int>>,
        localSum: MutableList<Int>,
        remainingSum: Int,
        startIdx: Int
    ) {

        if (remainingSum == 0) {
            results.add(localSum.toList())
            return
        }

        if (remainingSum < 0 || startIdx == candidates.size) {
            return
        }
        localSum.add(candidates[startIdx])
        getCombinationSum(candidates, results, localSum, remainingSum - candidates[startIdx], startIdx)
        localSum.removeAt(localSum.size - 1)
        getCombinationSum(candidates, results, localSum, remainingSum, startIdx + 1)
    }

}

