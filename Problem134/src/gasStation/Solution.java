package gasStation;

public class Solution {

	public int canCompleteCircuit(int[] gas, int[] cost){
		//get the start position that the car can travel with the gas
		
		if(gas == null || cost == null || gas.length==0 || cost.length==0){
			return -1;
		}
		
		int length = gas.length;
		
		int leftGas = 0;
		for(int i=0;i<length;i++){
			leftGas += gas[i] - cost[i];
		}
		if(leftGas < 0 ){
			return -1;
		}
		
		int start = 0;
		leftGas = 0;
		for(int i=0;i<length;i++){
			leftGas += gas[i]-cost[i];
			if(leftGas<0){
				start = i+1;
				leftGas = 0;
			}
		}
		
		return start;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] gas = {3,2,5,4,1};
		int[] cost = {4,4,4,1,2};
		
		Solution sol = new Solution();
		System.out.println(sol.canCompleteCircuit(gas, cost));

	}

}
