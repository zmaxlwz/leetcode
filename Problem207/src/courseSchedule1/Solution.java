package courseSchedule1;

public class Solution {

	GraphNode[] adjList;	

	public boolean canFinish(int numCourses, int[][] prerequisites){
		buildGraph(numCourses, prerequisites);
		for(int i =0;i< numCourses; i++){
			if(adjList[i].color == 0){
				boolean hasCycle = DFS(adjList[i]); 
				if(hasCycle){
					return false;
				}
			}

		}
		return true;
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
