package binaryTreeMaxPathSum;

public class Solution {

	public int maxPathSum(TreeNode root){
		//this method cause Time Limit Exceeded
		if(root == null){
			return 0;
		}
		int pathPassRoot = root.val + maxDownPath(root.left) + maxDownPath(root.right);
		int leftMaxPath = maxPathSum(root.left);
		int rightMaxPath = maxPathSum(root.right);
		return Math.max(pathPassRoot, Math.max(leftMaxPath, rightMaxPath));

	}
	private int maxDownPath(TreeNode root){
		if(root == null){
			return 0;
		}
		int leftSum = maxDownPath(root.left);
		int rightSum = maxDownPath(root.right);
		int largerSum = Math.max(leftSum, rightSum);
		if(largerSum>0){
			return root.val + largerSum;
		}
		else{
			return root.val;
		}
	}

	public int maxPathSum2(TreeNode root){
		//this method is from program creek
		int[] max = new int[1];
		max[0] = Integer.MIN_VALUE;
		calculateSum(root, max);
		return max[0];
	}

	private int calculateSum(TreeNode root, int[] max){
		//this method return max path down sum
		//max any path sum is in max[0]
		if(root == null){
			return 0;
		}
		int left = calculateSum(root.left, max);
		int right = calculateSum(root.right, max);
		int current = Math.max(root.val, Math.max(root.val+left, root.val+right));
		max[0] = Math.max(max[0], Math.max(current, left+root.val+right));
		return current;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		Solution sol = new Solution();
		System.out.println(sol.maxPathSum(root));

	}

}

class TreeNode{

	int val;
	TreeNode left, right;
	TreeNode(int x){
		val = x;
	}

}
