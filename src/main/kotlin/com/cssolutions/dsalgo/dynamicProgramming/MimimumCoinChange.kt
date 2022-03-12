package com.cssolutions.dsalgo.dynamicProgramming

import com.cssolutions.dsalgo.main.ReadInput

class MimimumCoinChange {
    fun run() {
        val sc = ReadInput.getScanner("coinChange")
        val sum = sc.nextInt()
        val size = sc.nextInt()
        val c = ReadInput.getIntArray(size, sc.next())
        val ways = dorun(c, sum)
        println(ways)
    }

    private fun dorun(c: IntArray, sum: Int): Int {
        val T = IntArray(sum + 1)
        for (i in 1 until T.size) {
            T[i] = Int.MAX_VALUE
        }
        for (i in c.indices) {
            for (j in 1 until T.size) {
                if (j >= c[i]) {
                    T[j] = Math.min(T[j], getVal(T[j - c[i]]))
                }
            }
            /*for(int k =0 ; k < T.length ; k++){
				System.out.print(T[k]+" ");
			}
			System.out.println();*/
        }
        return T[T.size - 1]
    }

    private fun getVal(i: Int): Int {
        return if (i == Int.MAX_VALUE) {
            Int.MAX_VALUE
        } else 1 + i
    }
}