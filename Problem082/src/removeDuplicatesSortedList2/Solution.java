package removeDuplicatesSortedList2;

public class Solution {

	public ListNode deleteDuplicates(ListNode head){
		//remove duplicate numbers, leaving only distinct numbers
		//1->2->2->3 will become 1->3

		if(head == null || head.next == null)
			return head;

		//new head with a fake node
		ListNode newHead = new ListNode(0);
		ListNode p = newHead;

		ListNode p1 = head;
		ListNode p2 = head;

		while(p1.next!=null){
			if(p1.val != p1.next.val){
				//p1 is not the same with the next, insert p1 into new list
				p.next = p1;
				p = p.next;
				p1 = p1.next;
			}
			else{
				//p1 is the same as the next, search for the next different node
				p2 = p1.next;
				while(p2 != null && p2.val == p1.val){
					p2 = p2.next;
				}
				if(p2 == null){
					p1 = null;
					break;
				}
				else{
					//p2.val != p1.val
					p1 = p2;
				}
			}
		}
		p.next = p1;

		return newHead.next;
	}

	public ListNode deleteDuplicates2(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode p1 = newHead;
		ListNode p2 = head;
		while(p2.next != null){
			if(p2.next.val != p2.val){
				p1 = p2;
				p2 = p2.next;
			}
			else{
				while(p2.next != null && p2.val == p2.next.val){
					p2.next = p2.next.next;
				}
				p1.next = p2.next;
				if(p1.next == null){
					break;
				}
				else{
					p2 = p1.next;
				}
			}
		}
		return newHead.next;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(3);

		Solution sol = new Solution();
		head = sol.deleteDuplicates2(head);
		while(head != null){
			System.out.print(head.val + ", ");
			head = head.next;
		}
		System.out.println();

	}

}
