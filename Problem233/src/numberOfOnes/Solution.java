package numberOfOnes;

public class Solution {

	public int countDigitOne(int n){
		int totalCount = 0;
		int count = 0;
		for(int i =1;i<=n;i++){
			count = countOnes(i);
			totalCount += count;
		} 
		return totalCount;
	}	

	public int countOnes(int n){
		int count = 0;
		while(n>0){
			if(n%10 == 1){
				count++;
			}
			n = n/10;
		}
		return count;
	}

	public int countDigitOne2(int n){
		if(n<=0){
			return 0;
		}
		if(n<10){
			return 1;
		}
		long num = (long)n;
		long factor = 10;
		long totalCount = 0;
		while(num>=factor){
			long ratio = num/factor;
			totalCount += ratio*factor/10;
			if((num%factor)/(factor/10)>1){
				totalCount += factor/10;
			}
			else if((num%factor)/(factor/10) == 1){
				totalCount += (num%(factor/10))+1;
			}
			if(ratio==1){
				totalCount += (num%factor) + 1;
			}
			else if(ratio<10){
				totalCount += factor;
			}
			factor = factor * 10;
		}
		return (int)totalCount;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution sol = new Solution();
		//int n = 13;
		//int n = 10;
		//int n = 20;
		//int n = 100;
		//int n = 110;
		int n = 824883294;
		//int n = 1432;
		System.out.println(sol.countDigitOne2(n));

	}

}
