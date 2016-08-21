package rotateList;

public class Solution {

	public ListNode rotateRight(ListNode head, int k){
		//rotate the list to the right by k places, k is non-negative
		//k might be greater than the length of the list
		//the same as k = k%L, where L is the length of the list

		if(head == null)
			return null;

		if(k==0)
			return head;

		ListNode p = head;
		int length = 1;

		while(p.next!=null){
			p = p.next;
			length++;
		}

		p.next = head;

		k = k%length;

		int steps = length-k;
		while(steps>0){
			p = p.next;
			steps--;
		}

		head = p.next;
		p.next = null;

		return head;
	}

	public ListNode rotateRight2(ListNode head, int k){
		if(head == null || head.next == null){
			return head;
		}
		int length = 0;
		ListNode p = head;
		while(p != null){
			length++;
			p = p.next;
		}
		k = k%length;
		if(k == 0){
			return head;
		}
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode p1 = newHead, p2 = newHead;
		for(int i =0;i<k;i++){
			p2 = p2.next;
		}
		while(p2.next != null){
			p1 = p1.next;
			p2 = p2.next;
		}
		p2.next = head;
		head = p1.next;
		p1.next = null;
		return head;
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

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		Solution sol = new Solution();
		sol.traverseList(head);
		int k = 8;
		ListNode newHead = sol.rotateRight2(head, k);
		sol.traverseList(newHead);
	}

}
