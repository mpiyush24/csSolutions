package com.cssolutions.dsalgo.backtrack


class Powerset {
    val gPowerSet = mutableSetOf<List<Int>>()
    fun subsets(nums: IntArray): List<List<Int>> {

        if (nums.isEmpty()) return listOf()
        gPowerSet.add(listOf())
        for(i in nums.indices) {
            backtrack(nums, i, mutableListOf())
        }
        return gPowerSet.toList()
    }

    fun backtrack(nums: IntArray, i: Int, track: MutableList<Int>) {

        if (i > nums.size - 1) {
            return
        }
        track.add(nums[i])
        gPowerSet.add(ArrayList(track))
        backtrack(nums, i + 1, track)
        track.remove(track.lastIndex)
        gPowerSet.add(ArrayList(track))
    }

    fun subsetsAlt(nums: IntArray): List<List<Int>> {
        val list: MutableList<List<Int>> = ArrayList()
        //nums.sort()
        backtrack(list, ArrayList(), nums, 0)
        return list
    }

    private fun backtrack(list: MutableList<List<Int>>, tempList: MutableList<Int>, nums: IntArray, start: Int) {
        list.add(ArrayList(tempList))
        println(tempList)
        for (i in start until nums.size) {
            tempList.add(nums[i])
            backtrack(list, tempList, nums, i + 1)
            tempList.removeAt(tempList.size - 1)
        }
    }

    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val list: MutableList<List<Int>> = ArrayList()
        nums.sort()
        backtrackAlt(list, ArrayList<Int>(), nums, 0)
        return list
    }

    private fun backtrackAlt(list: MutableList<List<Int>>, tempList: MutableList<Int>, nums: IntArray, start: Int) {
        list.add(ArrayList(tempList))
        println(tempList)
        for (i in start until nums.size) {
            if (i > start && nums[i] == nums[i - 1]) continue  // skip duplicates
            tempList.add(nums[i])
            backtrackAlt(list, tempList, nums, i + 1)
            tempList.removeAt(tempList.size - 1)
        }
    }
}

