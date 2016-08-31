package binaryTreeZigzagLevelOrder2;

import java.util.*;

public class Solution {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		dfs(result, root, 0);
		return result;
	}
	public void dfs(List<List<Integer>> result, TreeNode root, int level){
		if(root == null){
			return;
		}
		if(result.size()<=level){
			result.add(new ArrayList<Integer>());
		}
		if(level %2 == 0){
			result.get(level).add(root.val);
		}
		else{
			result.get(level).add(0, root.val);
		}
		dfs(result, root.left, level+1);
		dfs(result, root.right, level+1);
		return;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
