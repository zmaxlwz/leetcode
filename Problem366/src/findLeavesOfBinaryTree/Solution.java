package findLeavesOfBinaryTree;

import java.util.*;

public class Solution {
	
	public List<List<Integer>> findLeaves(TreeNode root) {
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		while(root != null){
			List<Integer> list = new ArrayList<Integer>();
			root = removeLeaf(list, root);
			result.add(list);
		}
		
		return result;
    }
	
	private TreeNode removeLeaf(List<Integer> list, TreeNode root){
		
		if(root == null){
			return null;
		}
		
		if(root.left == null && root.right == null){
			//this is leaf, need to remove
			list.add(root.val);
			return null;
		}
		else if(root.left == null){
			//root.right != null
			root.right = removeLeaf(list, root.right);
			return root;
		}
		else if(root.right == null){
			//root.left != null
			root.left = removeLeaf(list, root.left);
			return root;
		}
		else{
			//neighbor left nor right child is null
			root.left = removeLeaf(list, root.left);
			root.right = removeLeaf(list, root.right);
			return root;
		}
		
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