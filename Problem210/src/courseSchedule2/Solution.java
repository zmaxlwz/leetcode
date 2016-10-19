package courseSchedule2;

import java.util.*;

public class Solution {

	GraphNode[] adjList;	
	ArrayList<Integer> orderList;

	public int[] findOrder(int numCourses, int[][] prerequisites){
		orderList = new ArrayList<Integer>();
		buildGraph(numCourses, prerequisites);
		for(int i =0;i< numCourses; i++){
			if(adjList[i].color == 0){
				boolean hasCycle = DFS(adjList[i]); 
				if(hasCycle){
					orderList.clear();
					return new int[0];
				}
			}

		}
		int[] result = new int[orderList.size()];
		for(int i = 0;i < orderList.size();i++){
			result[i] = orderList.get(i);
		}
		return result;
	}

	public boolean DFS(GraphNode startNode){
		//perform DFS from startNode
		//return true if there is cycle, otherwise, return false 

		if(startNode.color == 1){
			//this node is gray
			return true;
		}
		else if(startNode.color == 2){
			//this node is black
			return false;
		}
		//this node is white, color it as gray
		startNode.color = 1;
		adjListNode list = startNode.next;
		boolean hasCycle = false;
		while(list != null){
			hasCycle = DFS(adjList[list.node]);
			if(hasCycle){
				return true;
			}
			list = list.next;
		}
		startNode.color = 2;
		orderList.add(0, startNode.node);
		return false;
	}

	public void buildGraph(int numCourses, int[][] prerequisites){
		adjList = new GraphNode[numCourses];
		for(int i =0; i< numCourses; i++){
			adjList[i] = new GraphNode(i);
		}
		int numPrereq = prerequisites.length;
		for(int i  = 0; i< numPrereq; i++){
			int fromNode = prerequisites[i][1];
			int toNode = prerequisites[i][0];
			adjListNode adjNode = new adjListNode (toNode);
			adjNode.next = adjList[fromNode].next;
			adjList[fromNode].next = adjNode;
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class GraphNode{

	int node;
	int color;
	adjListNode next;
	GraphNode(int node){
		this.node = node;
		this.color = 0;
		this.next = null;
	}
}

class adjListNode{

	int node;
	adjListNode next;
	adjListNode(int node){
		this.node = node;
		this.next = null;
	}
}
