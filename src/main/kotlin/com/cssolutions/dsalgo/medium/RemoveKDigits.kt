package com.cssolutions.dsalgo.medium

import java.lang.StringBuilder

class RemoveKDigits {

    fun solve(num: String, k: Int): String {
        val charArray = num.toCharArray()
        val deque = ArrayDeque<Char>()
        var charToRemove = k;

        charArray.map { ch ->
            while (charToRemove > 0 && deque.isNotEmpty() && deque.first() > ch) {
                deque.removeFirst();
                charToRemove -= 1;
            }
            if (deque.isNotEmpty() || ch != '0') { // add 0 only if deque is not empty, to ensure we do not end up with leading 0
                deque.addFirst(ch)
            }
        }

        while (deque.isNotEmpty() && charToRemove > 0) {
            deque.removeFirst()
            charToRemove--
        }

        if (deque.isEmpty()) {
            return "0"
        }
        val sb = StringBuilder()

        while (deque.isNotEmpty()) {
            sb.append(deque.removeFirst())
        }
        return sb.reverse().toString()
    }


}