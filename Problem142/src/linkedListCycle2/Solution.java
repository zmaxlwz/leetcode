package linkedListCycle2;


public class Solution {

	public ListNode detectCycle(ListNode head){
		//if there is cycle, then return the node that the cycle begins
		//if there is no cycle, then return null
		
		if(head == null){
			return null;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		ListNode meetNode = null;
		
		while(fast != null){
			//fast moves ahead two nodes
			fast = fast.next;
			if(fast != null){
				fast = fast.next;
			}
			else{
				return null;
			}
			//slow moves ahead one node
			slow = slow.next;
			
			if(fast == slow){
				//record the meet node
				meetNode = fast;
				break;
			}
		}
		
		if(fast == null){
			return null;
		}
		
		//there is cycle, find the cycle begin node
		ListNode p1 = head;
		ListNode p2 = meetNode;
		//p1 and p2 will meet at the cycle beginning node
		while(p1 != p2){
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p1;
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
		ListNode node = sol.detectCycle(head);
		System.out.println(node.val);
		
	}

}
