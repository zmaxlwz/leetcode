package validateBST2;

public class Solution {

	public boolean isValidBST(TreeNode root){
		return inRange(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	public boolean inRange(TreeNode root, long low, long high){
		if(root == null){
			return true;
		}
		int v = root.val;
		if(v>low && v<high && inRange(root.left, low, v) && inRange(root.right, v, high)){
			return true;
		}
		else{
			return false;
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		
		Solution sol = new Solution();
		//System.out.println(sol.isValidBST(root));
		System.out.println(sol.isValidBST(root));
		

	}

}
