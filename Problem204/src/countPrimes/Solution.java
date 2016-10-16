package countPrimes;

public class Solution {

	public int countPrimes2(int n){
		boolean[] isPrime = new boolean[n];
		for(int i = 2 ; i<n;i++ ){
			isPrime[i] = true;
		}		
		//mark off multiples
		for(int i = 2;i*i<n; i++ ){
			if(!isPrime[i]){
				continue;
			}
			for(int j=i*i; j<n; j += i){
				isPrime[j] = false;
			}
		}
		int count = 0;
		for(int i =0;i<n;i++){
			if(isPrime[i]){
				count++;
			}
		}
		return count;
	}


	public int countPrimes(int n){
		int count = 0;
		for(int i = 1;i<n;i++ ){
			if(isPrime(i)){
				count++;
			}
		}
		return count;
	}

	public boolean isPrime(int n){
		//check if n is prime
		if(n<=1){
			return false;
		}
		for(int i = 2; i*i<=n; i++ ){
			if(n % i == 0){
				return false;
			}
		}
		return true;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();

		System.out.println(sol.countPrimes2(1000));

	}

}
