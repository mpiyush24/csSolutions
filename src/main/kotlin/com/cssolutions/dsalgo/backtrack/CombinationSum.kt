package com.cssolutions.dsalgo.backtrack

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

 Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.
 */
class CombinationSum {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableSetOf<List<Int>>()
        findCombinationSum2(candidates, result, 0, mutableListOf(), target)
        return result.toList()
    }

    fun findCombinationSum2(candidates: IntArray, finalResult: MutableSet<List<Int>>, idx: Int, possibleCandidate: MutableList<Int>, remainingSum: Int) {
        if(remainingSum == 0) {
            finalResult.add(possibleCandidate.toList().sorted())
            return
        }
        if(remainingSum < 0 || idx == candidates.size) { return }
        // Include it in the sum.
        possibleCandidate.add(candidates[idx])
        findCombinationSum2(candidates, finalResult, idx + 1, possibleCandidate, remainingSum - candidates[idx])
        possibleCandidate.remove(candidates[idx]) // Exlcude this candidate and then find the sum.
        findCombinationSum2(candidates, finalResult, idx + 1, possibleCandidate, remainingSum)
    }
}