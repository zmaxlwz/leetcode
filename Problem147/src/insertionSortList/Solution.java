package insertionSortList;

public class Solution {

	public ListNode insertionSortList(ListNode head){
		//perform insertion sort on the list

		if(head == null || head.next == null){
			return head;
		}

		ListNode head2 = new ListNode(Integer.MIN_VALUE);
		head2.next = head;

		ListNode pre = head;
		ListNode current = pre.next;
		ListNode next = null;

		while(current != null){
			next = current.next;
			if(current.val < pre.val){
				//move current ahead
				ListNode p1 = head2;
				ListNode p2 = p1.next;
				while(p2.val<current.val){
					p1 = p2;
					p2 = p1.next;
				}
				p1.next = current;
				current.next = p2;

				pre.next = next;
				current = next;

			}
			else{
				pre = current;
				current = next;
			}

		}

		return head2.next;
	}

	public ListNode insertionSortList2(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode newHead = new ListNode(Integer.MIN_VALUE);
		newHead.next = head;
		ListNode pre = head;
		ListNode current = pre.next;
		while(current != null){
			//insert current into the previous list
			if(current.val < pre.val){
				pre.next = current.next;
				insert(current, newHead);
				current = pre.next;	
			}
			else{
				pre = current;
				current = pre.next;
			}

		}
		return newHead.next;
	}
	private void insert(ListNode current, ListNode head){
		ListNode p = head;
		while(current.val >= p.next.val){
			p = p.next;
		}
		ListNode next = p.next;
		p.next = current;
		current.next = next;
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head = new ListNode(5);
		head.next = new ListNode(3);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(1);

		Solution sol = new Solution();
		head = sol.insertionSortList(head);
		while(head != null){
			System.out.print(head.val + ", ");
			head = head.next;
		}
		System.out.println();

	}

}
