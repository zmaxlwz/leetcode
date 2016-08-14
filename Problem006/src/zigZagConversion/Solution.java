package zigZagConversion;

import java.util.ArrayList;

public class Solution {

	/**
	 * convert a String to its Zigzag order sequence
	 * @param s	input String
	 * @param numRows the number of rows for Zigzag
	 * @return	converted String
	 */
	public String convert(String s, int numRows){
		
		if(numRows<=1)
			return s;
		
		int period = 2*numRows - 2;
		
		//store each row as an ArrayList in the result
		ArrayList<ArrayList<Character>> result = new ArrayList<ArrayList<Character>>();
		
		for(int i=0;i<numRows;i++){
			result.add(new ArrayList<Character>());
		}
		
		int index;
		for(int j = 0; j<s.length(); j++){
			index = j%period;
			if(index<=numRows-1){
				result.get(index).add(s.charAt(j));
			}
			else{
				result.get(period-index).add(s.charAt(j));
			}
		}
		
		String output = "";
		for(int i=0;i<numRows;i++){
			int size = result.get(i).size();
			for(int j=0; j<size; j++){
				output += result.get(i).get(j).toString();
			}
		}
			
		
		return output;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "PAYPALISHIRING";
		int numRows = 3;
		Solution sol = new Solution();
		System.out.println(sol.convert(s, numRows));
		
	}

}
