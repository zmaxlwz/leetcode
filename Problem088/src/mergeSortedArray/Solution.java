package mergeSortedArray;

public class Solution {

	public void merge(int[] nums1, int m, int[] nums2, int n){
		//nums1 and nums2 are sorted arrays
		//nums1 has m elements and nums2 has n elements
		//merge them into one sorted array in-place, assuming nums1 has enough space

		if(nums2 == null || n <= 0)
			return;

		int i = m-1;
		int j = n-1;
		int k = m+n-1;

		while(i>=0 && j>=0){
			if(nums1[i]<=nums2[j]){
				nums1[k] = nums2[j];
				k--;
				j--;
			}
			else{
				nums1[k] = nums1[i];
				k--;
				i--;
			}
		}

		if(i>=0){
			//nums2 is running out
			return;
		}
		else{
			while(j>=0){
				nums1[k--] = nums2[j--];				
			}
			return;
		}

	}

	public void merge2(int[] nums1, int m, int[] nums2, int n){
		int i  = m-1, j=n-1, k=m+n-1;
		while(i>=0 && j>=0){
			if(nums1[i]>nums2[j]){
				nums1[k] = nums1[i];
				i--;
				k--;
			}
			else{
				nums1[k] = nums2[j];
				j--;
				k--;
			}
		}
		if(j<0){
			return;
		}
		while(j>=0){
			nums1[k] = nums2[j];
			j--;
			k--;
		}
		return;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums1 = new int[10];
		nums1[0] = 2;
		nums1[1] = 9;
		nums1[2] = 12;
		nums1[3] = 21;
		int[] nums2 = {7,13,19,28};

		int m = 4;
		int n = 4;

		Solution sol = new Solution();
		sol.merge2(nums1, m, nums2, n);

		for(int i=0;i<m+n;i++){
			System.out.print(nums1[i] + ", ");
		}
		System.out.println();

	}

}
