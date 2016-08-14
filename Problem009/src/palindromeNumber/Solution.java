package palindromeNumber;

public class Solution {

	public boolean isPalindrome(int x){

		if(x<0){
			//negative number is not palindrome
			return false;			
		}

		//get the highest digit length
		int div = 1;
		while(x/div >= 10){
			div *= 10;
		}

		int left, right;

		//if only one digit left, it will still check 
		//and the only digit will pass the check
		while(x > 0){
			left = x/div;
			right = x%10;

			if(left != right){
				//the left digit is not equal to the right digit
				return false;
			}

			x = x%div/10;
			div = div/100;	
		}


		return true;
	}

	public boolean isPalindrome2(int x){
		if(x < 0){
			return false;
		}
		int multiple = 1;
		while(x/multiple>=10){
			multiple = multiple*10;
		}
		//System.out.println(multiple);
		while(x>0){
			int left = x/multiple;
			int right = x%10;
			//System.out.println(left);
			//System.out.println(right);
			if(left != right){
				return false;
			}
			x = x - left*multiple;
			x = x/10;
			multiple = multiple/100;
		}
		return true;

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution sol = new Solution();
		//int x = 100021;
		int x = 1410110141;
		//System.out.println(Integer.MAX_VALUE);
		System.out.println(sol.isPalindrome2(x));
	}

}
