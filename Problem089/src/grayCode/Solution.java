package grayCode;

import java.util.*;

public class Solution {

	public List<Integer> grayCode(int n){
		//put all gray code with n bits into the list

		List<Integer> list = new ArrayList<Integer>();		
		list.add(0);

		int list_length = list.size();

		for(int i=1;i<=n;i++){
			int v = 1<<(i-1);
			for(int j=list_length-1;j>=0;j--){
				list.add(list.get(j)+v);
			}
			list_length = list.size();
		}

		return list;
	}

	public List<Integer> grayCode2(int n){
		List<Integer> result = new ArrayList<Integer>();
		if(n<=0){
			result.add(0);
			return result;
		}
		result = grayCode2(n-1);
		int length = result.size();
		int v = 1<<(n-1);
		for(int i =length-1;i>=0;i--){
			result.add(result.get(i)+v);
		}
		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 4;
		Solution sol = new Solution();
		System.out.println(sol.grayCode2(n));

	}

}
