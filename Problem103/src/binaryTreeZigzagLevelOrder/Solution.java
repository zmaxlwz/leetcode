package binaryTreeZigzagLevelOrder;

import java.util.*;

public class Solution {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root){
		//use 2 stacks, one includes the nodes in one level, the other includes the nodes in the next level
		//one boolean variable indicates add leftchild first or rightchild first

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if(root == null){
			return result;
		}

		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		Stack<TreeNode> currentStack, theOtherStack;
		boolean leftChildFirst = true;

		List<Integer> list = new ArrayList<Integer>();
		stack1.push(root);
		currentStack = stack1;
		theOtherStack = stack2;
		while(!stack1.isEmpty() || !stack2.isEmpty()){

			if(currentStack.isEmpty()){
				result.add(new ArrayList<Integer>(list));
				list.clear();

				if(!stack1.isEmpty()){
					currentStack = stack1;
					theOtherStack = stack2;
				}
				else{
					currentStack = stack2;
					theOtherStack = stack1;
				}

				leftChildFirst = !leftChildFirst;
			}

			TreeNode node = currentStack.pop();
			list.add(node.val);

			if(leftChildFirst){
				//add left child first, then right child
				if(node.left != null){
					theOtherStack.push(node.left);
				}
				if(node.right != null){
					theOtherStack.push(node.right);
				}
			}
			else{
				//add right child first, then left child
				if(node.right != null){
					theOtherStack.push(node.right);
				}
				if(node.left != null){
					theOtherStack.push(node.left);
				}
			}

		}

		if(!list.isEmpty()){
			result.add(list);
		}

		return result;
	}

	public List<List<Integer>> zigzagLevelOrder2(TreeNode root){
		//use two queues
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null){
			return result;
		}
		LinkedList<TreeNode> queue1 = new LinkedList<TreeNode>();
		LinkedList<TreeNode> queue2 = new LinkedList<TreeNode>();
		List<Integer> list = new ArrayList<Integer>();
		boolean leftFirst = true;
		queue1.offer(root);
		while(!queue1.isEmpty()){
			TreeNode node = queue1.poll();
			if(leftFirst){
				list.add(node.val);
			}
			else{
				list.add(0, node.val);
			}
			if(node.left != null){
				queue2.offer(node.left);
			}
			if(node.right != null){
				queue2.offer(node.right);
			}
			if(queue1.isEmpty()){
				queue1 = queue2;
				leftFirst = !leftFirst;
				queue2 = new LinkedList<TreeNode>();
				result.add(new ArrayList<Integer>(list));
				list.clear();
			}
		}
		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
