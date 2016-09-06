package balancedBinaryTree;

public class Solution {

	public boolean isBalanced(TreeNode root){
		//it is balanced if the left subtree height and right subtree height differs <= 1

		int depth = checkDepth(root);

		if(depth<0)
			return false;
		else
			return true;
	}

	private int checkDepth(TreeNode root){

		if(root == null){
			return 0;
		}

		int leftDepth = checkDepth(root.left);
		int rightDepth = checkDepth(root.right);
		if(leftDepth < 0 || rightDepth < 0){
			//it is not a balanced tree
			return -1;
		}
		else if(Math.abs(leftDepth - rightDepth)>1){
			return -1;
		}
		else{
			return Math.max(leftDepth, rightDepth)+1;
		}

	}

	public boolean isBalanced2(TreeNode root){
		int treeHeight = getHeight(root);
		if(treeHeight < 0){
			return false;
		} 
		else{
			return true;
		}
	}
	
	public int getHeight(TreeNode root){
		if(root == null){
			return 0;
		}
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		if(leftHeight < 0 || rightHeight < 0){
			return -1;
		}
		else if(Math.abs(leftHeight-rightHeight)>1){
			return -1;
		}
		else{
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
