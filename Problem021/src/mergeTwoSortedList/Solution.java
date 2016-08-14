package mergeTwoSortedList;

public class Solution {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		//merge two sorted list

		ListNode mergedHead = new ListNode(0);
		ListNode p = mergedHead;
		ListNode p1 = l1, p2=l2;

		while(p1!=null && p2!=null){
			if(p1.val < p2.val){
				//add the first node in p1 to merged list
				p.next = p1;
				p1= p1.next;
				p = p.next;
			}
			else{
				//add the first node in p2 to merged list
				p.next = p2;
				p2 = p2.next;
				p = p.next;
			}
		}

		if(p1 == null){
			p.next = p2;
		}
		else{
			//p2 == null
			p.next = p1;
		}

		return mergedHead.next;
	}

	public ListNode mergeTwoLists2(ListNode l1, ListNode l2){
		if(l1 == null){
			return l2;
		}
		if(l2 == null){
			return l1;
		}
		ListNode newHead1 = new ListNode(0);
		newHead1.next = l1;
		ListNode newHead2 = new ListNode(0);
		newHead2.next = l2;
		ListNode newHead = new ListNode(0);
		ListNode p1 = newHead1, p2 = newHead2, p = newHead;

		while(p1.next != null && p2.next != null){
			if(p1.next.val <= p2.next.val){
				p.next = p1.next;		
				p1.next = p1.next.next;
			}
			else{
				p.next = p2.next;
				p2.next = p2.next.next;
			}
			p = p.next;
		}
		if(p1.next == null){
			p.next = p2.next;
		}
		else{
			p.next = p1.next;
		}
		return newHead.next;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head1 = new ListNode(3);
		head1.next = new ListNode(5);
		head1.next.next = new ListNode(6);

		ListNode head2 = new ListNode(2);
		head2.next = new ListNode(7);
		head2.next.next = new ListNode(8);

		Solution sol = new Solution();		
		ListNode p = sol.mergeTwoLists2(head1, head2);
		while(p!=null){
			System.out.print(p.val + ", ");
			p = p.next;
		}
	}

}
