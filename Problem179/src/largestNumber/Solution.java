package largestNumber;

import java.util.*;

public class Solution {

	public String largestNumber(int[] nums){

		IntegerComparator comp = new IntegerComparator();
		Integer[] inputNum = new Integer[nums.length];
		for(int i=0;i<nums.length;i++){
			inputNum[i] = nums[i];
		}

		Arrays.sort(inputNum, comp);

		String result = "";
		for(int i=0;i<inputNum.length;i++){
			result = result + String.valueOf(inputNum[i]);
		}

		int start = 0;
		while(start < result.length() && result.charAt(start) == '0'){
			start++;
		}
		if(start>=result.length()){
			return "0";
		}
		else{
			return result.substring(start);
		}

	}

	public String largestNumber2(int[] nums){
		if(nums == null || nums.length == 0){
			return "";
		}
		int length = nums.length;
		String[] inputArray = new String[length];
		for(int i=0;i<length;i++){
			inputArray[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(inputArray, new StringComparator());
		if(inputArray[0].equals("0")){
			return "0";
		}
		String s = "";
		for(int i=0;i<length;i++){
			s += inputArray[i];
		}
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {3,30,34,5,9};
		Solution sol = new Solution();
		System.out.println(sol.largestNumber2(nums));

	}

}

class IntegerComparator implements Comparator<Integer>{

	public int compare(Integer a, Integer b){
		String sab = String.valueOf(a) + String.valueOf(b);
		String sba = String.valueOf(b) + String.valueOf(a);
		return -sab.compareTo(sba);
	}
}


class StringComparator implements Comparator<String>{
	
	public int compare(String a, String b){
		String s1 = a+b;
		String s2 = b+a;
		if(s1.compareTo(s2)>0){
			return -1;
		}
		else if(s1.compareTo(s2) == 0){
			return 0;
		}
		else{
			return 1;
		}
	}
}
