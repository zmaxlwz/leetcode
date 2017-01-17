package rearrangeStringKDistanceApart;

import java.util.*;

public class Solution {
	
	public String rearrangeString(String str, int k) {
		
		if(str.length() == 1){
			return str;
		}
		
		if(k<=1){
			return str;
		}
		else if(k>26){
			return "";
		}
		
		int length = str.length();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		PriorityQueue<Node> pq = new PriorityQueue<Node>(length, new NodeComparator());

		for(int i=0;i<length;i++){
			char c = str.charAt(i);
			if(!map.containsKey(c)){
				map.put(c, 1);
			}
			else{
				map.put(c, map.get(c)+1);
			}
		}
		
		for(Character c: map.keySet()){
			pq.offer(new Node(c, map.get(c)));
		}
		
		if(map.size() < k && pq.peek().count > 1){
			return "";
		}
		
		StringBuffer sb = new StringBuffer();
		LinkedList<Node> queue = new LinkedList<Node>();
		
		while(!pq.isEmpty()){
			Node node = pq.poll();
			sb.append(node.c);
			node.count--;
			queue.offer(node);
			if(queue.size()>=k){
				node = queue.poll();
				if(node.count>0){
					pq.offer(node);
				}				
			}
		}
		if(sb.length() == length){
			return sb.toString();
		}
		else{
			return "";
		}
		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		//String str = "aabbcc";		
		//int k = 3;
		//String str = "aaabc";		
		//int k = 3;
		//String str = "aaadbbcc";		
		//int k = 2;
		String str = "abcde";
		int k = 3;
		//String str = "aabbcc";
		//int k = 2;
		
		
		System.out.println(sol.rearrangeString(str, k));

	}

}

class Node{
	char c;
	int count;
	Node(char c, int count){
		this.c = c;
		this.count = count;
	}
}

class NodeComparator implements Comparator<Node>{
	public int compare(Node node1, Node node2){
		return node2.count - node1.count;
	}
}