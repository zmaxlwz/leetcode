package validParentheses;

import java.util.*;

public class Solution {

	public boolean isValid(String s){

		String openList = "([{";
		String closeList = ")]}";

		Stack<Integer> stack = new Stack<Integer>();

		char c;
		int index;
		for(int i=0;i<s.length();i++){
			c = s.charAt(i);
			if((index = openList.indexOf(c)) >=0){
				//the char is in openList
				stack.push(index);
			}
			else if((index=closeList.indexOf(c)) >=0){
				//the char is in closeList
				if(!stack.empty() && stack.peek() == index){
					stack.pop();
				}
				else{
					return false;
				}
			}
		}

		return stack.empty();
	}

	public boolean isValid2(String s){
		if(s == null || s.length()==0){
			return true;
		}
		String openList = "({[";
		String closeList = ")}]";
		LinkedList<Character> stack = new LinkedList<Character>();
		int length = s.length();
		char c;
		for(int i =0; i<length;i++ ){
			c = s.charAt(i);
			int index1 = openList.indexOf(c);
			if(index1>=0){
				stack.push(c);
				continue;
			}
			int index2 = closeList.indexOf(c);
			if(stack.isEmpty()){
				return false;
			}
			char popChar = stack.pop();
			if(openList.indexOf(popChar) != index2){
				return false;
			}

		}
		return stack.isEmpty();
	}

	public boolean isValid3(String s){
		if(s == null || s.length()==0){
			return true;
		}
		String openList = "({[";
		String closeList = ")}]";
		LinkedList<Integer> stack = new LinkedList<Integer>();
		int length = s.length();
		char c;
		for(int i =0; i<length;i++ ){
			c = s.charAt(i);
			int index1 = openList.indexOf(c);
			if(index1>=0){
				stack.push(index1);
				continue;
			}
			int index2 = closeList.indexOf(c);
			if(stack.isEmpty()){
				return false;
			}

			if(stack.pop() != index2){
				return false;
			}

		}
		return stack.isEmpty();
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String str = "abc";
		//char c = 'd';
		//System.out.println(str.indexOf(c));

		Solution sol = new Solution();
		String str = "[()()]{}";
		System.out.println(sol.isValid3(str));
	}

}
