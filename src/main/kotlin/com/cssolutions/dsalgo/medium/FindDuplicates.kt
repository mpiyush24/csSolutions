package com.cssolutions.dsalgo.medium

class FindDuplicates {
    fun findDuplicate(nums: IntArray): Int {

        var slow = nums[0]
        var fast = nums[0]

        do {
            slow = nums[slow]
            fast = nums[nums[fast]]

        } while (slow != fast)

        fast = nums[0]

        do {
            slow = nums[slow]
            fast = nums[fast]
        } while (slow != fast)

        return fast
    }
}

