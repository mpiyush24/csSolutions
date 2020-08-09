package com.cssolutions.algorithm.medium

import java.util.function.BiFunction

/*We are given two arrays A and B of words.  Each word is a string of lowercase letters.

Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.  For example, "wrr" is a subset of "warrior", but is not a subset of "world".

Now say a word a from A is universal if for every b in B, b is a subset of a.

Return a list of all universal words in A.  You can return the words in any order.



Example 1:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
Output: ["facebook","google","leetcode"]
Example 2:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
Output: ["apple","google","leetcode"]
Example 3:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
Output: ["facebook","google"]
Example 4:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
Output: ["google","leetcode"]
Example 5:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo"]
Output: ["facebook","leetcode"]
*/

fun getWordSubSet(A: Array<String>, B: Array<String>): List<String> {
    val charMapInput = mutableMapOf<Char, Int>()

    B.forEach { buildCharMapFromString(it, charMapInput) }

    val resultArray = mutableListOf<String>()
    A.forEach {
        val charMap = buildCharMapFromString(it)
        val allCharPresent = charMapInput.filter { itr -> charMap[itr.key] ?: 0 < itr.value }.isEmpty()
        if (allCharPresent) resultArray.add(it)
    }
    return resultArray
}

private fun buildCharMapFromString(str: String, charMap: MutableMap<Char, Int> = mutableMapOf()): Map<Char, Int> {
    str.forEach {
        if (charMap.contains(it)) {
            charMap[it] = charMap[it]!!.plus(1)
        } else {
            charMap[it] = 1
        }
    }
    return charMap
}