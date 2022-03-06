package com.cssolutions.dsalgo.easy

import java.util.*

class BalancedExpression {

    fun execute(expr: String) : Boolean {
        val s: Stack<Char> = Stack()
        var i = 0
        while (i < expr.length) {
            if (expr[i] == '(' || expr[i] == '{' || expr[i] == '[') {
                s.push(expr[i])
            } else if (expr[i] == ')' || expr[i] == '}' || expr[i] == ']') {
                val q = expr[i]
                val p = s.peek() as Char
                if (p == '(' && q != ')' || p == '{' && q != '}' || p == '[' && q != ']') {
                    break
                } else {
                    s.pop()
                }
            }
            i++
        }
        return s.isEmpty() && i == expr.length
    }
}