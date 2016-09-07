package pathSum;

public class Solution {

	public boolean hasPathSum(TreeNode root, int sum){
		//check whether there is a root to leaf path in the tree with sum is equal to the given value

		if(root == null)
			return false;

		if(root.left == null && root.right == null){
			if(sum == root.val)
				return true;
			else
				return false;
		}
		else if(root.left == null){
			if(hasPathSum(root.right, sum-root.val))
				return true;
			else
				return false;
		}
		else if(root.right == null){
			if(hasPathSum(root.left, sum-root.val))
				return true;
			else
				return false;
		}
		else{
			if(hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val))
				return true;
			else
				return false;
		}

	}

	public boolean hasPathSum2(TreeNode root, int sum){

		if(root == null){
			return false;
		}
		if(root.left == null && root.right == null){
			if(root.val == sum){
				return true;
			}
			else{
				return false;
			}
		}

		if(hasPathSum2(root.left, sum-root.val)){
			return true;
		}
		if(hasPathSum2(root.right, sum-root.val)){
			return true;
		}
		return false;
	}

	public boolean hasPathSum3(TreeNode root, int sum){
		if(root == null){
			return false;
		}
		if(root.left == null && root.right == null){
			if(root.val == sum){
				return true;
			}
			else{
				return false;
			}
		}
		return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println(Integer.MAX_VALUE);

	}

}
