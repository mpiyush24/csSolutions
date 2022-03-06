package com.cssolutions.dsalgo.array

import java.util.*


class KthLargestNumber {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val pq = PriorityQueue<Int>()
        for (i in 0 until k) {
            pq.add(nums[i])
        }
        for (i in k until nums.size) {
            if (nums[i] > pq.peek()) {
                pq.poll()
                pq.add(nums[i])
            }
        }
        return pq.poll()
    }
}