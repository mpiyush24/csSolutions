package com.cssolutions.dsalgo.dynamicProgramming

class BrokenCalculator {
    fun brokenCalc(startValue: Int, target: Int): Int {
        val sol = Sol()
        doBrokenCalc(startValue, target, sol, mutableSetOf(), 0)

        return sol.ans

    }

    fun doBrokenCalc(startValue: Int, target: Int, sol: Sol, encounteredVal: MutableSet<Int>, totalSteps: Int) {

        if (startValue <= 0 || startValue > target * 2 || encounteredVal.contains(startValue)) {
            return
        }
        if (startValue == target) {
            sol.ans = Math.min(totalSteps, sol.ans)
        }
        encounteredVal.add(startValue)
        doBrokenCalc(startValue - 1, target, sol, encounteredVal, totalSteps + 1)
        doBrokenCalc(startValue * 2, target, sol, encounteredVal, totalSteps + 1)

    }

}

data class Sol(
    var ans: Int = Int.MAX_VALUE
)