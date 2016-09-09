package binaryTreeMaxPathSum2;


public class Solution {

	int maxSum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root){
		if(root == null){
			return 0;
		}
		findMaxPathSum(root);
		return this.maxSum;
	}

	public int findMaxPathSum(TreeNode root){
		if(root == null){
			return 0;
		}
		int leftMaxSum = findMaxPathSum(root.left);
		int rightMaxSum = findMaxPathSum(root.right);
		int sum = root.val;
		if(leftMaxSum > 0){
			sum += leftMaxSum;
		}
		if(rightMaxSum > 0){
			sum += rightMaxSum;
		}
		if(sum > this.maxSum){
			this.maxSum = sum;
		}
		int biggerSum = Math.max(leftMaxSum, rightMaxSum);
		if(biggerSum > 0){
			return biggerSum+root.val;
		}
		else{
			return root.val;
		}
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