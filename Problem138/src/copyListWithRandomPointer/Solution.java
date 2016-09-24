package copyListWithRandomPointer;

public class Solution {

	public RandomListNode copyRandomList(RandomListNode head){
		//deep copy a list of nodes with random pointer
		//first insert a copy node after each original node
		//then change the random pointer of the copy node to the next
		//finally break the two lists
		//return the copy list
		
		if(head == null){
			return null;
		}
		
		//insert copy node
		RandomListNode p = head;
		while(p!=null){
			RandomListNode node = new RandomListNode(p.label);
			node.next = p.next;
			node.random = p.random;
			p.next = node;
			p = node.next;
		}
		
		//change the random pointer of the copy node
		p = head.next;
		while(p!=null){
			if(p.random != null)
				p.random = p.random.next;
			if(p.next != null){
				p = p.next.next;
			}
			else{
				p = null;
			}
		}
		
		//break the two lists and change random pointer to next
		RandomListNode head2 = new RandomListNode(0);
		RandomListNode p1 = head;
		RandomListNode p2 = head2;
		
		while(p1!=null){
			p2.next = p1.next;
			p1.next = p1.next.next;
			p1 = p1.next;
			p2 = p2.next;
		}
		p2.next = null;
		
		return head2.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}

}
