package buildTreePreorderInorder;

public class Solution {

	public TreeNode buildTree(int[] preorder, int[] inorder){
		//use preorder and inorder traversal array to construct a binary tree
		//the first element in preorder is the root, search it in inorder to divide two subtrees
		
		if(preorder == null || preorder.length == 0 || inorder==null || inorder.length==0 || preorder.length!=inorder.length){
			return null;
		}		
		
		return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
	}
	
	private TreeNode build(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2){
		//recursive construct tree
		
		if(start1>end1 || start2>end2){
			return null;
		}
		//the root value
		int rootValue = preorder[start1];
		int rootIndex = -1;
		for(int i=start2;i<=end2;i++){
			if(inorder[i] == rootValue){
				rootIndex = i;
				break;
			}
		}
		
		if(rootIndex<0)
			return null;
		
		int leftTreeSize = rootIndex-start2;
		int rightTreeSize = end2-rootIndex;
		//create root node
		TreeNode root = new TreeNode(rootValue);
		root.left = build(preorder, start1+1, start1+leftTreeSize, inorder, start2, rootIndex-1);
		root.right = build(preorder, end1-rightTreeSize+1, end1, inorder, rootIndex+1, end2);
		
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
