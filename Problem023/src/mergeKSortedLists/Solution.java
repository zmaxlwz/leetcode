package mergeKSortedLists;

import java.util.*;

public class Solution {

	public ListNode mergeKLists(ListNode[] lists){
		
		//the first node is a fake node
		ListNode mergedList = new ListNode(0);
		ListNode p = mergedList;
		
		if(lists == null || lists.length == 0)
			return null;
		
		ListNodeComparator comp = new ListNodeComparator();
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, comp);
		
		for(int i=0;i<lists.length;i++){
			if(lists[i] != null)
				pq.add(lists[i]);
		}
		
		while(!pq.isEmpty()){
			p.next = pq.poll();
			p = p.next;
			if(p.next !=null){
				pq.add(p.next);
			}
		}
				
		return mergedList.next;
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
