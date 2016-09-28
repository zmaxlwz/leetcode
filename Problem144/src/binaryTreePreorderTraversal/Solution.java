package binaryTreePreorderTraversal;

import java.util.*;

public class Solution {

	public List<Integer> preorderTraversal(TreeNode root){
		//perform preorder traversal of the binary tree
		//use recursion method
		
		List<Integer> result = new ArrayList<Integer>();
		
		if(root == null){
			return result;
		}
		
		traverse(root, result);
		
		return result;
	}
	
	private void traverse(TreeNode root, List<Integer> result){
		//use recursion to do preorder traversal
		
		if(root != null){
			result.add(root.val);
			traverse(root.left, result);
			traverse(root.right, result);
		}
		
	}
	
	public List<Integer> preorderTraversal2(TreeNode root){
		//use iterative method to traverse the binary tree
		
		List<Integer> result = new ArrayList<Integer>();
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode p = root;
		
		while(!stack.isEmpty() || p!=null){
			if(p!=null){
				result.add(p.val);
				stack.push(p);
				p = p.left;
			}
			else{
				TreeNode node = stack.pop();
				p = node.right;
			}
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		
		Solution sol = new Solution();
		System.out.println(sol.preorderTraversal2(root));

	}

}
