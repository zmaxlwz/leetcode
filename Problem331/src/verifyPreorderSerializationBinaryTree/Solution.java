package verifyPreorderSerializationBinaryTree;

import java.util.*;

public class Solution {
	
	public boolean isValidSerialization(String preorder) {
		if(preorder == null || preorder.length() == 0){
			return false;
		}
		String[] nodes = preorder.split(",");
		int length = nodes.length;
		if(length == 1){
			if(nodes[0].equals("#")){
				return true;
			}
			else{
				return false;
			}
		}
		
		LinkedList<Node> stack = new LinkedList<Node>();
		for(int i=0;i<length;i++){
			if(stack.isEmpty() && i>0){
				return false;
			}
			if(!nodes[i].equals("#")){
				stack.push(new Node());
			}
			else{
				//if(stack.isEmpty()){
				//	return false;
				//}
				while(stack.peek()!=null){
					Node node = stack.peek();
					if(!node.leftFinished){
						node.leftFinished = true;
						break;
					}
					else if(!node.rightFinished){
						stack.poll();
					}
				}
				
			}
		}
		
		return stack.isEmpty();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		//String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		//String preorder = "1,#";
		//String preorder = "9,#,#,1";
		String preorder = "9,3,4,#,#,1,#,#,#,2,#,6,#,#";
		System.out.println(sol.isValidSerialization(preorder));

	}

}

class Node{
	boolean leftFinished;
	boolean rightFinished;
	Node(){
		leftFinished = false;
		rightFinished = false;
	}
}
