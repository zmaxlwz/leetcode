package implementStackUsingQueues;

import java.util.*;

public class MyStack {

	LinkedList<Integer> queue1, queue2;

	public MyStack(){
		queue1 = new LinkedList<Integer>();
		queue2 = new LinkedList<Integer>();
	}

	public void push(int x){
		if(empty()){
			queue1.offer(x);
		}	
		else if(queue1.isEmpty()){
			queue1.offer(x);
			while(!queue2.isEmpty()){
				queue1.offer(queue2.poll());
			}
		}
		else{
			queue2.offer(x);
			while(!queue1.isEmpty()){
				queue2.offer(queue1.poll());
			}
		}

	}

	public void pop(){
		if(!queue1.isEmpty()){
			queue1.poll();
		}
		else{
			queue2.poll();
		}
	}

	public int top(){
		if(!queue1.isEmpty()){
			return queue1.peek();
		}
		else{
			return queue2.peek();
		}
	}

	public boolean empty(){
		return queue1.isEmpty() && queue2.isEmpty();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
