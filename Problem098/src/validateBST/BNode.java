package validateBST;

public class BNode {
	
	TreeNode treenode;
	double leftRange;
	double rightRange;
	
	public BNode(TreeNode tn, double left, double right){
		treenode = tn;
		leftRange = left;
		rightRange = right;
	}

}
