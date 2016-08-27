package sameTree;

public class Solution {

	public boolean isSameTree(TreeNode p, TreeNode q){
		//recursively check whether the two trees rooted at p and q are the same tree
		
		if(p == null && q == null){
			return true;
		}
		else if(p == null){
			//q != null
			return false;
		}
		else if(q == null){
			//p != null
			return false;
		}
		else{
			//p != null && q != null
			
			return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
