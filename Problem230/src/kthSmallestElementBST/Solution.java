package kthSmallestElementBST;

import java.util.*;

public class Solution {

	public int kthSmallest(TreeNode root, int k){
		TreeNode p = root;
		int count = 0;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(!stack.isEmpty() || p != null){
			if(p != null){
				stack.push(p);
				p = p.left;
			}
			else{
				TreeNode node = stack.pop();
				count++;
				if(count == k){
					return node.val;
				}
				p = node.right;
			}
		}

		return 0;
	}

	public int kthSmallest2(TreeNode root, int k){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		int count = 0;
		int targetNum = 0;
		while(p != null || !stack.isEmpty()){
			if(p!=null){
				stack.push(p);
				p = p.left;
			}
			else{
				p = stack.pop();
				count++;
				if(count==k){
					targetNum = p.val;
					break;
				}
				p = p.right;
			}
		}
		return targetNum;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(5);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(4);

		int k = 5;
		Solution sol = new Solution();
		System.out.println(sol.kthSmallest2(root, k));

	}

}

class TreeNode{

	int val;
	TreeNode left, right;
	TreeNode(int x){
		val = x;
	}
}