package pascalTriangle2;

import java.util.*;

public class Solution {

	public List<Integer> getRow(int rowIndex){
		//return the kth row in Pascal's triangle, starting from the 0th row

		List<Integer> current = new ArrayList<Integer>();
		List<Integer> next = new ArrayList<Integer>();

		current.add(1);
		next.add(1);
		next.add(1);

		if(rowIndex==0){
			return current;
		}


		for(int i=1;i<=rowIndex;i++){
			current = next;
			next = new ArrayList<Integer>();
			next.add(1);
			for(int j=0;j<current.size()-1;j++){
				next.add(current.get(j)+current.get(j+1));
			}
			next.add(1);
		}

		return current;
	}

	public List<Integer> getRow2(int rowIndex){
		List<Integer> list = new ArrayList<Integer>();
		if(rowIndex<0){
			return list;
		}
		
		int length = 0;
		for(int i=0;i<=rowIndex;i++){
			list.add(1);
			for(int j=length-1;j>=1;j--){
				list.set(j, list.get(j-1)+list.get(j));
			}
			length++;
		}
		return list;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int k = 4;
		Solution sol = new Solution();
		System.out.println(sol.getRow2(k));

	}

}
