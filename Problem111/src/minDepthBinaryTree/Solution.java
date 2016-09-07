package minDepthBinaryTree;

import java.util.*;

public class Solution {

	public int minDepth(TreeNode root){

		if(root == null){
			return 0;
		}

		if(root.left == null && root.right == null){
			return 1;
		}
		else if(root.left == null){
			return minDepth(root.right) + 1;
		}
		else if(root.right == null){
			return minDepth(root.left) + 1;
		}
		else{
			return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
		}

	}

	public int minDepth2(TreeNode root){
		//use level order traversal
		if(root == null){
			return 0;
		}
		LinkedList<TreeNode> queue1 = new LinkedList<TreeNode>();
		LinkedList<TreeNode> queue2 = new LinkedList<TreeNode>();
		int depth = 0;
		boolean hasLeaf = false;
		queue1.offer(root);
		while(!queue1.isEmpty()){
			TreeNode node = queue1.poll();
			if(node.left != null){
				queue2.offer(node.left);
			}
			if(node.right != null){
				queue2.offer(node.right);
			}
			if(node.left == null && node.right == null){
				hasLeaf = true;
			}
			if(queue1.isEmpty()){
				queue1 = queue2;
				queue2 = new LinkedList<TreeNode>();
				depth++;
				if(hasLeaf){
					return depth;
				}
			}
		}
		return depth;
	}

	public int minDepth3(TreeNode root){
		if(root == null){
			return 0;
		}
		int leftMinDepth = minDepth(root.left);
		int rightMinDepth = minDepth(root.right);
		if(leftMinDepth == 0 && rightMinDepth == 0){
			return 1;
		}
		else if(leftMinDepth == 0){
			return rightMinDepth + 1;
		}
		else if(rightMinDepth == 0){
			return leftMinDepth + 1;
		}
		else{
			return Math.min(leftMinDepth, rightMinDepth) + 1;
		}

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
