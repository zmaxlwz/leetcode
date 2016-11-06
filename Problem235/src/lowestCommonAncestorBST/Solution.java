package lowestCommonAncestorBST;

public class Solution {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
		TreeNode n1, n2;
		if(p.val < q.val){
			n1 = p;
			n2 = q;
		}
		else{
			n1 = q;
			n2 = p;
		}

		TreeNode t = root;
		while(t != null){
			if(n1.val < t.val && t.val < n2.val){
				return t;
			}
			if(n1.val == t.val || n2.val == t.val){
				return t;
			}
			if(t.val < n1.val){
				t = t.right;
			}
			else{
				t = t.left;
			}
		}
		return t;
	}

	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
		int minValue = Math.min(p.val, q.val);
		int maxValue = Math.max(p.val, q.val);
		TreeNode n = root;
		TreeNode lcaNode = null;
		while(n!=null){
			if(n.val == minValue || n.val == maxValue){
				lcaNode = n;
				break;
			}
			else if(minValue < n.val && n.val < maxValue ){
				lcaNode = n;
				break;
			}
			else if(n.val < minValue){
				n = n.right;
			}
			else{
				n = n.left;
			}
		}
		return lcaNode;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class TreeNode{

	int val;
	TreeNode left, right;
	TreeNode(int x){
		val = x;
	}
}
