package pascalTriangle;

import java.util.*;

public class Solution {

	public List<List<Integer>> generate(int numRows){
		//generate Pascal's Triangle for numRows rows
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if(numRows <= 0){
			return result;
		}
		
		List<Integer> current = new ArrayList<Integer>();
		List<Integer> next = new ArrayList<Integer>();
		
		current.add(1);
		result.add(current);
		if(numRows == 1){
			return result;
		}
		
		next.add(1);
		next.add(1);
		current = next;
		next = new ArrayList<Integer>();
		
		for(int i=2;i<=numRows;i++){
			result.add(current);
			next.add(1);
			for(int j=0;j<current.size()-1;j++){
				next.add(current.get(j)+current.get(j+1));				
			}
			next.add(1);
			current = next;
			next = new ArrayList<Integer>();
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numRows = 5;
		Solution sol = new Solution();
		System.out.println(sol.generate(numRows));

	}

}
