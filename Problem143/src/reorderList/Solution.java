package reorderList;

public class Solution {

	public void reorderList(ListNode head){
		//change a singly-linked list: l0->l1->l2->...->ln-1->ln
		//to list: l0->ln->l1->ln-1->...

		if(head == null || head.next == null || head.next.next == null){
			return;
		}

		ListNode slow = head;
		ListNode fast = head;

		while(fast != null){
			//fast moves ahead two nodes
			fast = fast.next;
			if(fast != null){
				fast = fast.next;
			}
			else{
				break;
			}

			if(fast != null){
				slow = slow.next;
			}
		}

		//divide the list into two parts
		ListNode head2 = slow.next;
		slow.next = null;

		//reverse list head2
		head2 = reverseList(head2);

		//merge list head and head2, the length of list head is equal or greater than list head2
		merge(head, head2);		

		return;
	}

	private ListNode reverseList(ListNode head){
		//reverse the list at head

		if(head == null){
			return null;
		}

		ListNode pre = head;
		ListNode current = pre.next;

		if(current == null){
			//only one node exists
			return head;
		}

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

	private void merge(ListNode head1, ListNode head2){
		//merge head1 and head2 interleavingly

		ListNode p1 = head1;
		ListNode p2 = head2;

		ListNode next1 = null;
		ListNode next2 = null;
		while(p1!=null && p2!=null){
			next1 = p1.next;
			next2 = p2.next;

			p1.next = p2;
			p2.next = next1;

			p1 = next1;
			p2 = next2;
		}

		return;
	}

	public void reorderList2(ListNode head){
		if(head == null || head.next == null || head.next.next == null){
			return;
		}

		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode slow = newHead;
		ListNode fast = newHead;
		while(fast != null){
			slow = slow.next;
			fast = fast.next;
			if(fast == null)
				break;
			fast = fast.next;
			if(fast == null || fast.next == null){
				break;
			}
		}
		ListNode head2 = slow.next;
		slow.next = null;

		head2 = reverseList2(head2);

		ListNode p1 = head;
		ListNode p2 = head2;
		ListNode next1 = null;
		ListNode next2 = null;
		while(p1!=null && p2 != null){
			next1 = p1.next;
			next2 = p2.next;
			p1.next = p2;
			p2.next = next1;
			p1 = next1;			
			p2 = next2;
		}
		return;
	}
	private ListNode reverseList2(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode p1 = head;
		ListNode p2 = p1.next;
		ListNode p3 = null;
		while(p2 != null){
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

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		Solution sol = new Solution();
		sol.reorderList(head);

		ListNode p = head;
		while(p!=null){
			System.out.print(p.val + ", ");
			p = p.next;
		}
		System.out.println();

	}

}
