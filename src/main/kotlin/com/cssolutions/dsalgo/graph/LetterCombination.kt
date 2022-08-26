package com.cssolutions.dsalgo.graph

/**
 * Classic phone digit keypad to text
 */
class LetterCombination {
    private val digitAlphaMap = mapOf(
        '2' to listOf("a", "b", "c"),
        '3' to listOf("d", "e", "f"),
        '4' to listOf("g", "h", "i"),
        '5' to listOf("j", "k", "l"),
        '6' to listOf("m", "n", "o"),
        '7' to listOf("p", "q", "r", "s"),
        '8' to listOf("t", "u", "v"),
        '9' to listOf("w", "x", "y", "z"))

    fun letterCombinations(digits: String): List<String> {

        val results = mutableListOf<String>()
        combination(digits.toCharArray(), 0, results,"")
        return results.toList()
    }

    fun combination(digits: CharArray, idx: Int, result: MutableList<String>, comb: String) {

        if(idx == digits.size) {
            result.add(comb)
            return
        }

        val charList = digitAlphaMap[digits[idx]]!!

        for(character in charList) {
            combination(digits, idx+1, result, "$comb$character")
        }
    }
}