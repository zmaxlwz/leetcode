package sortedArrayToBST;

public class Solution {

	public TreeNode sortedArrayToBST(int[] nums){
		
		if(nums == null || nums.length == 0){
			return null;
		}
				
		return buildBST(nums, 0, nums.length-1);
	}
	
	private TreeNode buildBST(int[] nums, int start, int end){
		
		if(start>end){
			return null;
		}
		
		int middle = (start+end)/2;
		
		TreeNode node = new TreeNode(nums[middle]);
		node.left = buildBST(nums, start, middle-1);
		node.right = buildBST(nums, middle+1, end);
		
		return node;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
