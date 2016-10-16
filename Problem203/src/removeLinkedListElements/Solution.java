package removeLinkedListElements;

public class Solution {

	public ListNode removeElements(ListNode head, int val){
		if(head == null){
			return head;
		}

		ListNode newHead = new ListNode(0);
		newHead.next = head;

		ListNode p = newHead;
		while(p.next!=null){
			if(p.next.val == val){
				p.next = p.next.next;
			}
			else{
				p = p.next;
			}
		}
		return newHead.next;
	}

	public ListNode removeElements2(ListNode head, int val){
		//remove all nodes with val from the list
		if(head == null){
			return null;
		}
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode p1 = fakeHead;
		ListNode p2 = p1.next;
		while(p2!=null){
			if(p2.val == val){
				p1.next = p2.next;
				p2 = p1.next;
			}
			else{
				p1 = p2;
				p2 = p1.next;
			}
		}
		return fakeHead.next;
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
