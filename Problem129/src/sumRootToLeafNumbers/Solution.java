package sumRootToLeafNumbers;

import java.util.*;

public class Solution {

	public int sumNumbers(TreeNode root){
		//each node in the tree is between 0-9
		//sum all root-to-leaf numbers
		//return the sum
		
		List<Integer> finalNumbers = new ArrayList<Integer>();
		List<Integer> tempNumber = new ArrayList<Integer>();
		
		dfs(finalNumbers, tempNumber, root);
		
		int sum = 0;
		for(int i=0;i<finalNumbers.size();i++){
			sum += finalNumbers.get(i);
		}
		
		return sum;
	}
	
	private void dfs(List<Integer> finalNumbers, List<Integer> tempNumber, TreeNode root){
		
		if(root!=null){
			tempNumber.add(root.val);
			
			if(root.left == null && root.right == null){
				//compute number
				int n = 0;
				for(int i=0;i<tempNumber.size();i++){
					n = n*10 + tempNumber.get(i);
				}
				finalNumbers.add(n);
			}
			else if(root.left == null){
				dfs(finalNumbers, tempNumber, root.right);
			}
			else if(root.right == null){
				dfs(finalNumbers, tempNumber, root.left);
			}
			else{
				//root.left!= null && root.right != null
				dfs(finalNumbers, tempNumber, root.left);
				dfs(finalNumbers, tempNumber, root.right);
			}
			
			tempNumber.remove(tempNumber.size()-1);
		}
		
		return;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		Solution sol = new Solution();
		System.out.println(sol.sumNumbers(root));

	}

}
