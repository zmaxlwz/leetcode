package binaryTreeRightSideView;

import java.util.*;

public class Solution {

	public List<Integer> rightSideView(TreeNode root){
		//use two queues to do BFS, add the right node into the list
		List<Integer> result = new ArrayList<Integer>();
		if(root == null){
			return result;
		}

		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		LinkedList<TreeNode> next = new LinkedList<TreeNode>();
		current.offer(root);
		while(!current.isEmpty()){
			TreeNode node = current.poll();
			if(node.left != null){
				next.offer(node.left);
			}
			if(node.right != null){
				next.offer(node.right);
			}
			if(current.isEmpty()){
				result.add(node.val);
				current = next;
				next = new LinkedList<TreeNode>();
			}
		}
		return result;
	}

	public List<Integer> rightSideView2(TreeNode root){
		List<Integer> result = new ArrayList<Integer>();
		if(root == null){
			return result;
		}
		LinkedList<TreeNode> queue1 = new LinkedList<TreeNode>();
		LinkedList<TreeNode> queue2 = new LinkedList<TreeNode>();
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
				result.add(node.val);		
				queue1 = queue2;
				queue2 = new LinkedList<TreeNode>();

			}
		}
		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		root.left.right = new TreeNode(4);

		Solution sol = new Solution();
		System.out.println(sol.rightSideView2(root));

	}

}

class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int x){
		val = x;
	}
}

