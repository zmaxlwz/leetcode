package palindromeLinkedList;

public class Solution {

	public boolean isPalindrome(ListNode head){
		if(head == null || head.next == null){
			return true;
		}

		ListNode head2 = new ListNode(0);
		ListNode p1 = head;
		ListNode p2 = null;
		while(p1!=null){
			p2 = new ListNode(p1.val);
			p2.next = head2.next;
			head2.next = p2;
			p1 = p1.next;
		}
		p1 = head;
		p2 = head2.next;
		while(p1!=null){
			if(p1.val != p2.val){
				return false;
			}
			p1 = p1.next;
			p2 = p2.next;
		}
		return true;
	}

	public boolean isPalindrome2(ListNode head){

		ListNode head2 = null;
		ListNode p = head;
		while(p != null){
			ListNode node = new ListNode(p.val);
			node.next = head2;
			head2 = node;
			p = p.next;
		}

		p = head;
		ListNode q = head2;
		while(p!=null){
			if(p.val != q.val){
				return false;
			}
			p = p.next;
			q = q.next;
		}
		return true;
	}

	public boolean isPalindrome3(ListNode head){
		if(head == null || head.next == null){
			return true;
		}
		ListNode p1 = head;
		ListNode p2 = head.next;
		while(p2.next != null){
			p1 = p1.next;
			p2 = p2.next;
			if(p2.next != null){
				p2 = p2.next;
			}
		}
		ListNode head2 = reverse(p1.next);
		p1 = head;
		p2 = head2;
		while(p2!=null){
			if(p1.val != p2.val){
				return false;
			}
			p1 = p1.next;
			p2 = p2.next;
		}
		return true;
	}

	public ListNode reverse(ListNode head){
		ListNode p= head;
		ListNode q = p.next;
		ListNode next;
		while(q!=null){
			next = q.next;
			q.next = p;
			p = q;
			q = next;
		}
		head.next = null;
		return p;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head = new ListNode(3);
		head.next = new ListNode(9);
		head.next.next = new ListNode(9);
		head.next.next.next = new ListNode(3);

		Solution sol = new Solution();
		System.out.println(sol.isPalindrome3(head));

	}

}

class ListNode{

	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}

