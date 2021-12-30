package com.cssolutions.array

// Find Pair for REPEATING set of integers.
// Example: 1,5,3,3,3 returns 4
// Explanation: 1+5, 3+3 (2nd and 3th), 3+3 (3rd and 4th), 3+3 (4th and 5th)
class PairSum {
    fun numberOfWays(arr: Array<Int>, k: Int): Int {

        val freqMap = mutableMapOf<Int, Int>()
        var result = 0
        for(i in arr.indices) freqMap[arr[i]] = freqMap.getOrDefault(arr[i], 0) + 1

        for(item in freqMap) {
            if (item.key == k/2){
                result+= ((freqMap[item.key]?:0)*((freqMap[item.key]?:0)-1))/2
            }
            else if(item.key < k/2) {
                result+=((freqMap[item.key]?:0)*(freqMap[k - item.key]?:0))
            }
        }
        return result;
    }
}