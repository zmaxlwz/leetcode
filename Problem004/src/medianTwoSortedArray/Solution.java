package medianTwoSortedArray;

public class Solution {

	public double findMedianSortedArrays(int[] nums1, int[] nums2){
		
		if(nums1 == null || nums1.length == 0){
			return median(nums2);			
		}
		
		if(nums2 == null || nums2.length == 0){
			return median(nums1);			
		}

		int length1 = nums1.length;
		int length2 = nums2.length;
		int totalLength = length1+length2;
		int median1Index = 0;
		int median2Index = 0;
		if(totalLength%2 == 0){
			median1Index = (totalLength-1)/2;
			median2Index = (totalLength-1)/2+1;
		}
		else{
			median1Index = (totalLength-1)/2;
			median2Index = (totalLength-1)/2;	
		}

		int index1 = search(nums1, nums2, median1Index);
		int median1 = 0;
		if(index1 <0){
			index1 = search(nums2, nums1, median1Index);
			median1 = nums2[index1];
		}
		else{
			median1 = nums1[index1];
		}

		int index2 = search(nums1, nums2, median2Index);
		int median2 = 0;
		if(index2 < 0){
			index2 = search(nums2, nums1, median2Index);
			median2 = nums2[index2];
		}
		else{
			median2 = nums1[index2];
		}

		double median = ((double)median1 + (double)median2)/2;
		return median;

	}
	
	public double median(int[] nums){
		int length = nums.length;
		if(length%2==0){
			int index1 = (length-1)/2;
			int index2 = index1+1;
			return ((double)nums[index1] + (double)nums[index2])/2;
		}
		else{
			int index = (length-1)/2;
			return (double)nums[index];
		}
		
	}

	public int search(int[] array1, int[] array2, int index){
		int length1 = array1.length;
		int length2 = array2.length;
		int p1 = 0;
		int p2 = 0;
		int left = 0;
		int right = length1-1;
		while(left<=right){
			p1 = (left+right)/2;
			p2 = index-p1-1;
			if(p2>=0 && p2<=length2-2){
				if(array1[p1]>=array2[p2] && array1[p1]<=array2[p2+1]){
					return p1;
				}
				else if(array1[p1]<array2[p2]){
					left = p1+1;
				}
				else{
					right = p1-1;
				}
			}
			else if(p2<0){
				if(p1 == index && array1[p1]<=array2[0]){
					return p1;
				}
				right = p1-1;
			}
			else{

				if(p1+length2==index && array1[p1]>=array2[length2-1]){
					return p1;
				}
				left = p1+1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums1 = {2,4,5,7};
		int[] nums2 = {1,3,6};
		
		Solution sol = new Solution();
		System.out.println(sol.findMedianSortedArrays(nums1, nums2));

	}

}
