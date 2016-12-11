package numberOfConnectedComponentsUndirectedGraph;

import java.util.*;

public class Solution {
	
	public int countComponents(int n, int[][] edges) {
		
		if(n==0){
			return 0;
		}
		else if(n==1){
			return 1;
		}
		
		if(edges == null || edges.length == 0){
			return n;
		}
		
		GraphNode[] graph = new GraphNode[n];
		buildGraph(graph, n, edges);
		
		int numComponents = 0;
		for(int i=0;i<n;i++){
			if(!graph[i].visited){
				numComponents++;
				dfs(graph, i);
			}
		}
		
		return numComponents;
    }
	
	private void dfs(GraphNode[] graph, int k){
		
		if(graph[k].visited){
			return;
		}
		
		graph[k].visited = true;
		for(Integer neighbor: graph[k].neighbors){
			dfs(graph, neighbor);
		}
		
		return;
	}
	
	private void buildGraph(GraphNode[] graph, int n, int[][] edges){
		
		for(int i=0;i<n;i++){
			graph[i] = new GraphNode();
		}
		
		for(int i=0;i<edges.length;i++){
			int node1 = edges[i][0];
			int node2 = edges[i][1];
			graph[node1].neighbors.add(node2);
			graph[node2].neighbors.add(node1);
		}
		
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		//int n = 5;
		//int[][] edges = {{0,1}, {1,2}, {3,4}};
		int n = 5;
		int[][] edges = {{0,1}, {1,2}, {2,3}, {3,4}};
		
		System.out.println(sol.countComponents(n, edges));

	}

}

class GraphNode{
	boolean visited;
	List<Integer> neighbors;
	GraphNode(){
		visited = false;
		neighbors = new ArrayList<Integer>();
	}
}