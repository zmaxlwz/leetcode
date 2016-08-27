package uniqueBST2_again;

import java.util.*;

public class Solution {

	public List<TreeNode> generateTrees(int n){
		
		List<TreeNode> result = generate(1, n);
		return result;
	}
	
	public List<TreeNode> generate(int start, int end){
		List<TreeNode> list = new ArrayList<TreeNode>();
		if(start>end){
			return list;
		}
		if(start==end){
			TreeNode root = new TreeNode(start);
			list.add(root);
			return list;
		}
		for(int i =start;i<=end;i++){
			List<TreeNode> leftList = generate(start, i-1);
			List<TreeNode> rightList = generate(i+1, end);
			if(leftList.size() == 0 && rightList.size() == 0){
				TreeNode node = new TreeNode(i);
				node.left = null;
				node.right = null;
				list.add(node);
			}
			else if(leftList.size() == 0){
				for(TreeNode rightRoot: rightList){
					TreeNode node = new TreeNode(i);
					node.left = null;
					node.right = rightRoot;
					list.add(node);
				}
			}
			else if(rightList.size() == 0){
				for(TreeNode leftRoot: leftList){
					TreeNode node = new TreeNode(i);
					node.right = null;
					node.left = leftRoot;
					list.add(node);
				}
			}
			else{
				for(TreeNode leftRoot: leftList){
					for(TreeNode rightRoot: rightList){

						TreeNode node = new TreeNode(i);
						node.left = leftRoot;
						node.right = rightRoot;
						list.add(node);
					}
				}
			}

		}
		return list;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 3;
		Solution sol = new Solution();
		List<TreeNode> list = sol.generateTrees(n);
		System.out.println(list.size());


	}

}
