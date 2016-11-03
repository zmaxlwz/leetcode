package implementQueueUsingStacks;

import java.util.*;

public class MyQueue {

	Stack<Integer> stack1, stack2;

	public MyQueue(){
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}

	public void push(int x){
		if(empty()){
			stack1.push(x);
		}
		else{
			while(!stack1.isEmpty())
				stack2.push(stack1.pop());
			stack1.push(x);
			while(!stack2.isEmpty()){
				stack1.push(stack2.pop());
			}
		}
	}

	public void pop(){
		stack1.pop();
	}

	public int peek(){
		return stack1.peek();
	}

	public boolean empty(){
		return stack1.isEmpty() && stack2.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
