package com.cssolutions.dsalgo.priorityqueue

import java.util.*

class SlidingWindowMaximum {
    private var queue = PriorityQueue<Int>(reverseOrder())
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val result = mutableListOf<Int>()

        queue.addAll(nums.sliceArray(0 until k).asList())

        result.add(queue.peek())
        var i = k
        while (i < nums.size) {
            if (nums[i] <= queue.peek() && nums[i - k] < queue.peek()) {
                i++
                result.add(queue.peek())
                continue
            }
            queue = PriorityQueue<Int>(reverseOrder())
            queue.addAll(nums.sliceArray(i-k+1 ..i).asList())
            result.add(queue.peek())
            i++
        }
        return result.toIntArray()
    }
}

fun main() {
    println(
        SlidingWindowMaximum().maxSlidingWindow(intArrayOf(1,-1),1).joinToString()
    )
}