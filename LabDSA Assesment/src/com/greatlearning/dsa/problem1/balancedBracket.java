package com.greatlearning.dsa.problem1;

import java.util.Stack;

public class balancedBracket {
	public static boolean isStringBalanced(String expression) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
				continue;
			}
			if (stack.isEmpty())
				return false;
			char c;
			switch (ch) {
			case '}':
				c = stack.pop();
				if (c == '(' || c == '[')
					return false;
				break;
			case ')':
				c = stack.pop();
				if (c == '{' || c == '[')
					return false;
				break;
			case ']':
				c = stack.pop();
				if (c == '{' || c == '(')
					return false;
				break;
			default:
				break;

			}
		}
		return (stack.isEmpty());

	}

	public static void main(String[] args) {
		String bracketExpression = "([[{}]])";
		boolean result = isStringBalanced(bracketExpression);
		if (result == true)
			System.out.println("The entered String has Balanced Brackets");
		else
			System.out.println("The entered Strings do not contain Balanced Brackets");

	}

}
