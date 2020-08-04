package com.cssolutions.ds

import com.cssolutions.main.ReadInput
import java.io.FileNotFoundException
import java.util.*

class BalancedExpression {
    @Throws(FileNotFoundException::class)
    fun run() {
        val sc = ReadInput.getScanner("balancedExpression")
        val expr = sc.next()
        doRun(expr)
    }

    private fun doRun(expr: String) {
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
        if (s.isEmpty() && i == expr.length) {
            println("Balanced Expression")
        } else {
            println("Unbalanced Expression")
        }
    }
}