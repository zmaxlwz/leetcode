package binaryTreePostorderTraversal;

import java.util.*;

public class Solution {

	public List<Integer> postorderTraversal(TreeNode root){
		//perform postorder traversal of the binary tree
		//use recursion

		List<Integer> result = new ArrayList<Integer>();

		traverse(root, result);

		return result;
	}

	private void traverse(TreeNode root, List<Integer> result){

		if(root != null){
			traverse(root.left, result);
			traverse(root.right, result);
			result.add(root.val);
		}

		return;
	}

	public List<Integer> postorderTraversal2(TreeNode root){
		//use iterative method to do postorder traversal

		List<Integer> result = new ArrayList<Integer>();

		Stack<TreeNode> stack = new Stack<TreeNode>();

		TreeNode p = root;
		while(!stack.isEmpty() || p!=null){
			if(p!=null){
				stack.push(p);
				p = p.left;
			}
			else{
				TreeNode node = stack.pop();
				if(node.right != null){
					p = node.right;
					//this method will change the underlying tree, if don't want to change, see method 3 below
					node.right = null;
					stack.push(node);
				}
				else{
					result.add(node.val);
					p = null;
				}
			}
		}

		return result;
	}

	public List<Integer> postorderTraversal3(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		HashSet<TreeNode> set = new HashSet<TreeNode>();
		while(p!=null || !stack.isEmpty()){
			if(p != null){
				stack.push(p);
				p = p.left;
			}
			else{
				TreeNode node = stack.pop();
				if(!set.contains(node)){
					set.add(node);
					stack.push(node);
					p = node.right;
				}
				else{
					result.add(node.val);
					p = null;
				}
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
		System.out.println(sol.postorderTraversal2(root));


	}

}
