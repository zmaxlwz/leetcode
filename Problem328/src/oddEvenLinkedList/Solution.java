package oddEvenLinkedList;

public class Solution {
	
	public ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null || head.next.next == null){
			return head;
		}
		ListNode head2 = new ListNode(0);
		ListNode p = head;
		ListNode q = head2;
		while(p.next != null){
			q.next = p.next;
			p.next = p.next.next;
			q = q.next;
			if(p.next != null){
				p = p.next;
			}			
		}
		q.next = null;
		p.next = head2.next;
		return head;
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
		next = null;
	}
}