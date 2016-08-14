package largestContainer;

public class Solution {

	public int maxArea(int[] height){

		int left = 0;
		int right = height.length-1;
		int max_area = 0;

		while(left < right){
			max_area = Math.max(max_area, (right-left)*Math.min(height[left], height[right]));

			if(height[left]<height[right]){
				left++;
			}
			else if(height[left]>height[right]){
				right--;
			}
			else{
				//they are equal
				left++;
				right--;
			}
		}

		return max_area;
	}

	public int maxArea2(int[] height){
		if(height == null || height.length <= 1){
			return 0;
		}
		int length = height.length;
		int left = 0;
		int right = length-1;
		int maxArea = 0;
		int area = 0;
		while(left<=right){
			area = Math.min(height[left], height[right])*(right-left);
			if(area>maxArea){
				maxArea = area;
			}
			if(height[left]<height[right]){
				left++;
			}
			else if(height[left]>height[right]){
				right--;
			}
			else{
				left++;
				right--;
			}
		}
		return maxArea;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] height = {2,5,3,7,2};

		Solution sol = new Solution();
		System.out.println(sol.maxArea2(height));

	}

}
