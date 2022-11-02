package com.cssolutions.dsalgo.dynamicProgramming;


class EqualPartitionSubsetSum {
    fun canPartition(nums: IntArray):

            Boolean {

        val sum = nums.fold(0) { x, y ->
            x + y
        };
        if (sum % 2 != 0) {
            return false
        }
        val target = sum / 2
        val dp = Array(nums.size + 1) { IntArray(target + 1) { -1 } }
        return isPartitionPossible(nums, 0, target, dp)

    }

    fun isPartitionPossible(nums: IntArray, idx: Int, target: Int, dp: Array<IntArray>):

            Boolean {
        if (target == 0) {
            return true
        }
        if (target < 0 || idx >= nums.size) {
            return false
        }
        if (dp[idx][target] != -1) {
            return dp[idx][target] == 1
        }
        val partitionPossible =
            isPartitionPossible(nums, idx + 1, target - nums[idx], dp) || isPartitionPossible(nums, idx + 1, target, dp)
        dp[idx][target] = if (partitionPossible) 1 else 0
        return partitionPossible
    }
}