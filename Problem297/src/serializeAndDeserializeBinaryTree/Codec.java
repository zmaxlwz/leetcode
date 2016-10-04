package serializeAndDeserializeBinaryTree;

import java.util.*;

public class Codec {
	
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
        	TreeNode node = queue.poll();
        	if(node == null){
        		sb.append("null,");
        		continue;
        	}
        	sb.append(node.val);
        	sb.append(",");
        	queue.offer(node.left);
        	queue.offer(node.right);
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
    	String[] values = data.split(",");
    	//System.out.println(values.length);
    	
    	if(values[0].equals("null")){
    		return null;
    	}
    	TreeNode root = new TreeNode(Integer.valueOf(values[0]));
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	int index = 0;
    	while(!queue.isEmpty()){
    		TreeNode node = queue.poll();
    		index++;
    		if(values[index].equals("null")){
    			node.left = null;
    		}
    		else{
    			node.left = new TreeNode(Integer.valueOf(values[index]));
    			queue.offer(node.left);
    		}
    		index++;
    		if(values[index].equals("null")){
    			node.right = null;
    		}
    		else{
    			node.right = new TreeNode(Integer.valueOf(values[index]));
    			queue.offer(node.right);
    		}
    	}
    	
    	return root;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Codec cd = new Codec();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		
		String data = cd.serialize(root);
		System.out.println(data);
		TreeNode generatedTreeRoot = cd.deserialize(data);
		System.out.println(generatedTreeRoot.val);
		System.out.println(generatedTreeRoot.left.val);
		System.out.println(generatedTreeRoot.right.val);
		System.out.println(generatedTreeRoot.right.left.val);
		System.out.println(generatedTreeRoot.right.right.val);
	}

}

class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int v){
		val = v;
		left = null;
		right = null;
	}
}