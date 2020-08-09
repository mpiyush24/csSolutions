package com.cssolutions.algorithm

fun matchRegularExpression(inputString: String, pattern: String): Boolean {

    var isMatch = true
    var i = 0
    var j = 0
    while (j < pattern.length) {
        if (j != pattern.length - 1 && pattern[j + 1] == '*') {
            val patternCharToMatch = pattern[j]
            if (patternCharToMatch == '.') {
                if (j >= pattern.length - 2) {
                    i = inputString.length
                } else {
                    while (i < inputString.length && inputString[i] != pattern[j + 2]) {
                        i++
                    }
                    if (i == inputString.length) {
                        isMatch = false
                    }
                }
            } else {
                while (i < inputString.length && inputString[i] == patternCharToMatch) {
                    i++
                }
            }
            for (k in j + 1 until pattern.length) {
                if (pattern[k] == '*' || patternCharToMatch == pattern[k]) {
                    j++
                } else {
                    break
                }
            }
            j++
        } else if (pattern[j] == '.') {
            i++; j++
        } else {
            if (i == inputString.length) {
                if (inputString[i - 1] == pattern[j]) {
                    j++
                } else {
                    i++
                }
            } else if (i < inputString.length && pattern[j] != inputString[i]) {
                isMatch = false
                break
            } else {
                i++;j++
            }
        }
    }
    if (i != inputString.length || !(i == inputString.length && j == pattern.length)) {
        isMatch = false // Complete inputString was not processed
    }
    return isMatch
}