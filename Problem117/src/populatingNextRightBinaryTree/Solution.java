package populatingNextRightBinaryTree;

import java.util.*;

public class Solution {

	public void connect(TreeLinkNode root){
		//populate the next right pointer for each node in the binary tree
		//this is a general binary tree

		if(root == null){
			return;
		}

		//breadth-first search, use two queues to track the current level and next level
		LinkedList<TreeLinkNode> currentQueue = new LinkedList<TreeLinkNode>();
		LinkedList<TreeLinkNode> nextQueue = new LinkedList<TreeLinkNode>();

		currentQueue.offer(root);
		while(!currentQueue.isEmpty()){
			TreeLinkNode node = currentQueue.poll();
			node.next = currentQueue.peek();

			if(node.left != null){
				nextQueue.offer(node.left);
			}
			if(node.right != null){
				nextQueue.offer(node.right);
			}

			if(currentQueue.isEmpty()){
				currentQueue = nextQueue;
				nextQueue = new LinkedList<TreeLinkNode>();
			}
		}

		return;
	}

	public void connect2(TreeLinkNode root){
		if(root == null){
			return;
		}
		LinkedList<TreeLinkNode> queue1 = new LinkedList<TreeLinkNode>();
		LinkedList<TreeLinkNode> queue2 = new LinkedList<TreeLinkNode>();
		queue1.offer(root);
		while(!queue1.isEmpty()){
			TreeLinkNode node = queue1.poll();
			if(!queue1.isEmpty()){
				node.next = queue1.peek();
			}
			if(node.left != null){
				queue2.offer(node.left);
			}
			if(node.right != null){
				queue2.offer(node.right);
			}
			if(queue1.isEmpty()){
				queue1 = queue2;
				queue2 = new LinkedList<TreeLinkNode>();
			}
		}
		return;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
