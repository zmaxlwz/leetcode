package restoreIPAddress;

import java.util.*;

public class Solution {

	public List<String> restoreIpAddresses(String s){
		//s is a String containing only digits
		//valid IP address contains 4 parts, each part is an integer between 0~255
		//return a list of all valid IP address combinations
		
		List<String> result = new ArrayList<String>();
		
		if(s == null || s.length() == 0)
			return result;
		
		List<String> temp = new ArrayList<String>();
		dfs(result, temp, s, 0);
		
		return result;
	}
	
	private void dfs(List<String> result, List<String> temp, String s, int index){
		if(index>=4 && s.length()==0){
			String ip= temp.get(0);
			for(int i=1;i<4;i++){
				ip = ip + "." + temp.get(i);
			}
			result.add(ip);
			return;
		}
		else if(index>=4){
			return;
		}
		
		for(int i=0;i<3;i++){
			int number;
			if(i<s.length()){
				number = Integer.valueOf(s.substring(0, i+1));
				//one digit between [0,9], two digits between [10,99], three digits between [100, 255]
				//if two digit but is "06", it is invalid
				if((i==0 && number>=0 && number<=9) || (i==1 && number>=10 && number<=99) || (i==2 && number>=100 && number<=255)){
					temp.add(s.substring(0, i+1));
					dfs(result, temp, s.substring(i+1), index+1);
					temp.remove(temp.size()-1);
				}
			}
			else{
				return;
			}
		}
		return;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "25525511135";
		Solution sol = new Solution();
		System.out.println(sol.restoreIpAddresses(s));

	}

}
