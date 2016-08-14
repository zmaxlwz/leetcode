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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String s = "()";
		//String s = "())";
		String s = ")(((((()())()()))()(()))(";
		Solution sol = new Solution();
		System.out.println(sol.longestValidParentheses(s));
	}

}
