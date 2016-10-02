package evaluateReversePolishNotation;

import java.util.*;

public class Solution {

	public int evalRPN(String[] tokens){
		//evaluate reverse polish notations in tokens
		//valid operators are +, -, *, /
		//use a stack

		if(tokens == null || tokens.length == 0){
			return 0;
		}

		int length = tokens.length;
		Stack<String> stack = new Stack<String>();

		for(int i=0;i<length;i++){
			String s = tokens[i];
			if(s.equals("+")){
				int op2 = Integer.parseInt(stack.pop());
				int op1 = Integer.parseInt(stack.pop());
				stack.push(String.valueOf(op1+op2));
			}
			else if(s.equals("-")){
				int op2 = Integer.parseInt(stack.pop());
				int op1 = Integer.parseInt(stack.pop());
				stack.push(String.valueOf(op1-op2));
			}
			else if(s.equals("*")){
				int op2 = Integer.parseInt(stack.pop());
				int op1 = Integer.parseInt(stack.pop());
				stack.push(String.valueOf(op1*op2));
			}
			else if(s.equals("/")){
				int op2 = Integer.parseInt(stack.pop());
				int op1 = Integer.parseInt(stack.pop());
				stack.push(String.valueOf(op1/op2));
			}
			else{
				//it is a number
				stack.push(s);
			}
		}

		return Integer.parseInt(stack.pop());

	}

	public int evalRPN2(String[] tokens){
		if(tokens == null || tokens.length == 0){
			return 0;
		}
		Stack<Integer> stack = new Stack<Integer>();
		int length = tokens.length;
		for(int i=0;i<length;i++){
			if(tokens[i].equals("+")){
				stack.push(stack.pop()+stack.pop());
			}
			else if(tokens[i].equals("-")){
				int e2 = stack.pop();
				int e1 = stack.pop();
				stack.push(e1-e2);
			}
			else if(tokens[i].equals("*")){
				stack.push(stack.pop()*stack.pop());
			}
			else if(tokens[i].equals("/")){
				int e2 = stack.pop();
				int e1 = stack.pop();
				stack.push(e1/e2);
			}
			else{
				stack.push(Integer.parseInt(tokens[i]));
			}

		}
		return stack.pop();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String[] tokens = {"2", "1", "+", "3", "*"};
		String[] tokens = {"4", "13", "5", "/", "+"};

		Solution sol = new Solution();
		System.out.println(sol.evalRPN(tokens));

	}

}
