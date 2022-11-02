package com.cssolutions.dsalgo.medium

/**
 * LC - 784
 * #maang
 */
class LetterCasePermutation {
    val gPerm = mutableListOf<String>()
    fun letterCasePermutation(s: String): List<String> {

        val permute = mutableListOf<Char>()

        permute(s.toCharArray(), permute, 0)

        return gPerm.toList();
    }

    fun permute(strArr: CharArray, perm: MutableList<Char>, i: Int) {

        if (perm.size == strArr.size) {
            gPerm.add(perm.joinToString())
            return
        }

        perm.add(strArr[i])
        permute(strArr, perm, i + 1)
        perm.removeAt(perm.lastIndex)

        if (strArr[i].toString().toIntOrNull() == null) {
            perm.add((strArr[i]).toString().reverseCase().toCharArray().first())
            permute(strArr, perm, i + 1)
            perm.removeAt(perm.lastIndex)
        }
    }
    fun String.reverseCase(): String = map { if (it.isUpperCase()) it.toLowerCase() else it.toUpperCase() }.joinToString("")
}
