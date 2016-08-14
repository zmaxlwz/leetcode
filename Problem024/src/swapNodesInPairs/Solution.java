package swapNodesInPairs;

public class Solution {

	public ListNode swapPairs(ListNode head){

		//empty list or only one node list
		if(head == null || head.next == null)
			return head;

		//fake node
		ListNode newList = new ListNode(0);
		ListNode p = newList;
		ListNode p1 = head;
		ListNode p2 = p1.next;

		while(p1 != null && p2 != null){
			p.next = p2;
			p1.next = p2.next;
			p2.next = p1;
			p1 = p1.next;
			p = p.next.next;
			if(p1 != null){
				p2 = p1.next;
			}
			else{
				p2 = null;
			}
		}
		if(p1 != null){
			p.next = p1;
		}

		return newList.next;
	}

	public ListNode swapPairs2(ListNode head){
		if(head == null || head.next == null){
			return head;
		}		
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode p = newHead, p1 = p.next, p2 = p1.next;
		while(true){
			p.next = p2;
			p1.next = p2.next;
			p2.next = p1;
			p = p1;
			if(p.next == null){
				break;
			}
			p1 = p.next;
			if(p1.next == null){
				break;
			}
			p2 = p1.next;
		}
		return newHead.next;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode list = new ListNode(1);
		list.next = new ListNode(2);
		list.next.next = new ListNode(3);
		list.next.next.next = new ListNode(4);
		list.next.next.next.next = new ListNode(5);

		Solution sol = new Solution();
		ListNode newList = sol.swapPairs2(list);
		ListNode p = newList;
		while(p!=null){
			System.out.print(p.val + ", ");
			p = p.next;
		}
	}

}
