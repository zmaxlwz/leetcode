package sortColors;

public class Solution {

	public void sortColors(int[] nums){
		//sort three colors, red, white and blue
		//red=0, white=1, blue=2
		//nums is an array with only the three values, 0,1,2
		//use counting sort, overwrite, constant space

		int[] count = new int[3];
		for(int i=0;i<3;i++){
			count[i] = 0;
		}

		for(int i=0;i<nums.length;i++){
			count[nums[i]]++;
		}
		int index=0;
		for(int i=0;i<3;i++){
			while(count[i]>0){
				nums[index++] = i;
				count[i]--;
			}
		}
		return;		
	}

	public void sortColors2(int[] nums){
		//counting sort, create a new array

		if(nums == null || nums.length <=1)
			return;

		int[] count = new int[3];
		for(int i=0;i<3;i++){
			count[i] = 0;
		}

		for(int i=0;i<nums.length;i++){
			count[nums[i]]++;
		}

		for(int i=1;i<3;i++){
			count[i] = count[i] + count[i-1];
		}

		int[] sorted = new int[nums.length];
		for(int i=nums.length-1;i>=0;i--){
			int index = count[nums[i]]-1;
			sorted[index] = nums[i];
			count[nums[i]]--; 
		}

		for(int i=0;i<nums.length;i++){
			nums[i] = sorted[i];
		}

		return;
	}

	public void sortColors3(int[] nums){
		//the elements in nums are all 0, 1 or 2
		//use three pointers, one for 0, one for 2, the third is a scan index
		
		if(nums == null || nums.length==0){
			return;
		}
		int length = nums.length;
		int zeroIndex = -1;
		int twoIndex = length;
		int scanIndex = 0;
		while(scanIndex<twoIndex){
			if(nums[scanIndex] ==0){
				zeroIndex++;
				if(scanIndex!=zeroIndex){
					int temp = nums[zeroIndex];
					nums[zeroIndex] = nums[scanIndex];
					nums[scanIndex] = temp;
				}
				else{
					scanIndex++;
				}
			}
			else if(nums[scanIndex] == 2){
				twoIndex--;
				if(scanIndex != twoIndex){
					int temp = nums[twoIndex];
					nums[twoIndex] = nums[scanIndex];
					nums[scanIndex] = temp;
				}
				else{
					scanIndex++;
				}
			}
			else{
				scanIndex++;
			}
		}
		return;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1,0,1,2,0,2,1};
		Solution sol = new Solution();
		sol.sortColors3(nums);
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i] + ", ");
		}
		System.out.println();

	}

}
