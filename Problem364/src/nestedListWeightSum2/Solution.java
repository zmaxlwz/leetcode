package nestedListWeightSum2;

import java.util.*;

public class Solution {
	
	int maxDepth = 0;
	int weightedSum = 0;
	
	public int depthSumInverse(List<NestedInteger> nestedList) {
		
		if(nestedList == null || nestedList.size() == 0){
			return 0;
		}
		
		getMaxDepth(nestedList, 1);
		
		computeWeightedSum(nestedList, this.maxDepth);
		
		return this.weightedSum;
    }
	
	private void computeWeightedSum(List<NestedInteger> nestedList, int depth){
		
		for(NestedInteger ni: nestedList){
			if(ni.isInteger()){
				this.weightedSum += ni.getInteger()*depth;
			}
			else{
				computeWeightedSum(ni.getList(), depth-1);
			}
		}
		
		return;
	}
	
	private void getMaxDepth(List<NestedInteger> nestedList, int depth){
		
		if(depth>maxDepth){
			maxDepth = depth;
		}
		
		for(NestedInteger ni: nestedList){
			if(!ni.isInteger()){
				getMaxDepth(ni.getList(), depth+1);
			}
		}
		
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

