package sumRootToLeafNumbers2;

public class Solution {

	int finalSum = 0;

	public int sumNumbers(TreeNode root){
		if(root == null){
			return 0;
		}		
		dfs(root, 0);
		return this.finalSum;
	}
	
	public void dfs(TreeNode root, int partialSum){
		partialSum = partialSum*10 + root.val;
		if(root.left == null && root.right == null){	
			this.finalSum += partialSum;
		}
		else if(root.left == null){
			dfs(root.right, partialSum);
		}
		else if(root.right == null){
			dfs(root.left, partialSum);
		}
		else{
			dfs(root.left, partialSum);
			dfs(root.right, partialSum);
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
