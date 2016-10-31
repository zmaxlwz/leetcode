package invertBinaryTree;

public class Solution {

	public TreeNode invertTree(TreeNode root){
		if(root == null){
			return root;
		}

		TreeNode leftChild = root.left;
		root.left = root.right;
		root.right = leftChild;

		invertTree(root.left);
		invertTree(root.right);

		return root;
	}

	public TreeNode invertTree2(TreeNode root){
		if(root == null){
			return root;
		}
		root.left = invertTree(root.left);
		root.right = invertTree(root.right);
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		return root;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class TreeNode{

	int val;
	TreeNode left, right;
	TreeNode(int x){
		val = x;
	}
}
