package com.cssolutions.dsalgo.backtrack

object Parenthesis {
    val ans = mutableSetOf<String>()
    val validPar = listOf("(", ")")

    fun printValidParenthesisCombinations(pairCount: Int) {

        val results: MutableList<String> = mutableListOf()
        val charArrayHolder = CharArray(2 * pairCount)
        generateAllCombination(charArrayHolder, 0, pairCount, results)
    }

    fun generateAllCombination(resultArray: CharArray, pos: Int, n: Int, results: MutableList<String>) {
        if (pos == resultArray.size) {
            if (validateParenthesisExpr(resultArray, pos))
                println(resultArray)
        } else {
            resultArray[pos] = '('
            generateAllCombination(resultArray, pos + 1, n, results)
            resultArray[pos] = ')'
            generateAllCombination(resultArray, pos + 1, n, results)
        }
    }

    fun validateParenthesisExpr(intermediateResultHolder: CharArray, pos: Int): Boolean {
        var balance = 0;
        for (i in 0..pos - 1) {
            if (intermediateResultHolder[i] == '(') balance++ else balance--;
            if (balance < 0) return false
        }
        return (balance == 0)
    }

    // Alternate
    fun generateParenthesis(n: Int): List<String> {
        backtrack(n * 2, "")
        return ans.toList()

    }

    fun backtrack(size: Int, str: String) {

        if (str.length > size) {
            return
        }

        if (str.length == size) {
            if (validExpr(str)) {
                ans.add(str)
            }
            return
        }
        var temp = str
        for (par in validPar) {
            temp = temp.plus(par)
            backtrack(size, temp)
            temp.dropLast(1)
        }
    }

    fun validExpr(str: String): Boolean {

        val q = ArrayDeque<Char>()

        q.add(str.get(0))

        for (i in 1 until str.length) {
            if (str.get(i) == ')') {
                q.removeFirst()
            } else {
                q.addFirst(str.get(i))
            }
        }

        return q.isEmpty()

    }
}