package sortedListToBST;

public class Solution {
	
	ListNode p;
	
	public TreeNode sortedListToBST(ListNode head){
		
		int count = 0;
		p = head;
		while(p!=null){
			count++;
			p = p.next;
		}
		
		p = head;
		
		return buildBST(count);
	}
	
	private TreeNode buildBST(int count){
		
		if(count <= 0){
			return null;
		}
		
		TreeNode left;
		if(count%2 == 0){
			left = buildBST(count/2-1);
		}
		else{
			left = buildBST(count/2);
		}
		
		TreeNode root = new TreeNode(p.val);
		p = p.next;
		
		TreeNode right = buildBST(count/2);
		
		root.left = left;
		root.right = right;
		
		return root;
		
	}

}
