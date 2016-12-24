package nestedListWeightSum;

import java.util.*;

public class Solution {
	
	int weightedSum = 0;
	
	public int depthSum(List<NestedInteger> nestedList) {
		
		if(nestedList == null || nestedList.size() == 0){
			return 0;
		}
		
		computeSum(nestedList, 1);
		
		return this.weightedSum;
    }
	
	private void computeSum(List<NestedInteger> nestedList, int depth){
		
		for(NestedInteger nInteger: nestedList){
			if(nInteger.isInteger()){
				this.weightedSum += depth*nInteger.getInteger();
			}
			else{
				computeSum(nInteger.getList(), depth+1);
			}
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

interface NestedInteger {
	 
	      // @return true if this NestedInteger holds a single integer, rather than a nested list.
	      public boolean isInteger();
	 
	      // @return the single integer that this NestedInteger holds, if it holds a single integer
	      // Return null if this NestedInteger holds a nested list
	      public Integer getInteger();
	 
	      // @return the nested list that this NestedInteger holds, if it holds a nested list
	      // Return null if this NestedInteger holds a single integer
	      public List<NestedInteger> getList();
	      
}