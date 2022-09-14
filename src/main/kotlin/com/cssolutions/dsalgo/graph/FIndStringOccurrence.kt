package com.cssolutions.dsalgo.graph

/*
LC-28
 */
class FindStringOccurrence {

    fun strStr(haystack: String, needle: String): Int {
        val needleCharArray = needle.toCharArray()
        val haystackCharArray = haystack.toCharArray()
        for (idx in haystack.indices) {
            if (needleCharArray.first() == haystackCharArray[idx]) {
                if (idx + needleCharArray.size <= haystack.length) {
                    val substring = haystack.substring(idx, idx + needleCharArray.size)
                    if (substring == needle) {
                        return idx
                    }
                }
            }
        }
        return -1
    }
}