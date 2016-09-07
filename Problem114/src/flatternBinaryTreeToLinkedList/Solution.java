package flatternBinaryTreeToLinkedList;

import java.util.*;

public class Solution {

	public void flatten(TreeNode root){
		//flatten a binary to a linked list
		//recursively put the left subtree to the right child and the right subtree to the end of left subtree

		if(root == null){
			return;
		}

		changeTree(root);

		return;
	}

	private TreeNode changeTree(TreeNode root){
		//recursively flatten the tree at root, return the last node

		TreeNode rightTree = root.right;

		if(root.left != null){
			//put left tree to the right
			root.right = root.left;
			//change the right tree(originally the left tree), return the last node
			TreeNode leftEndNode = changeTree(root.right);
			//connect the original right tree to the last node
			leftEndNode.right = rightTree;
			if(rightTree==null){
				return leftEndNode;
			}
			else{
				//change the original right tree and return the last node
				return changeTree(rightTree);
			}			
		}		
		else if(root.right != null){
			return changeTree(rightTree);
		}
		else{
			//both left and right are equal to null
			return root;
		}

	}

	public void flatten2(TreeNode root){
		//flatten a binary tree to a linked list
		//use preorder traverse to insert node
		List<TreeNode> list = new ArrayList<TreeNode>();
		if(root == null){
			return;
		}
		preorderTraverse(root, list);
		int size = list.size();
		for(int i=0;i<size-1;i++){
			list.get(i).left = null;
			list.get(i).right = list.get(i+1);
		}
		list.get(size-1).left = null;
		list.get(size-1).right = null;
		return;
	}

	private void preorderTraverse(TreeNode root, List<TreeNode> list){
		if(root == null){
			return;
		}
		list.add(root);
		preorderTraverse(root.left, list);
		preorderTraverse(root.right, list);
		return;
	}

	public void flatten3(TreeNode root){
		if(root == null){
			return;
		}
		flattenTree(root);
		return;
	}
	public TreeNode flattenTree(TreeNode root){
		TreeNode leftChild = root.left;
		TreeNode rightChild = root.right;
		TreeNode leftTail = null;
		TreeNode rightTail = null;
		if(leftChild != null){
			leftTail = flattenTree(leftChild);
		}
		root.left = null;
		root.right = leftChild;
		if(rightChild != null){
			rightTail = flattenTree(rightChild);
		}
		if(leftTail != null){
			leftTail.right = rightChild;
		}
		else{
			root.right = rightChild;
		}
		if(rightTail != null){
			return rightTail;
		}
		else if(leftTail != null){
			return leftTail;
		}
		else{
			return root;
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
