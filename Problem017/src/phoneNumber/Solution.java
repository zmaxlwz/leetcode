package phoneNumber;

import java.util.*;

public class Solution {
	
	
	private HashMap<Character, String> digitMapping;
	
	public Solution(){
		//only consider '0' and '2'~'9', don't consider '1'
		digitMapping = new HashMap<Character, String>();
		digitMapping.put('0', " ");
		digitMapping.put('2', "abc");
		digitMapping.put('3', "def");
		digitMapping.put('4', "ghi");
		digitMapping.put('5', "jkl");
		digitMapping.put('6', "mno");
		digitMapping.put('7', "pqrs");
		digitMapping.put('8', "tuv");
		digitMapping.put('9', "wxyz");
	}

	public List<String> letterCombinations(String digits){
		
		List<String> result = new ArrayList<String>();
		List<Character> temp = new ArrayList<Character>();
		
		if(digits == null || digits.length() == 0){
			return result;
		}
		
		char[] digit_array = digits.toCharArray();
						
		dfs(result, temp, digit_array, 0);
		
		return result;
	}
	
	private void dfs(List<String> result, List<Character> temp, char[] digitArray, int index){
		if(index >= digitArray.length){
			//the temp list is filled
			
			Iterator<Character> iter = temp.iterator();
			String str = "";
			while(iter.hasNext()){
				str = str + iter.next().toString();
			}
			result.add(str);
			return;
		}
		
		char digit = digitArray[index];
		char[] letters = digitMapping.get(digit).toCharArray();
		
		for(int i=0; i<letters.length; i++){
			temp.add(letters[i]);
			dfs(result, temp, digitArray, index+1);
			temp.remove(index);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution sol = new Solution();
		String digits = "23";
		System.out.println(sol.letterCombinations(digits));
	}

}
