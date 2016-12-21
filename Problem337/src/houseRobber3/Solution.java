package houseRobber3;

public class Solution {
	
	public int rob(TreeNode root) {
        int[] result = robTree(root);
		
		return Math.max(result[0], result[1]);
    }
	
	public int[] robTree(TreeNode root){
		if(root == null){
			return new int[2];
		}
		int[] left = robTree(root.left);
		int[] right = robTree(root.right);
		int[] result = new int[2];
		result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		result[1] = root.val + left[0] + right[0];
		return result;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class TreeNode{
	
	int val;
	TreeNode left, right;
	TreeNode(int v){
		val = v;
		left = null;
		right = null;
	}
	
}