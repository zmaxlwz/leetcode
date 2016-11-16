package hindex2;

public class Solution {
	
	public int hIndex(int[] citations) {
		if(citations == null || citations.length == 0){
			return 0;
		}
		int length = citations.length;
		int left = 0;
		int right = length-1;
		int mid;
		int hindex = 0;
		while(left <= right){
			mid = (left+right)/2;
			if(citations[mid]>=length-mid){
				hindex = length-mid;
				right = mid-1;
			}
			else{
				left = mid+1;
			}
		}
		
		return hindex;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		int[] citations = {0,1,3,5,6};
		int hindex = sol.hIndex(citations);
		System.out.println(hindex);
	}

}
