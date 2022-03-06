package com.cssolutions.dsalgo.backtrack

object Parenthesis {

    fun printValidParenthesisCombinations(pairCount: Int) {

        val results: MutableList<String> = mutableListOf()
        val charArrayHolder = CharArray(2*pairCount)
        generateAllCombination(charArrayHolder, 0, pairCount, results)
    }

    fun generateAllCombination(resultArray: CharArray, pos: Int, n: Int, results: MutableList<String>) {
        if(pos == resultArray.size ) {
            if(validateParenthesisExpr(resultArray, pos))
                println(resultArray)
        }
        else {
            resultArray[pos] = '('
            generateAllCombination(resultArray, pos +1, n, results)
            resultArray[pos] = ')'
            generateAllCombination(resultArray, pos +1, n, results)
        }
    }
    fun validateParenthesisExpr(intermediateResultHolder: CharArray, pos: Int): Boolean {
        var balance = 0;
        for(i in 0..pos-1 ) {
            if(intermediateResultHolder[i] == '(') balance ++ else balance --;
            if(balance < 0 ) return false
        }
        return (balance == 0)
    }
}