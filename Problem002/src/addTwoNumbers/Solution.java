package addTwoNumbers;

public class Solution {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2){

		//p1 is tracking list1
		ListNode p1 = l1;
		//p2 is tracking list2
		ListNode p2 = l2;
		//result list
		ListNode result = null;
		//p3 is tracking result list
		ListNode p3 = result;

		//carry, 0 or 1
		int carry = 0;
		//digit sum
		int digit_sum = 0;
		//digit value
		int digit_value = 0;

		while(p1 != null || p2 != null || carry>0){

			int d1, d2;

			if(p1 != null)
				d1 = p1.val;
			else
				d1 = 0;

			if(p2 != null)
				d2 = p2.val;
			else
				d2 = 0;

			digit_sum = d1 + d2 + carry;

			//new carry
			carry = digit_sum/10;
			digit_value = digit_sum%10;

			if(result == null){
				result = new ListNode(digit_value);
				p3 = result;
			}
			else{
				p3.next = new ListNode(digit_value);
				p3 = p3.next;
			}

			if(p1 != null)
				p1 = p1.next;
			if(p2 != null)
				p2 = p2.next;
		}

		return result;
	}

	public ListNode addTwoNumbers2(ListNode l1, ListNode l2){
		if(l1 == null){
			return l2;
		}
		if(l2 == null){
			return l1;
		}
		ListNode head = new ListNode(0);
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode p = head;
		int carry = 0;
		int result = 0;
		while(p1 != null && p2 != null){
			result = p1.val + p2.val + carry;
			carry = result/10;
			p.next = new ListNode(result%10);
			p = p.next;
			p1 = p1.next;
			p2 = p2.next;
		}
		if(p1 == null && p2 == null){
			if(carry>0){
				p.next = new ListNode(carry);
			}
		}
		else if(p1 == null){
			p.next = p2;
			while(carry>0){

				result = p2.val + carry;
				carry = result/10;
				p2.val = result%10;
				if(p2.next != null){
					p2 = p2.next;
				}
				else if(carry>0){
					p2.next = new ListNode(carry);
					break;
				}
			}
		}
		else if(p2 == null){
			p.next = p1;
			while(carry>0){

				result = p1.val + carry;
				carry = result/10;
				p1.val = result%10;
				if(p1.next != null){
					p1 = p1.next;
				}
				else if(carry>0){
					p1.next = new ListNode(carry);
					break;
				}
			}

		}
		return head.next;
	}

	public ListNode addTwoNumbers3(ListNode l1, ListNode l2){
		if(l1 == null){
			return l2;
		}
		if(l2 == null){
			return l1;
		}
		ListNode head = new ListNode(0);
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode p = head;
		int carry = 0;
		int result = 0;
		int d1 = 0;
		int d2 = 0;

		while(p1 != null || p2 != null || carry>0){
			if(p1 != null){
				d1 = p1.val;
			}
			else{
				d1 = 0;
			}
			if(p2 != null){
				d2 = p2.val;
			}
			else{
				d2 = 0;
			}
			result = d1 + d2 + carry;
			carry = result/10;
			p.next = new ListNode(result%10);
			p = p.next;
			if(p1 != null){
				p1 = p1.next;
			}
			if(p2 != null){
				p2 = p2.next;
			}

		}
		return head.next;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode l1 = new ListNode(2);
		//System.out.println(n.val);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		//l1.next.next.next = new ListNode(2);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		Solution s = new Solution();
		ListNode result = s.addTwoNumbers3(l1, l2);
		ListNode l3 = result;
		while(l3!=null){
			System.out.println(l3.val);
			l3 = l3.next;
		}
	}

}
