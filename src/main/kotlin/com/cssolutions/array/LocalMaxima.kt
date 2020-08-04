package com.cssolutions.array

import java.util.*
import com.cssolutions.main.ReadInput

class LocalMaxima {
    fun run() {
        val sc: Scanner = ReadInput.getScanner("localMaxima")
        val size: Int = sc.nextInt()
        val array: String = sc.next()
        val arr = ReadInput.getIntArray(size, array)
        doMaxima(arr, 0, arr.size - 1)
    }

    private fun doMaxima(arr: IntArray, beginIndex: Int, endIndex: Int) {
        val e_index = (beginIndex + endIndex) / 2
        if (e_index > 0 && e_index < arr.size - 1) {
            if (arr[e_index] >= arr[e_index - 1] && arr[e_index] >= arr[e_index + 1]) {
                System.out.println(arr[e_index])
                return
            } else if (arr[e_index] > arr[e_index - 1] && arr[e_index] < arr[e_index + 1]) {
                doMaxima(arr, e_index + 1, endIndex)
            } else {
                doMaxima(arr, beginIndex, e_index - 1)
            }
        }
        //Edge case
        if (e_index == 0) {
            doMaxima(arr, e_index + 1, endIndex)
        }
    }
}