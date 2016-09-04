package buildTreeInorderPostorder;

public class Solution {

	public TreeNode buildTree(int[] inorder, int[] postorder){
		//build binary tree according to the inorder and postorder traversal arrays
		//recursively call the build method
		
		if(inorder==null || inorder.length==0 || postorder==null || postorder.length==0 || inorder.length!=postorder.length){
			return null;
		}
		
		return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
	}
	
	private TreeNode build(int[] inorder, int start1, int end1, int[] postorder, int start2, int end2){
		//this method is called recursively
		
		if(start1>end1 || start2>end2){
			return null;
		}
		
		int rootValue = postorder[end2];
		int rootIndex = -1;
		for(int i=start1;i<=end1;i++){
			if(inorder[i] == rootValue){
				rootIndex = i;
				break;
			}
		}
		
		int leftTreeSize = rootIndex-start1;
		int rightTreeSize = end1-rootIndex;
		
		TreeNode root = new TreeNode(rootValue);
		root.left = build(inorder, start1, rootIndex-1, postorder, start2, start2+leftTreeSize-1);
		root.right = build(inorder, rootIndex+1, end1, postorder, end2-rightTreeSize, end2-1);
		
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
