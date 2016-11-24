package generalizedAbbreviation;

import java.util.*;

public class Solution {
	
	HashMap<String, List<String>> map = new HashMap<String, List<String>>();
	
	public List<String> generateAbbreviations(String word) {
        
		List<String> result = new ArrayList<String>();
		if(word == null || word.length() == 0){
			result.add("");
			return result;
		}
		
		int length = word.length();
		
		if(length == 1){
			result.add(word);
			result.add("1");
			return result;
		}
		
		//not abbreviate char 0
		char c1 = word.charAt(0);
		List<String> abbrWords;
		String remains = word.substring(1);
		if(map.containsKey(remains)){
			abbrWords = map.get(remains);
		}
		else{
			abbrWords = generateAbbreviations(remains);
		}
		
		for(String s: abbrWords){
			result.add(String.valueOf(c1) + s);
		}
		
		//abbreviate char 0 to '1'
		char c2 = word.charAt(1);
		remains = word.substring(2);
		if(map.containsKey(remains)){
			abbrWords = map.get(remains);
		}
		else{
			abbrWords = generateAbbreviations(remains);
		}
		/*
		if(abbrWords.size()==0){
			result.add("1" + String.valueOf(c2));
		}
		else{
			for(String s: abbrWords){
				result.add("1" + String.valueOf(c2) + s);
			}
		}
		*/
		for(String s: abbrWords){
			result.add("1" + String.valueOf(c2) + s);
		}
				
		//abbreviate continuous chars
		for(int i=2;i<=length;i++){
			if(i==length){
				result.add(String.valueOf(length));
			}
			/*
			else if(i==length-1){
				result.add(String.valueOf(length-1) + String.valueOf(word.charAt(length-1)));
			}
			*/
			else{
				String subStr = word.substring(i+1);
				abbrWords = generateAbbreviations(subStr);
				for(String s: abbrWords){
					result.add(String.valueOf(i) + String.valueOf(word.charAt(i)) + s);
				}
			}
		}
		
		if(!map.containsKey(word)){
			map.put(word, result);
		}
		
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		String word = "word";
		System.out.println(sol.generateAbbreviations(word));

	}

}
