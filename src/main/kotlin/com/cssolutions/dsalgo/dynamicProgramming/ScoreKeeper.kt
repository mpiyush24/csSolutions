package com.cssolutions.dsalgo.dynamicProgramming

/*
Design a system which takes List of scores and then calculate total score based on the followin rule.

If score is an integer, Positive or Negative take the score as its Face Value
If Score is `X`: Score is Twice the score of the last throw.
If Score is `+` : Score is the sum of the score of last 2 Scores.
If Score is `Z` : This undo the score of the last turn as if it never happened.

Example: Scores: [5, -2, 4, Z, X, 9, +,+ ]
Total Score = 27

Explanation:
For the 1st Throw the total score is : 5.
For the 2nd Throw, the total score is : 5 + (-2) = 3.
For the 3rd Throw. the total score is : 3 + (4) = 7
For the 4th Throw. the last throw was discarded which brings back the score to 3
For the 5th Throw. the total score is double the score of the last throw (3rd throw) = 3 + (2 * -2) = -1
For the 6th Throw. the total score is : -1 + (9)  = 8
For the 7rd Throw. the total score is : 8 + ( 9 + (-4)) = 13
For the 8rd Throw. the total score is : 13 + (5 + 9) = 27
 */

fun scoreKeeper(num: Int , blocks: List<String>) : Int {
    val scorePerTurn = Array(num) {0}
    val cumulative = Array(num) {0}

    for( i in 0 until num) {
        val score = blocks[i]
        if(score == "X") {
            scorePerTurn[i] = getValueFromArray(scorePerTurn, i - 1) * 2
            cumulative[i] = getValueFromArray(cumulative, i-1) + getValueFromArray(scorePerTurn, i )
        } else if(score == "Z") {
            scorePerTurn[i] = getValueFromArray(scorePerTurn, i - 2 )
            scorePerTurn[i-1] = getValueFromArray(scorePerTurn, i-3)
            cumulative[i] = getValueFromArray(cumulative, i-2)
            cumulative[i-1] = getValueFromArray(cumulative, i-3)

        } else if(score == "+") {
            scorePerTurn[i] = getValueFromArray(scorePerTurn, i - 1) + getValueFromArray(scorePerTurn, i - 2)
            cumulative[i] = getValueFromArray(cumulative, i-1) + getValueFromArray(scorePerTurn, i)
        } else {
            scorePerTurn[i] = score.toInt()
            cumulative[i] = getValueFromArray(cumulative, i -1) + scorePerTurn[i]
        }
    }

    print("ScorePerTurn"); scorePerTurn.forEach { print ("$it ") }
    print("cumulativeScore"); cumulative.forEach { print ("$it ") }

    return cumulative[cumulative.size - 1 ]
}

fun getValueFromArray(arr: Array<Int>, index: Int ) = if(index < 0) 0 else arr[index]
