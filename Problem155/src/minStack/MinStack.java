package minStack;

public class MinStack {

	ListNode head;

	public void push(int x){
		ListNode node = new ListNode(x);
		if(head == null){
			head = node;
			node.min = x;
			node.next = null;
		}
		else{
			node.next = head;
			node.min = Math.min(x, node.next.min);
			head = node;
		}
	}

	public void pop(){
		if(head != null){
			head = head.next;
		}
	}

	public int top(){
		if(head != null){
			return head.value;
		}
		else{
			return -1;
		}
	}

	public int getMin(){
		if(head != null){
			return head.min;
		}
		else{
			return -1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class ListNode{
	int value;
	int min;
	ListNode next;

	ListNode(int x){
		value = x;
	}
} 