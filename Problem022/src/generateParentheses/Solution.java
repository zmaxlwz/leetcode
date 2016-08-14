package generateParentheses;

import java.util.*;

public class Solution {

	public List<String> generateParenthesis(int n){

		List<String> result = new ArrayList<String>();
		String temp = "";

		if(n <= 0)
			return result;

		dfs(result, temp, n, n);


		return result;
	}

	private void dfs(List<String> result, String temp, int openLeftNum, int closeLeftNum){
		if(openLeftNum == 0 && closeLeftNum == 0){
			result.add(temp);
			return;
		}

		if(openLeftNum > 0){
			temp = temp + "(";
			dfs(result, temp, openLeftNum-1, closeLeftNum);
			temp = temp.substring(0, temp.length()-1);
		}
		if(closeLeftNum > openLeftNum){
			temp = temp + ")";
			dfs(result, temp, openLeftNum, closeLeftNum-1);
			temp = temp.substring(0, temp.length()-1);
		}

		return;
	}

	public List<String> generateParenthesis2(int n){
		List<String> result = new ArrayList<String>();
		if(n<=0){
			return result;
		}
		List<Character> temp = new ArrayList<Character>();
		dfs(result, temp, n, 0, 0);
		return result;
	}

	public void dfs(List<String> result, List<Character> temp, int n, int open, int close){
		if(close == n){
			StringBuffer sb = new StringBuffer();
			for(Character c: temp){
				sb.append(c);
			}
			result.add(sb.toString());
			return;
		}
		if(open<n){
			temp.add('(');
			dfs(result, temp, n, open+1, close);
			temp.remove(temp.size()-1);
		}
		if(close<open){
			temp.add(')');
			dfs(result, temp, n, open, close+1);
			temp.remove(temp.size()-1);
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution sol = new Solution();
		int n = 3;
		System.out.println(sol.generateParenthesis2(n));

	}

}
