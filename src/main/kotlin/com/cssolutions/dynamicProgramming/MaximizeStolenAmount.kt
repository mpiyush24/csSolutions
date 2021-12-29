package com.cssolutions.dpworld

/**There are n houses build in a line, each of which contains some value in it.
 *  A thief is going to steal the maximal value of these houses,
 *  but he can’t steal in two adjacent houses because the owner of the stolen houses will tell his two neighbours
 *  left and right side. What is the maximum stolen value?
 *   Example: 6, 7, 1, 3, 8, 2, 4
 *
 */
class MaximizeStolenAmount {
    fun maximumValueStolen(nums: IntArray): Int {
        val maxStolen = MaxStolenAmount()
        calculateMaximumValueStolen(nums, 0, MaxStolenAmount(), maxStolen)
        return maxStolen.stolen
    }

    private fun calculateMaximumValueStolen(
        nums: IntArray,
        idx: Int,
        maxStolen: MaxStolenAmount,
        maxStolenSoFar: MaxStolenAmount
    ) {

        if (idx >= nums.size) {
            return
        }
        maxStolen.stolen += nums[idx]
        maxStolenSoFar.stolen = Math.max(maxStolen.stolen, maxStolenSoFar.stolen)
        calculateMaximumValueStolen(nums, idx + 2, maxStolen, maxStolenSoFar)
        maxStolen.stolen -= nums[idx]
        calculateMaximumValueStolen(nums, idx + 1, maxStolen, maxStolenSoFar)
    }

    fun maximumValueStolenDP(nums: IntArray): Int {

        if (nums.isEmpty()) {
            return 0
        }
        if (nums.size == 1) {
            return nums[0]
        }
        if (nums.size == 2) {
            return Math.max(nums[0], nums[1])
        }
        var firstVal = nums[0]
        var secondVal = Math.max(nums[0], nums[1])

        var result = 0
        for (i in 3 until nums.size) {
            result = Math.max(firstVal + nums[i], secondVal)
            // update the values. before moving to next
            firstVal = secondVal
            secondVal = result
        }
        return result
    }
    private data class MaxStolenAmount(var stolen: Int = 0)
}