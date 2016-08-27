package reverseLinkedList2;

public class Solution {

	public ListNode reverseBetween(ListNode head, int m, int n){
		//reverse nodes between position m and position n
		//1<=m<=n<=length of list

		if(head == null || head.next == null || m==n)
			return head;

		//new head with a fake node
		ListNode newHead = new ListNode(0);
		newHead.next = head;

		ListNode pre = newHead;
		int count = 1;
		while(count<m){
			pre = pre.next;
			count++;
		}

		ListNode p1 = pre.next;
		ListNode p2 = p1.next;
		ListNode p3 = p2.next;

		count = m+1;
		while(count<=n){
			p2.next = p1;
			p1 = p2;
			p2 = p3;
			if(p2!=null){
				p3 = p2.next;
			}
			count++;
		}
		pre.next.next = p2;
		pre.next = p1;

		return newHead.next;
	}

	public ListNode reverseBetween2(ListNode head, int m, int n){
		if(head == null || head.next == null){
			return head;
		}
		if(m==n){
			return head;
		}
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode p1 = newHead;
		for(int i =1;i<=m-1;i++){
			p1 = p1.next;
		}
		ListNode p2 = p1;
		for(int i =1;i<=n-m+1;i++){
			p2 = p2.next;
		}
		p1.next = reverse(p1.next, p2);
		return newHead.next;
	}
	
	public ListNode reverse(ListNode start, ListNode end){
		ListNode afterEnd = end.next;
		ListNode p1 = start, p2 = p1.next, p3;
		while(p2!=afterEnd){
			p3 = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = p3;
		}
		start.next = afterEnd;
		return end;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		int m = 3;
		int n = 5;

		Solution sol = new Solution();
		head = sol.reverseBetween2(head, m, n);
		while(head!=null){
			System.out.print(head.val + ", ");
			head = head.next;
		}
		System.out.println();
	}

}
