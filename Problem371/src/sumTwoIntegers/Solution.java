package sumTwoIntegers;

public class Solution {
	
	public int getSum(int a, int b) {
        int base = 0;
        int increment = 0;
        if(a<b){
        	base = b;
        	increment = a;
        }
        else{
        	base = a;
        	increment = b;
        }
        
        if(increment>0){
        	for(int i=0;i<increment;i++){
            	base++;
            }
    		
        }
        else if(increment<0){
        	for(int i=0;i>increment;i--){
        		base--;
        	}
        }
        
		return base;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
