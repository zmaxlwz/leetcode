package reverseLinkedList;

public class Solution {

	public ListNode reverseList(ListNode head){
		//iterative method to reverse a list
		if(head == null || head.next == null){
			return head;
		}

		ListNode pre = head;
		ListNode current = pre.next;
		ListNode next = null;
		while(current != null){
			next = current.next;
			current.next = pre;
			pre = current;
			current = next;
		}
		head.next = null;
		return pre;
	}

	public ListNode reverseList2(ListNode head){
		//recursive method to reverse a list
		if(head == null || head.next == null){
			return head;
		}
		return reverse(head);

	}

	private ListNode reverse(ListNode head){
		if(head.next == null){
			return head;
		}
		ListNode nextNode = head.next;
		head.next = null;
		ListNode newHead = reverse(nextNode);
		nextNode.next = head;
		return newHead;
	}

	public ListNode reverseList3(ListNode head){
		//iterative method
		if(head == null || head.next == null){
			return head;
		}
		ListNode p1 = head;
		ListNode p2 = p1.next;
		ListNode p3 = null;
		while(p2!=null){
			p3 = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = p3;

		}
		head.next = null;
		return p1;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}
