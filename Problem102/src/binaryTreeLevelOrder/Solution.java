package binaryTreeLevelOrder;

import java.util.*;

public class Solution {

	public List<List<Integer>> levelOrder(TreeNode root){

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if(root == null)
			return result;

		//create a queue
		LinkedList<BNode> queue = new LinkedList<BNode>();
		int currentLevel = 0;
		queue.offer(new BNode(root, currentLevel));

		List<Integer> list = new ArrayList<Integer>();
		int prevLevel = currentLevel;
		while(!queue.isEmpty()){
			BNode node = queue.poll();
			currentLevel = node.level;
			//add to list
			if(currentLevel == prevLevel){
				list.add(node.treenode.val);
			}
			else{
				result.add(new ArrayList<Integer>(list));
				list.clear();
				list.add(node.treenode.val);								
			}
			//add left and right subtree to queue
			if(node.treenode.left != null){
				queue.offer(new BNode(node.treenode.left, currentLevel+1));
			}
			if(node.treenode.right != null){
				queue.offer(new BNode(node.treenode.right, currentLevel+1));
			}
			prevLevel = currentLevel;
		}

		if(!list.isEmpty()){
			result.add(new ArrayList<Integer>(list));
		}

		return result;
	}

	public List<List<Integer>> levelOrder2(TreeNode root){
		//use 2 queues, one is for 1 level, the other is for the next level

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if(root == null){
			return result;
		}

		LinkedList<TreeNode> queue1 = new LinkedList<TreeNode>();
		LinkedList<TreeNode> queue2 = new LinkedList<TreeNode>();
		LinkedList<TreeNode> currentQueue, theOtherQueue;

		queue1.offer(root);
		currentQueue = queue1;
		theOtherQueue = queue2;

		List<Integer> list = new ArrayList<Integer>();
		while(!queue1.isEmpty() || !queue2.isEmpty()){

			if(currentQueue.isEmpty()){

				result.add(new ArrayList<Integer>(list));
				list.clear();

				if(!queue1.isEmpty()){
					currentQueue = queue1;
					theOtherQueue = queue2;
				}
				else{
					currentQueue = queue2;
					theOtherQueue = queue1;
				}

			}

			TreeNode node = currentQueue.poll();
			list.add(node.val);
			if(node.left != null){
				theOtherQueue.offer(node.left);
			}
			if(node.right != null){
				theOtherQueue.offer(node.right);
			}

		}

		if(!list.isEmpty()){
			result.add(list);
		}

		return result;
	}

	public List<List<Integer>> levelOrder3(TreeNode root){
		//use two queues
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null){
			return result;
		}

		LinkedList<TreeNode> queue1 = new LinkedList<TreeNode>();
		LinkedList<TreeNode> queue2 = new LinkedList<TreeNode>();
		List<Integer> list = new ArrayList<Integer>();
		queue1.offer(root);
		while(!queue1.isEmpty()){
			TreeNode node = queue1.poll();
			list.add(node.val);
			if(node.left != null){
				queue2.offer(node.left);
			}
			if(node.right != null){
				queue2.offer(node.right);
			}
			if(queue1.isEmpty()){
				queue1 = queue2;
				queue2 = new LinkedList<TreeNode>();
				result.add(new ArrayList<Integer>(list));
				list.clear();
			}
		}
		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
