package largestBSTSubtree;

public class Solution {
	
	int maxBSTSize = 0;
	
	public int largestBSTSubtree(TreeNode root) {
		
		if(root == null){
			return 0;
		}
		
		search(root);
		
		return maxBSTSize;
    }
	
	private SearchResult search(TreeNode root){
		
		if(root.left == null && root.right == null){
			//the node is a leaf
			if(maxBSTSize<1){
				maxBSTSize = 1;
			}
			return new SearchResult(true, root.val, root.val, 1);
		}
		else if(root.left == null){
			//only has right child
			SearchResult rightResult = search(root.right);
			if(rightResult.isBST && root.val < rightResult.min){
				int size = rightResult.size + 1;
				if(maxBSTSize < size){
					maxBSTSize = size;
				}
				return new SearchResult(true, root.val, rightResult.max, size);
			}
			else{
				return new SearchResult(false, rightResult.min, rightResult.max, 0);
			}
		}
		else if(root.right == null){
			//only has left child
			SearchResult leftResult = search(root.left);
			if(leftResult.isBST && root.val > leftResult.max){
				int size = leftResult.size + 1;
				if(maxBSTSize < size){
					maxBSTSize = size;
				}
				return new SearchResult(true, leftResult.min, root.val, size);
			}
			else{
				return new SearchResult(false, leftResult.min, leftResult.max, 0);
			}
			
		}
		else{
			//has both left and right child
			SearchResult leftResult = search(root.left);			
			SearchResult rightResult = search(root.right);
			if(leftResult.isBST && rightResult.isBST && root.val > leftResult.max && root.val < rightResult.min){
				int size = leftResult.size + rightResult.size + 1;
				if(maxBSTSize < size){
					maxBSTSize = size;
				}
				return new SearchResult(true, leftResult.min, rightResult.max, size);
			}
			else{
				return new SearchResult(false, leftResult.min, rightResult.max, 0);
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(8);
		root.right.right = new TreeNode(7);

		System.out.println(sol.largestBSTSubtree(root));
	}

}

class SearchResult{
	boolean isBST;
	int min;
	int max;
	int size;
	SearchResult(boolean isBST, int min, int max, int size){
		this.isBST = isBST;
		this.min = min;
		this.max = max;
		this.size = size;
	}
}

class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int v){
		val = v;
		left = null;
		right = null;
	}
}