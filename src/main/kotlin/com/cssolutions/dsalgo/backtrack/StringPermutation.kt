package com.cssolutions.dsalgo.backtrack

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

    fun permute1(str: String): List<String> {
        val track = mutableListOf<Char>()
        val charMap = mutableMapOf<Char, Int>()

        str.toCharArray().forEach { char ->
            charMap.putIfAbsent(char, 1)
        }
        val result = mutableListOf<String>()
        doPermute1(str.toCharArray(), charMap, track, result)
        return result.toList()

    }

    fun doPermute1(
        str: CharArray,
        charMap: MutableMap<Char, Int>,
        track: MutableList<Char>,
        result: MutableList<String>
    ) {
        if (track.size == str.size) {
            result.add(track.joinToString())
            return
        }
        for (entry in charMap) {

            val char = entry.key
            if(charMap[char] == 0) {
                continue
            }
            charMap[char] = 0
            track.add(char)
            doPermute1(str, charMap, track, result)
            track.removeAt(track.lastIndex)
            charMap[char] = 1
        }

    }

}