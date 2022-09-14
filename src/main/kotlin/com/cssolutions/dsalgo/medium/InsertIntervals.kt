package com.cssolutions.dsalgo.medium

class InsertIntervals {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        if(intervals.isEmpty()) return arrayOf(newInterval)
        var idx = 0;
        val result = mutableSetOf<IntArray>()
        var intervalToMerge = newInterval
        while (idx < intervals.size) {
            val currentInterval = intervals[idx]
            if (intervalToMerge[0] >= currentInterval[0]) {
                if (intervalToMerge[0] > currentInterval[1]) {
                    // currentInterval is non-overlapping and smaller than intervalToMerge,Add Current Interval and proceed.
                    result.add(currentInterval)
                } else if (intervalToMerge[1] <= currentInterval[1]) {
                    // Interval to Merge is completely contained in the currentInterval, we are done here, mark this
                    // Interval to be the one for merge and increment the index before breaking, to ensure this interval is not
                    // not processed twice.
                    intervalToMerge = currentInterval
                    idx++
                    break
                } else {
                    intervalToMerge = mergeInterval(currentInterval, intervalToMerge)
                }
            } else {
                // Not an overlapping Interval
                if (intervalToMerge[1] < currentInterval[0]) {
                    break
                } else {
                    intervalToMerge = mergeInterval(currentInterval, intervalToMerge)
                }
            }
            idx++
        }
        result.add(intervalToMerge)
        for(i in idx until intervals.size) result.add(intervals[i])
        return result.toTypedArray()
    }

    fun mergeInterval(interval1: IntArray, interval2: IntArray): IntArray {

        val start = Math.min(interval1[0], interval2[0])
        val end = Math.max(interval1[1], interval2[1])

        return intArrayOf(start, end)

    }
}