package longestValidParentheses;

import java.util.*;

public class Solution {

	public int longestValidParentheses(String s){
		//use a stack

		if(s == null || s.length() == 0){
			return 0;
		}

		//store the index of parenthese
		Stack<Integer> stack = new Stack<Integer>();

		char c;
		int maxLen = 0;
		for(int i=0; i<s.length();i++){
			c = s.charAt(i);
			if(c == '('){
				if(stack.empty()){
					maxLen = Math.max(maxLen, i);
				}
				else{
					maxLen = Math.max(maxLen, i-1-stack.peek());
				}
				stack.push(i);
			}
			else if(c == ')'){
				if(stack.empty()){
					maxLen = Math.max(maxLen, i);
					stack.push(i);
				}
				else if(s.charAt(stack.peek()) == '('){
					stack.pop();
				}
				else{
					//the top element is ')'
					maxLen = Math.max(maxLen, i-1-stack.peek());
					stack.push(i);
				}
			}
		}

		if(stack.empty()){
			return s.length();
		}
		else{

			maxLen = Math.max(maxLen, s.length()-1-stack.peek());

		}

		return maxLen;
	}

	public int longestValidParentheses2(String s){
		if(s==null || s.length() <= 1){
			return 0;
		}
		LinkedList<Integer> stack = new LinkedList<Integer>();
		int length = s.length();
		int maxLength = 0;
		for(int i =0;i<length;i++){
			char c = s.charAt(i);

			if(c == '('){
				if(stack.isEmpty()){
					maxLength = Math.max(maxLength, i);
				}
				else{
					int index = stack.peek();
					maxLength = Math.max(maxLength, i-1-index);
				}
				stack.push(i);
			}
			else{
				if(stack.isEmpty()){
					maxLength = Math.max(maxLength, i);
					stack.push(i);
				}
				else{
					int index = stack.peek();
					if(s.charAt(index) == '('){
						stack.pop();
						continue;
					}
					else{
						maxLength = Math.max(maxLength, i-1-index);
						stack.push(i);
					}
				}

			}
		}
		
		if(stack.isEmpty()){
			return length;
		}
		int index = stack.peek();
		maxLength = Math.max(maxLength, length-1-index);
		
		return maxLength;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String s = "()";
		//String s = "())";
		//String s = ")()())";
		String s = ")(((((()())()()))()(()))(";
		Solution sol = new Solution();
		System.out.println(sol.longestValidParentheses2(s));
	}

}
