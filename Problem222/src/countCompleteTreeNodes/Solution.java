package countCompleteTreeNodes;

public class Solution {

	public int countNodes(TreeNode root){
		return count(root);
	}

	private int count(TreeNode root){

		if(root == null){
			return 0;
		}

		TreeNode p = root;
		int leftLength = 0;
		while(p!=null){
			leftLength++;
			p = p.left;
		}

		p = root;
		int rightLength = 0;
		while(p!=null){
			rightLength++;
			p = p.right;
		}

		if(leftLength == rightLength){
			return (1<<leftLength) - 1;
		}
		else{
			return count(root.left) + count(root.right) + 1;
		}

	}

	public int countNodes2(TreeNode root){
		if(root == null){
			return 0;
		}
		int leftLength = countLeftPathLength(root);
		int rightLength = countRightPathLength(root);
		if(leftLength == rightLength){
			return ((1<<leftLength)-1);
		}
		else{
			int numLeftNodes = countNodes(root.left);
			int numRightNodes = countNodes(root.right);
			return numLeftNodes+numRightNodes+1;
		}
	}

	public int countLeftPathLength(TreeNode root){
		TreeNode p = root;
		int length = 0;
		while(p!=null){
			length++;
			p = p.left;
		}
		return length;
	}

	public int countRightPathLength(TreeNode root){
		TreeNode p = root;
		int length = 0;
		while(p!=null){
			length++;
			p = p.right;
		}
		return length;

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		Solution sol = new Solution();
		System.out.println(sol.countNodes2(root));

	}

}

class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int x){
		val = x;
	}
}