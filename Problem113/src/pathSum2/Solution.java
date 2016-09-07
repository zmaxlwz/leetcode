package pathSum2;

import java.util.*;

public class Solution {

	public List<List<Integer>> pathSum(TreeNode root, int sum){
		//find all root to leaf paths that values sum up to the given sum
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if(root == null){
			return result;
		}
		
		List<Integer> temp = new ArrayList<Integer>();
		
		dfs(root, result, temp, sum);
		
		return result;
	}
	
	private void dfs(TreeNode root, List<List<Integer>> result, List<Integer> temp, int sum){
		
		if(root == null)
			return;
		
		temp.add(root.val);
		
		if(root.left == null && root.right == null){
		    if(root.val == sum)
			    result.add(new ArrayList<Integer>(temp));
			    
			temp.remove(temp.size()-1);
			return;
		}
		
		if(root.left != null){
			dfs(root.left, result, temp, sum-root.val);
		}
		if(root.right != null){
			dfs(root.right, result, temp, sum-root.val);			
		}
		
		temp.remove(temp.size()-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		
		Solution sol = new Solution();
		int sum = 22;
		System.out.println(sol.pathSum(root, sum));

	}

}
