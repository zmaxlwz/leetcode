package removeNthNodeFromEnd;

public class Solution {

	public ListNode removeNthFromEnd(ListNode head, int n){

		//use a fast pointer and a slower pointer
		//faster pointer is n nodes ahead of slower pointer
		ListNode slow = head;
		ListNode fast = head;

		for(int i=0;i<n;i++){
			fast = fast.next;
		}

		//********easy to make mistake********
		if(fast == null){
			//need to remove the head node
			head = head.next;
			return head;
		}

		while(fast.next !=null){
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;

		return head;
	}

	public ListNode removeNthFromEnd2(ListNode head, int n){
		if(head == null || head.next == null){
			return null;
		}
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode p1 = newHead, p2 = newHead;
		for(int i =0; i<n;i++ ){
			p2 = p2.next;
		}
		while(p2.next != null){
			p1 = p1.next;
			p2 = p2.next;
		}
		p1.next = p1.next.next;
		return newHead.next;
	}


	public void traverseList(ListNode head){
		ListNode p = head;
		while(p!=null){
			System.out.print(p.val + ", ");
			p = p.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head = null;		
		ListNode p = null;
		int len = 5;
		while(len>0){
			p = new ListNode(len);
			p.next = head;
			head = p;
			len--;
		}
		Solution sol = new Solution();
		sol.traverseList(head);
		int n = 2;
		sol.removeNthFromEnd(head, n);
		sol.traverseList(head);

	}

}
