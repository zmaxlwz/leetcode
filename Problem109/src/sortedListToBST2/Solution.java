package sortedListToBST2;

public class Solution {

	private ListNode p;

	public TreeNode sortedListToBST(ListNode head){
		p = head;
		ListNode p1 = head;
		int length = 0;
		while(p1 != null){
			length++;
			p1 = p1.next;
		}
		return buildTree(length);
	}
	
	public TreeNode buildTree(int count){
		if(count<=0){
			return null;
		}
		int leftLength = (count-1)/2;
		int rightLength = count/2;
		TreeNode leftChild = buildTree(leftLength);
		TreeNode root = new TreeNode(p.val);
		p = p.next;
		TreeNode rightChild = buildTree(rightLength);
		root.left = leftChild;
		root.right = rightChild;
		return root;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
