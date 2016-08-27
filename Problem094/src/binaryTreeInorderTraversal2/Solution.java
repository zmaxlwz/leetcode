package binaryTreeInorderTraversal2;

import java.util.*;

public class Solution {

	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> result = new ArrayList<Integer>();
		traverse(result, root);
		return result;

	}

	public void traverse(List<Integer> result, TreeNode root){
		if(root == null){
			return;
		}
		traverse(result, root.left);
		result.add(root.val);
		traverse(result, root.right);
		return;
	}

	public List<Integer> inorderTraversal2(TreeNode root){
		List<Integer> result = new ArrayList<Integer>();
		TreeNode p = root;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		while(p!=null || !stack.isEmpty()){
			if(p!=null){
				stack.push(p);
				p = p.left;
			}
			else{
				p = stack.pop();
				result.add(p.val);
				p = p.right;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);

		Solution sol = new Solution();
		System.out.println(sol.inorderTraversal2(root));


	}

}
