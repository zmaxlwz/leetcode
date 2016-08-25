package partitionList;

public class Solution {

	public ListNode partition(ListNode head, int x){
		//put all nodes less than x in the first part and all nodes >= x in the second part
		//inside each part, preserve the order of nodes

		if(head == null || head.next == null)
			return head;

		//create two heads with fake nodes
		ListNode head1 = new ListNode(0);
		ListNode head2 = new ListNode(0);

		head1.next = head;

		ListNode pre = head1;
		ListNode current = pre.next;
		ListNode p = head2;

		while(current != null){
			if(current.val >= x){
				p.next = current;
				p = p.next;
				pre.next = current.next;
				current = pre.next;
			}
			else{
				pre = current;
				current = pre.next;
			}
		}
		p.next = null;
		pre.next = head2.next;

		return head1.next;
	}

	public ListNode partition2(ListNode head, int x){

		if(head == null || head.next == null){
			return head;
		}

		ListNode head1 = new ListNode(0);
		ListNode head2 = new ListNode(0);
		head1.next = head;

		ListNode p = head2;
		ListNode pre = head1;
		ListNode current = pre.next;
		while(current != null){
			if(current.val < x){
				p.next = current;
				p = p.next;
				pre.next = current.next;
				current = pre.next;
			}
			else{
				pre = current;
				current = pre.next;
			}
		}
		p.next = head1.next;
		return head2.next;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(2);

		int x = 3;
		Solution sol = new Solution();
		head = sol.partition(head, x);
		while(head != null){
			System.out.print(head.val + ", ");
			head = head.next;
		}
		System.out.println();

	}

}
