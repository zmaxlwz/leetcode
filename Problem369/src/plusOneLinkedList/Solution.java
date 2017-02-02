package plusOneLinkedList;

public class Solution {
	
	public ListNode plusOne(ListNode head) {
		
		if(head == null){
			return new ListNode(1);
		}
		
		head = reverse(head);
		ListNode p = head;
		int carry = 1;
		while(carry>0){
			int val = p.val + 1;
			p.val = val%10;
			carry = val/10;
			if(p.next == null){
				break;
			}
			else{
				p = p.next;
			}
		}
		if(carry > 0){
			p.next = new ListNode(carry);
		}
		
		head = reverse(head);
		
		return head;
    }
	
	private ListNode reverse(ListNode head){
		
		if(head.next == null){
			return head;
		}
		
		ListNode p1 = head, p2 = head.next, p3;
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
	ListNode(int v){
		val = v;
	}
}