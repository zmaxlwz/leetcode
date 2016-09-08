package triangle;

import java.util.*;

public class Solution {

	public int minimumTotal(List<List<Integer>> triangle){
		//find the minimum path sum from the top to the bottom of the triangle
		//return the minimum sum

		int level = triangle.size();

		if(level == 0){
			return 0;
		}

		List<Integer> minTable = new ArrayList<Integer>(triangle.get(level-1));

		for(int i=level-2;i>=0;i--){
			List<Integer> thisRow = triangle.get(i);
			for(int j=0;j<thisRow.size();j++){
				minTable.set(j, Math.min(minTable.get(j), minTable.get(j+1))+thisRow.get(j));
			}
		}

		return minTable.get(0);
	}

	public int minimumTotal2(List<List<Integer>> triangle){
		if(triangle == null || triangle.size() == 0){
			return 0;
		}
		int numRows = triangle.size();
		int[] table = new int[numRows];
		List<Integer> row = triangle.get(numRows-1);
		for(int i =0;i<numRows;i++){
			table[i] = row.get(i);
		}
		for(int i = numRows-2;i>=0;i--){
			row = triangle.get(i);
			for(int j=0;j<=i;j++){
				table[j] = Math.min(table[j], table[j+1]) + row.get(j);
			}
		}
		return table[0];
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		triangle.add(list);
		list = new ArrayList<Integer>();
		list.add(3);
		list.add(4);
		triangle.add(list);
		list = new ArrayList<Integer>();
		list.add(6);
		list.add(5);
		list.add(7);
		triangle.add(list);
		list = new ArrayList<Integer>();
		list.add(4);
		list.add(1);
		list.add(8);
		list.add(3);
		triangle.add(list);

		Solution sol = new Solution();
		System.out.println(sol.minimumTotal2(triangle));

	}

}
