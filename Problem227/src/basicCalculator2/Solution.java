package basicCalculator2;

import java.util.*;

public class Solution {

	public int calculate(String s){

		if(s==null || s.length()==0){
			return 0;
		}

		Stack<String> stack = new Stack<String>();
		int length = s.length();
		String number = "";
		String multiDiv = "";
		for(int i=0;i<length;i++){
			char c = s.charAt(i);
			if(c == ' '){
				continue;
			}
			else if(c>='0' && c<='9'){
				number = number+String.valueOf(c);
			}
			else{
				//c is not space or digit
				if(number.length()>0){
					stack.push(number);
					number = "";
				}
				if(multiDiv.length()>0){
					//there is multiply or division stored
					int op2 = Integer.parseInt(stack.pop());
					int op1 = Integer.parseInt(stack.pop());
					if(multiDiv.equals("*")){
						stack.push(String.valueOf(op1*op2));
					}
					else{
						stack.push(String.valueOf(op1/op2));
					}
					multiDiv = "";
				}

				if(c=='+' || c=='-'){
					stack.push(String.valueOf(c));
				}
				else if(c=='*' || c=='/'){
					multiDiv = String.valueOf(c);
				}
			}

		}
		
		if(number.length()>0){
			stack.push(number);
			number = "";
		}
		if(multiDiv.length()>0){
			//there is multiply or division stored
			int op2 = Integer.parseInt(stack.pop());
			int op1 = Integer.parseInt(stack.pop());
			if(multiDiv.equals("*")){
				stack.push(String.valueOf(op1*op2));
			}
			else{
				stack.push(String.valueOf(op1/op2));
			}
			multiDiv = "";
		}

		/*
		//the stack only have numbers and ‘+’ and ‘-’
		List<String> list = new ArrayList<String>();
		while(!stack.isEmpty()){
			list.add(0, stack.pop());
		}
		
		//System.out.println(list);
		
		int result = 0;
		for(int i=list.size()-1;i>0;i = i-2){
			int num = Integer.parseInt(list.get(i));
			String op = list.get(i-1);
			if(op.equals("+")){
				result += num;
			}
			else{
				result -= num;
			}
		}
		result += Integer.parseInt(list.get(0));
		*/
		
		int result = 0;
		while(!stack.isEmpty()){
			int num = Integer.parseInt(stack.pop());
			String op = "";
			if(!stack.isEmpty()){
				op = stack.pop();
				if(op.equals("+")){
					result += num;
				}
				else{
					result -= num;
				}
			}
			else{
				result += num;
			}
			
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = " 3+ 2* 2 ";
		//String s = " 3 / 2 ";
		//String s = "3+5/2";
		//String s = "11- 3+8/3-4*2 +21";
		
		Solution sol = new Solution();
		System.out.println(sol.calculate(s));

	}

}
