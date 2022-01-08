package com.cssolutions.array

class MaximumElementSubarray {
    fun solution(arr: Array<Int>): Int {
        // Count of elements between ith and next smallest element toward right
        val rightMin = createRightMin(arr)
        // Count of elements between ith and next smallest element toward left
        val leftMin = createLeftMin(arr)

        val result = Array(arr.size) { 0 }

        for (idx in arr.indices) {
            /**
             * suppose we want to find total number of subsets formed by using element at X position when elements are arranged
             * like G1...X...G2. where G1 is a group of elements on the left of X and G2 is group of elements in the right
             * So Total number of subsets = (G1+1) * (G2+1)
             * Explanation:
             * Total Sets possible = (n*(n+1))/2 ==> ((G1 + X + G2)(G1 + X + G2))/2 , X is a single element so ((G1+G2+1)(G1+G2+2))/2 == Eq A
             * Total Number of Sets formed without X = Total Sets formed by G1 + Total Sets formed by G2
             * G1*(G1+1)/2 + G2*(G2+1)/2 == Eq B
             * Sets formed by including X = All possible sets - sets which exclude X ==> Eq B - Eq A = (G1+1) * (G2+1)
             */
            result[idx] = arr[idx] * (leftMin[idx] + 1) * (rightMin[idx] + 1)
        }

        println(rightMin.joinToString())
        println(leftMin.joinToString())

        return result.fold(0) { x, y -> x + y }
    }

    // Create the right min array, moving from first index to last Index
    fun createRightMin(arr: Array<Int>): Array<Int> {
        val deque = ArrayDeque<Int>()
        val rightMin = Array(arr.size) { 0 }

        for (ele_idx in arr.indices) {
            if (deque.isEmpty()) deque.addFirst(ele_idx) else {
                // Create a Max stack (top element is always the Maximum),
                // Whenever the element in the stack is greater than the incoming element, pop that from the stack
                // the incoming element is the next smallest element for the popped element.
                while (deque.isNotEmpty() && arr[deque.first()] > arr[ele_idx]) {
                    deque.removeFirst().let {
                        //Store the total elements between the smallest element and the element at index ele_idx
                        rightMin[it] = ele_idx - it - 1 // -1 to exclude the minimum element itself.
                    }
                }
                deque.addFirst(ele_idx)
            }
        }
        // If the deque is not empty, that means there are certain elements for which there was no smaller element found after their position
        while (deque.isNotEmpty()) deque.removeFirst().let {
            // If there are no elements smaller than the element, the should be able to form subsets with the entire remaining array.
            rightMin[it] = arr.size - it - 1
        }
        return rightMin
    }

    // Create the left min array, moving from last index to first Index
    fun createLeftMin(arr: Array<Int>): Array<Int> {
        val deque = ArrayDeque<Int>()
        val leftMin = Array(arr.size) { 0 }

        for (ele_idx in arr.indices.reversed()) {
            if (deque.isEmpty()) deque.addFirst(ele_idx)
            else {
                while (deque.isNotEmpty() && arr[deque.first()] > arr[ele_idx]) {
                    deque.removeFirst().let {
                        leftMin[it] = it - ele_idx - 1
                    }
                }
                deque.addFirst(ele_idx)
            }
        }
        while (deque.isNotEmpty()) deque.removeFirst().let { leftMin[it] = it }
        return leftMin
    }
}