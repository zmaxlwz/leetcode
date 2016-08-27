package uniqueBST2;

import java.util.*;

public class Solution {

	public List<TreeNode> generateTrees(int n){
		
		
		
		List<TreeNode> list = getTreeList(1, n);
		
		return list;
	}
	
	private List<TreeNode> getTreeList(int start, int end){
		List<TreeNode> list = new ArrayList<TreeNode>();
		
		if(start>end){
			return list;
		}		
		else if(start == end){
			TreeNode node = new TreeNode(start);
			list.add(node);
			return list;
		}
		else{
			for(int i=start;i<=end;i++){
				//i is the middle point
				List<TreeNode> leftList = getTreeList(start, i-1);
				List<TreeNode> rightList = getTreeList(i+1, end);
				if(leftList.size()==0 && rightList.size() == 0){
					list.add(new TreeNode(i));
				}
				else if(leftList.size()==0){
					//rightList is not empty
					for(int j=0;j<rightList.size();j++){
						TreeNode node = new TreeNode(i);
						node.right = rightList.get(j);
						list.add(node);
					}
				}
				else if(rightList.size() == 0){
					//leftList is not empty
					for(int j=0;j<leftList.size();j++){
						TreeNode node = new TreeNode(i);
						node.left = leftList.get(j);
						list.add(node);
					}
				}
				else{
					//leftList and rightList are not empty
					for(int j=0;j<leftList.size();j++){
						for(int k=0;k<rightList.size();k++){
							TreeNode node = new TreeNode(i);
							node.left = leftList.get(j);
							node.right = rightList.get(k);
							list.add(node);
						}
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
