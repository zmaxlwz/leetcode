package validateBST;

import java.util.*;

public class Solution {

	public boolean isValidBST(TreeNode root){
		//call checkBST, which is a recursive method
		
		double start = Double.NEGATIVE_INFINITY;
		double end = Double.POSITIVE_INFINITY;
		
		return checkBST(root, start, end);
	}
	
	private boolean checkBST(TreeNode node, double start, double end){
		//check whether all the nodes in the BST rooted at node is within the range (start, end)
		
		if(node == null){
			return true;
		}
		
		if(start > end){
			return false;
		}
		
		int val = node.val;
				
		if(val <= start || val >= end){
			return false;
		}
		
		return checkBST(node.left, start, val) && checkBST(node.right, val, end);
		
	}
	
	public boolean isValidBST2(TreeNode root){
		//this is an iterative method
		
		if(root == null)
			return true;
		
		LinkedList<BNode> queue = new LinkedList<BNode>();
		queue.offer(new BNode(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY));
		
		while(!queue.isEmpty()){
			BNode bnode = queue.poll();
			if(bnode.treenode.val <= bnode.leftRange || bnode.treenode.val >= bnode.rightRange){
				return false;
			}
			if(bnode.treenode.left != null){
				queue.offer(new BNode(bnode.treenode.left, bnode.leftRange, bnode.treenode.val));
			}
			if(bnode.treenode.right != null){
				queue.offer(new BNode(bnode.treenode.right, bnode.treenode.val, bnode.rightRange));
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		
		Solution sol = new Solution();
		//System.out.println(sol.isValidBST(root));
		System.out.println(sol.isValidBST2(root));
		
		//System.out.println(Integer.MAX_VALUE == 2147483647);
		//System.out.println(Double.MIN_VALUE > 0);
		//System.out.println(Double.MAX_VALUE);

	}

}
