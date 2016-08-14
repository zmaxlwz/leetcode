package mergeKSortedLists2;

import java.util.*;

public class Solution {

	public ListNode mergeKLists(ListNode[] lists){
		if(lists == null || lists.length == 0){
			return null;
		}
		int numLists = lists.length;
		ListNode head = new ListNode(0);
		ListNode p = head;
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(numLists, new ListNodeComparator());
		for(int i =0;i<numLists;i++){
			if(lists[i] != null){
				pq.offer(lists[i]);
			}
		}
		while(!pq.isEmpty()){
			p.next = pq.poll();
			p = p.next;
			if(p.next != null){
				pq.offer(p.next);
			}
		}
		p.next = null;
		return head.next;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode p1 = new ListNode(3);
		p1.next = new ListNode(5);
		p1.next.next = new ListNode(6);
		ListNode p2 = new ListNode(2);
		p2.next = new ListNode(7);
		p2.next.next = new ListNode(8);
		ListNode p3 = new ListNode(1);
		p3.next = new ListNode(9);
		p3.next.next = new ListNode(10);
		/*
		ListNode[] lists = new ListNode[3];
		lists[0] = p1;
		lists[1] = p2;
		lists[2] = p3;
		*/
		ListNode[] lists = new ListNode[0];
		Solution sol = new Solution();
		ListNode p = sol.mergeKLists(lists);
		while(p!=null){
			System.out.print(p.val + ", ");
			p = p.next;
		}

	}

}

class ListNodeComparator implements Comparator<ListNode>{

	public int compare(ListNode n1, ListNode n2){
		return n1.val - n2.val;
	}
}