package binaryTreePaths;

import java.util.*;

public class Solution {

	public List<String> binaryTreePaths(TreeNode root){
		List<String> result = new ArrayList<String>();
		if(root == null){
			return result;
		}
		List<Integer> temp = new ArrayList<Integer>();
		dfs(root, result, temp);
		return result;
	}

	public void dfs(TreeNode root, List<String> result, List<Integer> temp){
		temp.add(root.val);
		if(root.left == null && root.right == null){
			StringBuffer sb = new StringBuffer();
			int length = temp.size();
			sb.append(temp.get(0));
			for(int i =1;i<length;i++){
				sb.append("->");
				sb.append(temp.get(i));
			}
			result.add(sb.toString());
		}
		else if(root.left == null){
			dfs(root.right, result, temp);
		}
		else if(root.right == null){
			dfs(root.left, result, temp);
		}
		else{
			dfs(root.right, result, temp);
			dfs(root.left, result, temp);
		}
		temp.remove(temp.size()-1);
		return;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		
		Solution sol = new Solution();
		List<String> result = sol.binaryTreePaths(root);
		System.out.println(result);

	}

}

class TreeNode{
	
	int val;
	TreeNode left, right;
	TreeNode(int v){
		val = v;
	}
}
