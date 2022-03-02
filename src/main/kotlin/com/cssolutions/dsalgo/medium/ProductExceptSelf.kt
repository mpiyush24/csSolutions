package com.cssolutions.dsalgo.medium

class ProductExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {

        val zeroFreq= nums.filter { it==0 }.size

        if(zeroFreq > 1) {
            return IntArray(nums.size){0}
        }


        val sum = nums.fold(1) { x, y -> if (y != 0) x * y else x }

        val result = IntArray(nums.size)

        for (idx in nums.indices) {

            if (zeroFreq==1) {
                if (nums[idx] == 0) {
                    result[idx] = sum
                } else {
                    result[idx] = 0
                }
            } else {
                result[idx] = sum / nums[idx]
            }

        }
        return result
    }
}