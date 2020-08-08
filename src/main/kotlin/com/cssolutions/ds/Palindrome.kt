package com.cssolutions.ds

fun isPalindrome(integer: Int): Boolean {

    val numberAsString = integer.toString()

    var i = 0
    var j = numberAsString.length - 1
    var isPalindrome = true
    while (i <= j) {

        if (numberAsString[i] != numberAsString[j]) {
            isPalindrome = false
            break
        } else {
            i++;j--
        }
    }
    return isPalindrome
}