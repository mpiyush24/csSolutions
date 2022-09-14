package com.cssolutions.dsalgo.backtrack

/**
 * LC 47.
 */
class PermutationII {
    val gSet = mutableSetOf<String>()
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val result = mutableSetOf<List<Int>>()
        permute(nums, 0, nums.size - 1, result)
        return result.toList()
    }

    fun permute(nums: IntArray, l: Int, r: Int, result: MutableSet<List<Int>>) {

        if (l == r) {
            result.add(nums.toList())
            return
        }
        for (i in l..r) {
            swap(nums, l, i)
            permute(nums, l + 1, r, result)
            swap(nums, l, i)
        }
    }

    fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }

//    fun permuteUnique(nums: IntArray): List<List<Int>> {
//        val result = mutableListOf<List<Int>>()
//        val countMap = mutableMapOf<Int, Int>()
//        nums.forEach {
//            countMap[it] = countMap.getOrDefault(it, 0) + 1
//        }
//        permuteUniqueBacktrack(result, mutableListOf(), nums, countMap)
//        return result
//    }

//    private fun permuteUniqueBacktrack(result: MutableList<List<Int>>, track: MutableList<Int>, nums: IntArray, countMap: MutableMap<Int, Int>) {
//        if (track.size == nums.size) {
//            result.add(track.toList())
//            return
//        }
//
//        // A key insight to avoid generating any redundant permutation is that at each step rather than viewing each number as a candidate,
//        // we consider each unique number as the true candidate.
//        // For instance, at the very beginning, given in the input of [1, 1, 2], we have only two true candidates instead of three.
//        for (entry in countMap) {
//            val count = entry.value
//            if (count == 0) {
//                continue
//            }
//            val num = entry.key
//            // Add this number into the current combination.
//            countMap[num] = count - 1
//            track.add(num)
//
//            // Continue the exploration.
//            permuteUniqueBacktrack(result, track, nums, countMap)
//
//            // Revert the choice for the next exploration.
//            track.removeAt(track.lastIndex)
//            countMap[num] = count
//        }
//    }
}