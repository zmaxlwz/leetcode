package lruCache;

import java.util.*;

public class LRUCache {

	private int size;
	private int capacity;
	private ListNode head;
	private ListNode tail;	
	private HashMap<Integer, ListNode> map;
	
	public LRUCache(int capacity){
		this.size = 0;
		this.capacity = capacity;
		ListNode node = new ListNode(0, 0);
		this.head = node;
		this.tail = node;
		this.map = new HashMap<Integer, ListNode>();
	}

	public int get(int key){
		if(this.size == 0){
			return -1;
		}
				
		ListNode p = null;
		if(this.map.containsKey(key)){
			p = this.map.get(key);
			if(p.next != null){
				p.pre.next = p.next;
				p.next.pre = p.pre;
				this.tail.next = p;
				p.pre = this.tail;
				p.next = null;
				this.tail = p;
			}
			return p.value;
		}
		else{
			return -1;
		}
		
	}

	public void set(int key, int value){
		if(this.size == 0){
			//cache is empty
			ListNode node = new ListNode(key, value);
			node.pre = this.head;
			this.head.next = node;
			this.tail = node;
			this.size++;
			map.put(key, node);
			return;
		}
		//search for key
		if(this.map.containsKey(key)){
			//the key exists
			
			ListNode p = this.map.get(key);
			p.value = value;
			if(p.next != null){
				p.pre.next = p.next;
				p.next.pre = p.pre;
				this.tail.next = p;
				p.pre = this.tail;
				p.next = null;
				this.tail = p;
			}
			
			return;
		}
		//need to insert
		if(this.size == this.capacity){
			//cache is full
			this.map.remove(this.head.next.key);
			this.head.next = this.head.next.next;
			if(this.head.next != null){
				this.head.next.pre = this.head;
			}
			
			this.size--;	
			if(this.size == 0){
				this.tail = this.head;
			}
		}
		ListNode node = new ListNode(key, value);
		this.tail.next = node;
		node.pre = this.tail;
		this.tail = node;
		this.size++;
		map.put(key, node);
		return;
	}
	
	public void print(){
		ListNode p = this.head.next;
		while(p!=null){
			System.out.print("[" + p.key + "," + p.value + "], ");
			p = p.next;
		}
		System.out.println();
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache cache = new LRUCache(1);
		cache.set(2, 1);
		cache.print();
		System.out.println(cache.get(2));
		cache.print();
		cache.set(3, 2);
		System.out.println(cache.get(2));
		//cache.set(3, 7);
		//cache.set(4, 9);
		System.out.println(cache.get(3));
		
	}

}

class ListNode{

	int key;
	int value;
	ListNode next;
	ListNode pre;
	ListNode(int key, int value){
		this.key = key;
		this.value = value;
		this.next = null;
		this.pre = null;
	}
}
