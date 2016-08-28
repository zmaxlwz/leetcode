package symmetricTree;

public class Solution {

	public boolean isSymmetric(TreeNode root){
		
		if(root == null)
			return true;
		else{
			return compareTrees(root.left, root.right);
		}
		
	}
	
	private boolean compareTrees(TreeNode root1, TreeNode root2){
		
		if(root1 == null && root2 == null)
			return true;
		else if(root1 == null){
			//root2 != null
			return false;
		}
		else if(root2 == null){
			//root1 != null
			return false;
		}
		else{
			//root1 != null && root2 != null
			return root1.val == root2.val && compareTrees(root1.right, root2.left) && compareTrees(root1.left, root2.right);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
