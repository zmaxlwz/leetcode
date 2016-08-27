package decodeWays;

public class Solution {

	public int numDecodings(String s){
		//s is a String of integers
		//return the number of ways for decoding s
		
		if(s == null || s.length()==0)
			return 0;
		
		int length = s.length();
		
		//if the first digit is 0, there is no way to decode
		if(s.charAt(0) == '0')
			return 0;
		else if(s.length() == 1)
			return 1;
		
		//use one dimensional dynamic programming
		int[] table = new int[length];
		for(int i=0;i<table.length;i++){
			table[i] = 0;
		}
		
		table[0] = 1;
		if(s.charAt(1) != '0'){
			table[1] = table[0];
		}
		int v = Integer.valueOf(s.substring(0, 2));
		if(v >= 10 && v<=26){
			table[1] += 1;
		}
		
		for(int i=2;i<length;i++){
			if(s.charAt(i) != '0'){
				table[i] = table[i-1];
			}
			v = Integer.valueOf(s.substring(i-1, i+1));
			if(v>=10 && v<=26){
				table[i] += table[i-2];
			}
		}
				
		return table[length-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "1";
		Solution sol = new Solution();
		System.out.println(sol.numDecodings(s));

	}

}
