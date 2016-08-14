package longestCommonPrefix;

public class Solution {

	public String longestCommonPrefix(String[] strs){

		//if the input array is empty, return "" 
		if(strs == null || strs.length == 0)
			return "";

		if(strs.length == 1)
			return strs[0];

		//the mininum length of all strings
		int minLength = Integer.MAX_VALUE;
		for(int i=0;i<strs.length;i++){
			if(strs[i].length() < minLength){
				minLength = strs[i].length();
			}
		}

		char c;
		boolean isEqual;
		int j;
		for(j=0;j<minLength;j++){
			c = strs[0].charAt(j);
			isEqual = true;
			for(int i=1;i<strs.length;i++){
				if(strs[i].charAt(j) != c){
					isEqual = false;
					break;
				}
			}
			if(!isEqual)
				break;
		}

		return strs[0].substring(0, j);
	}

	public String longestCommonPrefix2(String[] strs){
		if(strs == null || strs.length == 0){
			return "";
		}
		int length = strs.length;
		if(length==1){
			return strs[0];
		}
		int minStrLength = Integer.MAX_VALUE;
		for(int i =0; i<length; i++){
			if(strs[i].length()<minStrLength){
				minStrLength = strs[i].length();
			}
		}
		int index = 0;
		for(index=0;index<minStrLength;index++){
			char c = strs[0].charAt(index);
			boolean isEqual = true;
			for(int i=1;i<length;i++ ){
				if(strs[i].charAt(index) != c){
					isEqual = false;
					break;
				}
			}
			if(!isEqual){
				break;
			}
		}

		return strs[0].substring(0, index);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] strs = new String[3];
		strs[0] = "abcef";
		strs[1] = "abct";
		strs[2] = "abw";

		Solution sol = new Solution();
		System.out.println(sol.longestCommonPrefix2(strs));
	}

}
