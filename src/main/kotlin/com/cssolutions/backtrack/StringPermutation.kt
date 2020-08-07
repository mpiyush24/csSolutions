package com.cssolutions.backtrack

class StringPermutation {

    fun doPermute(str: String, l: Int, r: Int, result: MutableList<String>) {
        var str = str
        if (l == r) result.add(str) else {
            for (i in l..r) {
                str = swap(str, l, i)
                doPermute(str, l + 1, r, result)
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