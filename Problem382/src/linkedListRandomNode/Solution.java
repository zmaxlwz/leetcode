package linkedListRandomNode;

public class Solution {
	
	ListNode head;
	int length;
	
	/** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
	public Solution(ListNode head) {
		this.head = head;
		this.length = 0;
		ListNode p = head;
		while(p!=null){
			this.length++;
			p = p.next;
		}
	}

	/** Returns a random node's value. */
	public int getRandom() {
		int ranNum = (int)(Math.random()*this.length);
		ListNode node = this.head;
		for(int i=0;i<ranNum;i++){
			node = node.next;
		}
		
		return node.val;
    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class ListNode{
	int val;
	ListNode next;
	ListNode(int v){
		val = v;
	}
}