package com.cssolutions.dsalgo.array

class CarPooling {
    // time: o(n2) space: o(n)
    fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
        val auxArray = IntArray(1001) { 0 }
        for (trip in trips) {
            auxArray[trip[1]] += trip[0]
            auxArray[trip[2]] -= trip[0]
        }
        for (i in 1 until auxArray.size) {
            auxArray[i] += auxArray[i - 1]
            if (auxArray[i] > capacity) {
                return false
            }
        }
        return true;
    }
}