package waterAndJugProblem;

public class Solution {
	
	public boolean canMeasureWater(int x, int y, int z) {
		if(z>x+y){
			return false;
		}
		
		if(z == x || z == y || z == x+y){
		    return true;
		}
		
		int gcd = getGCD(x,y);
				
		return z%gcd == 0;
    }
	
	private int getGCD(int x, int y){
		while(y!=0){
			int temp = y;
			y = x%y;
			x = temp;
		}
		return x;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
