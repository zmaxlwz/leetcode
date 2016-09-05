package binaryTreeLevelOrder2;

import java.util.*;

public class Solution {

	public List<List<Integer>> levelOrderBottom(TreeNode root){
		//return the list of each level from bottom up

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if(root == null){
			return result;
		}

		LinkedList<TreeNode> currentQueue = new LinkedList<TreeNode>();
		LinkedList<TreeNode> nextQueue = new LinkedList<TreeNode>();

		List<Integer> list = new ArrayList<Integer>();
		currentQueue.offer(root);
		while(!currentQueue.isEmpty()){

			TreeNode node = currentQueue.poll();
			list.add(node.val);
			if(node.left != null)
				nextQueue.offer(node.left);
			if(node.right != null)
				nextQueue.offer(node.right);

			if(currentQueue.isEmpty()){
				currentQueue = nextQueue;
				nextQueue = new LinkedList<TreeNode>();
				result.add(list);
				list = new ArrayList<Integer>();
			}
		}

		List<List<Integer>> reverseList = new ArrayList<List<Integer>>();
		for(int i=result.size()-1;i>=0;i--){
			reverseList.add(result.get(i));
		}

		return reverseList;
	}

	public List<List<Integer>> levelOrderBottom2(TreeNode root){
		LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
		dfs(result, root, 0);
		LinkedList<List<Integer>> finalResult = new LinkedList<List<Integer>>();
		while(!result.isEmpty()){
			finalResult.push(result.pop());
		}
		return finalResult;
	}
	public void dfs(List<List<Integer>> result, TreeNode root, int level){
		if(root == null){
			return;
		}
		if(result.size()<=level){
			result.add(new ArrayList<Integer>());
		}
		result.get(level).add(root.val);
		dfs(result, root.left, level+1);
		dfs(result, root.right, level+1);
		return;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
