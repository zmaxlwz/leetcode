package cloneGraph;

import java.util.*;

public class Solution {

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
		if(node == null){
			return null;
		}
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		return dfs(node, map);
	}

	public UndirectedGraphNode dfs(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map){
		if(map.containsKey(node)){
			return map.get(node);
		}

		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		map.put(node, newNode);
		
		for(UndirectedGraphNode neighbor: node.neighbors){
			UndirectedGraphNode newNeighbor = dfs(neighbor, map);
			newNode.neighbors.add(newNeighbor);
		}
		
		return newNode;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class UndirectedGraphNode{
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x){
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}

