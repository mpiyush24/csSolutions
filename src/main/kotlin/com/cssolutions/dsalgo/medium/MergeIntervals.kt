package com.cssolutions.dsalgo.medium

class MergeIntervals {

    fun solve(intervals: Array<IntArray>): Array<IntArray> {
        val sortedIntervals = intervals.sortedWith(compareBy { it[0] }).toTypedArray()
        val deque = ArrayDeque<IntArray>()
        deque.addFirst(sortedIntervals[0])
        for (idx in 1 until sortedIntervals.size ) {
            val previousInterval = deque.first()
            if(sortedIntervals[idx][0] <= previousInterval[1]) {
                deque.removeFirst()
                deque.addFirst(intArrayOf(previousInterval[0], Math.max(previousInterval[1], sortedIntervals[idx][1])))
            } else {
                deque.addFirst(sortedIntervals[idx])
            }
        }
        val result = mutableListOf<IntArray>()

        while (deque.isNotEmpty()) {
            result.add(deque.removeFirst())
        }
        return result.reversed().toTypedArray()
    }
}