package mergeKSortedLists;

import java.util.Comparator;

public class ListNodeComparator implements Comparator<ListNode> {

	public ListNodeComparator() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public int compare(ListNode node1, ListNode node2){
		
		if(node1.val < node2.val)
			return -1;
		else if(node1.val == node2.val)
			return 0;
		else
			return 1;
	}

}
