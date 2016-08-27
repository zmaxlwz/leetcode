package binaryTreeInorderTraversal;

import java.util.*;

public class Solution {

	public List<Integer> inorderTraversal(TreeNode root){
		//return the inorder traversal of the binary tree as a list
		List<Integer> list = new ArrayList<Integer>();
		traverse(list, root);
		
		return list;
		
	}
	
	public void traverse(List<Integer> list, TreeNode root){
		
		if(root == null){
			return;
		}
		traverse(list, root.left);
		list.add(root.val);
		traverse(list, root.right);
		
	}
	
	public List<Integer> inorderTraversal2(TreeNode root){
		//this method uses iterative method to traverse the binary tree
		//use a stack
		
		List<Integer> result = new ArrayList<Integer>();
		
		if(root == null){
			return result;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		
		while(!stack.isEmpty() || p != null){
			
			if(p != null){
				stack.push(p);
				p = p.left;
			}
			else{
				TreeNode node = stack.pop();
				result.add(node.val);
				p = node.right;
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
