package pathSum2_again;

import java.util.*;

public class Solution {

	public List<List<Integer>> pathSum(TreeNode root, int sum){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null){
			return result;
		}
		List<Integer> temp = new ArrayList<Integer>();
		dfs(result, temp, root, sum);
		return result;
	}
	public void dfs(List<List<Integer>> result, List<Integer> temp, TreeNode root, int sum){
		temp.add(root.val);
		if(root.left == null && root.right == null){
			if(root.val == sum){
				result.add(new ArrayList<Integer>(temp));
			}
		}
		else if(root.left == null){
			dfs(result, temp, root.right, sum-root.val);
		}
		else if(root.right == null){
			dfs(result, temp, root.left, sum-root.val);
		}
		else{
			dfs(result, temp, root.left, sum-root.val);
			dfs(result, temp, root.right, sum-root.val);
		}
		temp.remove(temp.size()-1);
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
