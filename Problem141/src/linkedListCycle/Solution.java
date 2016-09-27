package linkedListCycle;

public class Solution {

	public boolean hasCycle(ListNode head){
		//check if the list has cycle in it
		//use two pointers, one is slow, the other is fast
		
		if(head == null){
			return false;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast != null){
			
			//move fast ahead two nodes 
			fast = fast.next;
			if(fast != null){
				fast = fast.next;
			}
			else{
				return false;
			}
			
			//move slow ahead one node
			slow = slow.next;
			
			if(slow == fast){
				return true;
			}
			
		}
				
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode head = new ListNode(1);
		ListNode p = new ListNode(2);
		head.next = p;
		p.next = new ListNode(3);
		p.next.next = new ListNode(4);
		p.next.next.next = p;
		
		Solution sol = new Solution();
		System.out.println(sol.hasCycle(head));

	}

}
