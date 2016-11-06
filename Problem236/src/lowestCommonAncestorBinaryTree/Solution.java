package lowestCommonAncestorBinaryTree;

import java.util.*;

public class Solution {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if(root == p || root == q){
			return root;
		}

		int numMatches = countMatches(root.left, p, q);
		if(numMatches == 1){
			return root;
		}
		else if(numMatches == 0){
			return lowestCommonAncestor(root.right, p, q);
		}
		else{
			return lowestCommonAncestor(root.left, p, q);
		}

	}

	private int countMatches(TreeNode root, TreeNode p, TreeNode q){
		TreeNode t = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int numMatches = 0;
		while(!stack.isEmpty() || t!=null){
			if(t!=null){
				stack.push(t);
				t = t.left;
			}
			else{
				TreeNode node = stack.pop();
				if(node == p || node == q){
					numMatches++;
				}
				t = node.right;
			}
		}
		return numMatches;
	}

	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
		if(root == null){
			return null;
		}
		if(root == p || root == q){
			return root;
		}
		TreeNode leftMatch = lowestCommonAncestor(root.left, p, q);
		TreeNode rightMatch = lowestCommonAncestor(root.right, p, q);
		if(leftMatch != null && rightMatch != null){
			return root;
		}
		else if(leftMatch != null){
			return leftMatch;
		}
		else if(rightMatch != null){
			return rightMatch;
		}
		else{
			return null;
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int x){
		val = x;
	}
}
