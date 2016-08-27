package restoreIPAddress2;

import java.util.*;

public class Solution {

	public List<String> restoreIpAddresses(String s){
		List<String> result = new ArrayList<String>();
		if(s == null || s.length() < 4){
			return result;
		}
		List<Integer> temp = new ArrayList<Integer>();
		dfs(result, temp, s, 0);
		return result;
	}
	
	public void dfs(List<String> result, List<Integer> temp, String s, int index){
		int length = s.length();
		if(index>=4){
			if(length==0){
				StringBuffer sb = new StringBuffer();
				for(int i =0;i<3;i++){
					sb.append(temp.get(i));
					sb.append('.');
				}
				sb.append(temp.get(3));
				result.add(sb.toString());	
			}
			return;
		}
		if(length>0){
			temp.add(Integer.valueOf(s.substring(0,1)));
			dfs(result, temp, s.substring(1), index+1);
			temp.remove(temp.size()-1);
		}
		int v;
		if(length>1){
			v = Integer.valueOf(s.substring(0,2));
			if(v>=10){
				temp.add(v);
				dfs(result, temp, s.substring(2), index+1);
				temp.remove(temp.size()-1);
			}
		}
		if(length>2){
			v = Integer.valueOf(s.substring(0,3));
			if(v>=100 && v<=255){
				temp.add(v);
				dfs(result, temp, s.substring(3), index+1);
				temp.remove(temp.size()-1);
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
