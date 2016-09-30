package sortList;

public class Solution {

	public ListNode sortList(ListNode head){
		//sort the list using O(nlgn) time and constant space
		//use merge sort

		if(head == null || head.next == null){
			return head;
		}

		//divide the list into 2 lists
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null){
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

		ListNode head2 = slow.next;
		slow.next = null;

		head = sortList(head);
		head2 = sortList(head2);

		return merge(head, head2);
	}

	private ListNode merge(ListNode head1, ListNode head2){
		//merge the two sorted list into a single sorted list

		if(head1 == null){
			return head2;
		}

		if(head2 == null){
			return head1;
		}

		//fake node
		ListNode head = new ListNode(0);
		ListNode p = head;
		ListNode p1 = head1;
		ListNode p2 = head2;

		while(p1!=null && p2!=null){
			if(p1.val < p2.val){
				p.next = p1;
				p = p.next;
				p1 = p1.next;
			}
			else{
				p.next = p2;
				p = p.next;
				p2 = p2.next;
			}
		}

		if(p1 == null){
			p.next = p2;
		}
		else{
			//p2 == null
			p.next = p1;
		}

		return head.next;
	}


	public ListNode sortList2(ListNode head){
		return mergeSort(head);
	}

	private ListNode mergeSort(ListNode head){
		if(head == null || head.next == null){
			//zero or one node
			return head;
		}
		//use slow and fast pointer to find middle point
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null){
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
			else{
				break;
			}
		}
		ListNode head2 = slow.next;
		slow.next = null;
		head = mergeSort(head);
		head2 = mergeSort(head2);
		return merge2(head, head2);

	}

	private ListNode merge2(ListNode head1, ListNode head2){
		ListNode p1 = head1, p2 = head2;
		ListNode newHead = new ListNode(0);
		ListNode p = newHead;
		while(p1 != null && p2 != null){
			if(p1.val < p2.val){
				p.next = p1;
				p1 = p1.next;
				p = p.next;
			}
			else{
				p.next = p2;
				p2 = p2.next;
				p = p.next;
			}
		}
		if(p1 != null){
			p.next = p1;
		}
		else if(p2 != null){
			p.next = p2;
		}
		else{
			p.next = null;
		}
		return newHead.next;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head = new ListNode(5);
		head.next = new ListNode(2);
		head.next.next = new ListNode(4);
		head.next.next.next = new ListNode(1);
		head.next.next.next.next = new ListNode(3);

		Solution sol = new Solution();
		head = sol.sortList(head);
		while(head != null){
			System.out.print(head.val + ", ");
			head = head.next;
		}
		System.out.println();

	}

}
