package differentWaysToAddParentheses;

import java.util.*;

public class Solution {

	public List<Integer> diffWaysToCompute(String input){
		List<Integer> result = new ArrayList<Integer>();
		if(input == null || input.length()==0){
			return result;
		}

		result = compute(input, 0, input.length()-1);
		return result;
		
	}

	private List<Integer> compute(String input, int start, int end){
		List<Integer> result = new ArrayList<Integer>();
		if(start>end){
			return result;
		}
		boolean isNumber = true;
		for(int k=start;k<=end;k++){
			char c = input.charAt(k);
			if(c == '+'){
				isNumber = false;
				List<Integer> leftList = compute(input, start, k-1);
				List<Integer> rightList = compute(input, k+1, end);
				for(int i=0;i<leftList.size();i++){
					for(int j=0;j<rightList.size();j++){
						result.add(leftList.get(i)+rightList.get(j));
					}
				}
			}
			else if(c == '-'){
				isNumber = false;
				List<Integer> leftList = compute(input, start, k-1);
				List<Integer> rightList = compute(input, k+1, end);
				for(int i=0;i<leftList.size();i++){
					for(int j=0;j<rightList.size();j++){
						result.add(leftList.get(i)-rightList.get(j));
					}
				}
			}
			else if(c == '*'){
				isNumber = false;
				List<Integer> leftList = compute(input, start, k-1);
				List<Integer> rightList = compute(input, k+1, end);
				for(int i=0;i<leftList.size();i++){
					for(int j=0;j<rightList.size();j++){
						result.add(leftList.get(i)*rightList.get(j));
					}
				}
			}
		}
		if(isNumber){
			String s = input.substring(start, end+1);
			result.add(Integer.parseInt(s));
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "2*3-4*5";
		Solution sol = new Solution();
		System.out.println(sol.diffWaysToCompute(s));

	}

}
