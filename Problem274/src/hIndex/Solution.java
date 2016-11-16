package hIndex;

import java.util.Arrays;

public class Solution {
	
	public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
        	return 0;
        }
        int length = citations.length;
		Arrays.sort(citations);
		int hindex = 0;
		for(int i=length-1;i>=0;i--){
			if(citations[i]>=hindex+1){
				hindex++;
			}
			else{
				break;
			}
		}
		
		return hindex;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		int[] citations = {3,0,6,1,5};
		int hindex = sol.hIndex(citations);
		System.out.println(hindex);

	}

}
