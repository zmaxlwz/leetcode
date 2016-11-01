package basicCalculator2_again;

import java.util.*;

public class Solution {

	LinkedList<Character> stack1 = new LinkedList<Character>();
	LinkedList<Integer> stack2 = new LinkedList<Integer>();


	public int calculate(String s){
		if(s == null || s.length() == 0){
			return 0;
		}
		int length = s.length();
		char c;
		int num = 0;
		boolean isNum = false;
		for(int i =0;i<length;i++){
			c = s.charAt(i);
			if(c>='0' && c<='9'){
				num = num*10+(c-'0');
				isNum = true;
				continue;
			}
			else{
				if(isNum){
					stack2.push(num);
					isNum = false;
				}
				num = 0;
			}
			if(c == ' '){
				continue;
			}
			else if(c=='+' || c=='-'){
				compute();
				stack1.push(c);
			}
			else if(c=='*' || c=='/'){
				compute();
				stack1.push(c);
			}
		}
		if(isNum){
			stack2.push(num);
		}
		compute();
		int result = 0;
		while(!stack1.isEmpty()){
			c = stack1.pop();
			if(c == '+'){
				result += stack2.pop();
			}
			else{
				result -= stack2.pop();
			}
		}
		return result + stack2.pop();
	}

	public void compute(){
		Character ch = stack1.peek();
		if(ch != null && (ch == '*' || ch == '/')){
			int n2 = stack2.pop();
			int n1 = stack2.pop();

			if(ch == '*'){
				stack2.push(n1*n2);
			}
			else{
				stack2.push(n1/n2);
			}
			stack1.pop();
		}
		return;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method st
		
		Solution sol = new Solution();
		//String s = "3+2*2";
		//String s = " 3/2 ";
		String s = " 3+5 / 2 ";
		System.out.println(sol.calculate(s));

	}

}
