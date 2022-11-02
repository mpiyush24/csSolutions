package com.cssolutions.dsalgo.array

/**
 * LC 128
 * #maang
 */

class LongestConsecutiveSeq {

    fun longestConsecutive(nums: IntArray): Int {

        if (nums.isEmpty()) return 0

        val numsMap = mutableMapOf<Int, Int>()
        var maxStreak = 1

        nums.forEach { numsMap[it] = numsMap.getOrDefault(it, 0) + 1 }

        val numsMapLeftStreak = mutableMapOf<Int, Int>()
        val numsMapRightStreak = mutableMapOf<Int, Int>()
        for (num in nums) {
            val streakLeft = findDecreasingStreakCount(num, numsMap, numsMapLeftStreak)
            val streakRight = findIncreasingStreakCount(num, numsMap, numsMapRightStreak)

            maxStreak = Math.max(maxStreak, streakLeft + streakRight - 1)
        }
        return maxStreak
    }

    fun findDecreasingStreakCount(n: Int, numsMap: Map<Int, Int>, streakCountMap: MutableMap<Int, Int>): Int {
        return if (streakCountMap[n] != null) {
            streakCountMap[n] ?: 0
        } else if (numsMap[n] == null) {
            0
        } else {
            val streak = 1 + findDecreasingStreakCount(n - 1, numsMap, streakCountMap)
            streakCountMap[n] = streak
            streak
        }
    }

    fun findIncreasingStreakCount(n: Int, numsMap: Map<Int, Int>, streakCountMap: MutableMap<Int, Int>): Int {
        return if (streakCountMap[n] != null) {
            streakCountMap[n] ?: 0
        } else if (numsMap[n] == null) {
            0
        } else {
            val streak = 1 + findIncreasingStreakCount(n + 1, numsMap, streakCountMap)
            streakCountMap[n] = streak
            streak
        }
    }

}