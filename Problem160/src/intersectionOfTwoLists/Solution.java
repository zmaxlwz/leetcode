package intersectionOfTwoLists;

public class Solution {


	public ListNode getIntersectionNode(ListNode headA, ListNode headB){

		ListNode p1 = headA;
		ListNode p2 = headB;
		int count1 = 0;
		int count2 = 0;

		while(p1 != null){
			count1++;
			if(p1.next == null){
				break;
			}
			else{
				p1 = p1.next;
			}
		}

		while(p2 != null){
			count2++;
			if(p2.next == null){
				break;
			}
			else{
				p2 = p2.next;
			}
		}

		if(p1 != p2){
			//there is no intersection of the two lists
			return null;
		}

		p1 = headA;
		p2 = headB;
		if(count1 > count2){
			for(int i=0;i<count1-count2;i++){
				p1 = p1.next;
			}
		}
		else if(count2 > count1){
			for(int i=0;i<count2-count1;i++){
				p2 = p2.next;
			}
		}

		while(p1 != p2){
			p1 = p1.next;
			p2 = p2.next;
		}

		return p1;
	}

	public ListNode getIntersectionNode2(ListNode headA, ListNode headB){
		if(headA == null || headB == null){
			return null;
		}
		ListNode p1 = headA;
		ListNode p2 = headB;
		int length1 = 1;
		int length2 = 1;
		while(p1.next != null){
			p1 = p1.next;
			length1++;
		}
		while(p2.next != null){
			p2 = p2.next;
			length2++;
		}
		if(p1 != p2){
			return null;
		}
		p1 = headA;
		p2 = headB;
		if(length1>length2){
			for(int i=0;i<length1-length2;i++){
				p1 = p1.next;
			}
		}
		else if(length2>length1){
			for(int i=0;i<length2-length1;i++){
				p2 = p2.next;
			}
		}
		while(p1 != p2){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class ListNode{
	int val;
	ListNode next;

	ListNode(int x){
		val = x;
	}
}
