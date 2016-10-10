package binarySearchTreeIterator;

import java.util.*;

public class BSTIterator {

	Stack<TreeNode> stack;

	public BSTIterator(TreeNode root){
		stack = new Stack<TreeNode>();
		addLeftNodes(root);
	}

	private void addLeftNodes(TreeNode root){
		TreeNode p = root;
		while(p != null){
			stack.push(p);
			p = p.left;
		}

	}

	public boolean hasNext(){
		return !stack.isEmpty();
	}

	public int next(){
		TreeNode p = stack.pop();
		addLeftNodes(p.right);
		return p.val;
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.right = new TreeNode(3);

		BSTIterator iter = new BSTIterator(root);
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}

}

class TreeNode{

	int val;
	TreeNode left, right;
	TreeNode(int x){
		val = x;
	}
}

class BSTIterator2{
	private Stack<TreeNode> stack;
	public BSTIterator2(TreeNode root){
		stack = new Stack<TreeNode>();
		TreeNode p = root;
		while(p!=null){
			stack.push(p);
			p = p.left;
		}
	}

	public boolean hasNext(){
		return !stack.isEmpty();
	}

	public int next(){
		TreeNode p = stack.pop();
		int result = p.val;
		TreeNode q = p.right;
		while(q!=null){
			stack.push(q);
			q = q.left;
		}
		return result;
	}
}
