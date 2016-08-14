package reverseKGroup;

public class Solution {

	public ListNode reverseKGroup(ListNode head, int k){

		if(head == null || k <=1)
			return head;

		//fake node
		ListNode newList = new ListNode(0);
		ListNode p = newList;

		//group start pointer
		ListNode start = head;
		//group end pointer, the next node after the group
		ListNode end = head;

		while(end!=null){
			start = end;

			for(int i = 0; i<k; i++){
				if(end!=null){
					end = end.next;
				}
				else{
					//the number of nodes is smaller than k
					//don't reverse, directly return the list
					p.next = start;
					return newList.next;
				}
			}

			p.next = reverseList(start, end);
			p = start;

		}
		p.next = null;

		return newList.next;
	}

	private ListNode reverseList(ListNode start, ListNode end){

		//reverse the nodes from start to end-1
		ListNode pre = start;
		ListNode current = pre.next;
		ListNode next = current.next;

		while(current != end){
			current.next = pre;
			pre = current;
			current = next;
			if(current != null)
				next = current.next;
			else
				break;
		}

		return pre;
	}

	public ListNode reverseKGroup2(ListNode head, int k){
		if(head == null || head.next == null){
			return head;
		}
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode pre = newHead;
		ListNode start, end;
		while(true){
			start = pre.next;
			end = pre;
			boolean hasGroup = true;
			for(int i=0;i<k;i++ ){
				end = end.next;
				if(end == null){
					hasGroup = false;
					break;
				}
			}
			if(!hasGroup){
				break;
			}
			pre.next = reverse(start, end);
			pre = start;
		}
		return newHead.next;
	}

	public ListNode reverse(ListNode head, ListNode tail){
		ListNode afterNode = tail.next;
		ListNode pre = head, current = pre.next, next;
		while(current != afterNode){
			next = current.next;
			current.next = pre;
			pre = current;
			current = next;
		}
		head.next = afterNode;
		return tail;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode list = new ListNode(1);
		list.next = new ListNode(2);
		list.next.next = new ListNode(3);
		list.next.next.next = new ListNode(4);
		list.next.next.next.next = new ListNode(5);

		int k = 3;

		Solution sol = new Solution();
		ListNode reversedList = sol.reverseKGroup(list, k);
		ListNode p = reversedList;
		while(p!=null){
			System.out.print(p.val + ", ");
			p = p.next;
		}

	}

}
