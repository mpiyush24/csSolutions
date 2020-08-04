package com.cssolutions.backtrack

import com.cssolutions.main.ReadInput

class StringPermutation {
    fun run() {
        val sc = ReadInput.getScanner("permute")
        val str = sc.next()
        doPermute(str, 0, str.length - 1)
    }

    private fun doPermute(str: String, l: Int, r: Int) {
        var str = str
        if (l == r) println(str) else {
            for (i in l..r) {
                str = swap(str, l, i)
                doPermute(str, l + 1, r)
                str = swap(str, l, i)
            }
        }
    }

    private fun swap(str: String, i: Int, j: Int): String {
        val chr = str.toCharArray()
        val c = chr[i]
        chr[i] = chr[j]
        chr[j] = c
        //System.out.println("Original String: "+str+" Replaced String: "+result);
        return String(chr)
    }
}