package com.cssolutions.dynamicProgramming

import com.cssolutions.main.ReadInput

class LongestIncreasingSubset {
    fun run() {
        val sc = ReadInput.getScanner("longestIncreasingSubset")
        val size = sc.nextInt()
        val arr = ReadInput.getIntArray(size, sc.next())
        println(doRun(arr))
    }

    private fun doRun(nums: IntArray): Int {
        val numsLIS = IntArray(nums.size) { 1 }
        for (i in nums.indices) {
            for (j in i - 1 until 0 step -1) {
                if (nums[j] < nums[i])
                    numsLIS[i] = Math.max(numsLIS[i], nums[j] + 1)
            }
        }

        return numsLIS.maxOrNull() ?: 1
    }
}