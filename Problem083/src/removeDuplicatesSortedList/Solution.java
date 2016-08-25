package removeDuplicatesSortedList;

public class Solution {

	public ListNode deleteDuplicates(ListNode head){
		//delete duplicates from sorted list, so that each element only appear once
		
		if(head == null || head.next == null)
			return head;
		
		ListNode p = head;
		while(p.next!=null){
			if(p.val == p.next.val){
				p.next = p.next.next;
			}
			else{
				p = p.next;
			}
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		
		Solution sol = new Solution();
		head = sol.deleteDuplicates(head);
		while(head!=null){
			System.out.print(head.val + ", ");
			head = head.next;
		}
		System.out.println();

	}

}
