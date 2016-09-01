package maxDepthBinaryTree;

import java.util.*;

public class Solution {

	public int maxDepth(TreeNode root){

		if(root == null){
			return 0;
		}


		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

	public int maxDepth2(TreeNode root){
		//level order traversal
		if(root == null){
			return 0;
		}
		LinkedList<TreeNode> queue1 = new LinkedList<TreeNode>();
		LinkedList<TreeNode> queue2 = new LinkedList<TreeNode>();
		int depth = 0;
		queue1.offer(root);
		while(!queue1.isEmpty()){
			TreeNode node = queue1.poll();
			if(node.left != null){
				queue2.offer(node.left);
			}
			if(node.right != null){
				queue2.offer(node.right);
			}
			if(queue1.isEmpty()){
				depth++;
				queue1 = queue2;
				queue2 = new LinkedList<TreeNode>();
			}
		}
		return depth;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
