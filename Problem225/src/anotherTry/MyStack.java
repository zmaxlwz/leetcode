package anotherTry;

import java.util.*;

public class MyStack {

	LinkedList<Integer> queue1;
	LinkedList<Integer> queue2;

	MyStack(){
		queue1 = new LinkedList<Integer>();
		queue2 = new LinkedList<Integer>();
	}

	public void push(int x){
		LinkedList<Integer> emptyQueue;
		LinkedList<Integer> theOtherQueue;
		if(queue1.isEmpty()){
			emptyQueue = queue1;
			theOtherQueue = queue2;
		}	
		else{
			emptyQueue = queue2;
			theOtherQueue = queue1;
		}
		emptyQueue.offer(x);
		while(!theOtherQueue.isEmpty()){
			emptyQueue.offer(theOtherQueue.poll());
		}
		return;
	}

	public void pop(){
		if(queue1.isEmpty()){
			queue2.poll();
		}
		else{
			queue1.poll();
		}
	}

	public int top(){
		if(queue1.isEmpty()){
			return queue2.peek();
		}
		else{
			return queue1.peek();
		}

	}	

	public boolean empty(){
		if(queue1.isEmpty()){
			return queue2.isEmpty();
		}
		else{
			return queue1.isEmpty();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
