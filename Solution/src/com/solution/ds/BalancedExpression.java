package com.solution.ds;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class BalancedExpression {

	public void run() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("resource/balancedExpression"));

		String expr = sc.next();

		doRun(expr);

	}

	private void doRun(String expr) {
		Stack s = new Stack<>();

		int i = 0;
		while (i < expr.length()) {
			if (expr.charAt(i) == '(' || expr.charAt(i) == '{' || expr.charAt(i) == '[') {
				s.push(expr.charAt(i));
			} else if (expr.charAt(i) == ')' || expr.charAt(i) == '}' || expr.charAt(i) == ']') {
				char q = expr.charAt(i);
				char p = (char) s.peek();
				if(p=='(' && q!=')' ||p=='{' && q!='}' ||p=='[' && q!=']' ){
					break;
				}
				 else {
					s.pop();
				}	
			}
			i++;
		}
		if(s.isEmpty() && i==expr.length()){
			System.out.println("Balanced Expression");
		} else {
			System.out.println("Unbalanced Expression");
		}

	}

}
