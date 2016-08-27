package recoverBST;

public class Solution {

	TreeNode first = null;
	TreeNode middle = null;
	TreeNode last = null;
	TreeNode prev = null;
	
	public void recoverTree(TreeNode root){
		//two elements of a BST are swapped
		//two cases:  1) these two elements are adjacent 2) not adjacent
		//for 1) there is only 1 element that is smaller than the previous element
		//for 2) there are 2 elements that are smaller than the previous element
		//use 3 pointers: first, middle and last		
		
		searchBST(root);
		
		if(this.first != null && this.last != null){
			//2 elements are not adjacent
			int temp = this.first.val;
			this.first.val = this.last.val;
			this.last.val = temp;
		}
		else if(this.first != null){
			//2 elements are adjacent
			int temp = this.first.val;
			this.first.val = this.middle.val;
			this.middle.val = temp;
		}
		else{
			//the BST is valid, no change is needed
			
		}
		
	}
	
	private void searchBST(TreeNode root){
		//in-order traveral of the BST
		
		if(root != null){
			
			//recursively search on the left tree
			searchBST(root.left);
			
			if(this.prev != null && root.val < this.prev.val){
				//this is the element smaller than prev
				
				if(this.first == null){
					//first occurrence
					this.first = this.prev;
					this.middle = root;
				}
				else{
					this.last = root;
				}
				
			}
			
			this.prev = root;
			
			//recursively search on the right tree
			searchBST(root.right);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
