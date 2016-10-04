package bullsAndCows;

import java.util.*;

public class Solution {
	
	public String getHint(String secret, String guess) {
        int length = secret.length();
        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
        int numBulls = 0;
        int numCows = 0;
        for(int i=0;i<length;i++){
        	char c1 = secret.charAt(i);
        	char c2 = guess.charAt(i);
        	if(c1 == c2){
        		numBulls++;
        	}
        	else{
        		if(!map1.containsKey(c1)){
        			map1.put(c1, 1);
        		}
        		else{
        			map1.put(c1, map1.get(c1)+1);
        		}
        		if(!map2.containsKey(c2)){
        			map2.put(c2, 1);
        		}
        		else{
        			map2.put(c2, map2.get(c2)+1);
        		}
        	}
        }
		
        for(Character c: map1.keySet()){
        	if(map2.containsKey(c)){
        		numCows += Math.min(map1.get(c), map2.get(c));
        	}
        }
        
        StringBuffer sb = new StringBuffer();
        sb.append(numBulls);
        sb.append("A");
        sb.append(numCows);
        sb.append("B");
        
		return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		//String secret = "1807";
		//String guess = "7810";
		String secret = "1123";
		String guess = "0111";
		
		System.out.println(sol.getHint(secret, guess));

	}

}
