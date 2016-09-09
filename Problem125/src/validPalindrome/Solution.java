package validPalindrome;

public class Solution {

	public boolean isPalindrome(String s){
		//check if the given String is palindrome
		//only considering alphanumeric characters, ignoring cases

		if(s == null || s.length()<=1){
			return true;
		}

		s = s.toLowerCase();


		int length = s.length();

		int start = 0;
		int end = length-1;
		while(start<end){
			char c1 = s.charAt(start);
			char c2 = s.charAt(end);
			if(!((c1>='a' && c1<='z') || (c1>='0' && c1<='9'))){
				start++;
				continue;
			}
			if(!((c2>='a' && c2<='z') || (c2>='0' && c2<='9'))){
				end--;
				continue;
			}
			if(c1==c2){
				start++;
				end--;

			}
			else{

				return false;
			}
		}

		return true;
	}

	public boolean isPalindrome2(String s){
		if(s == null){
			return true;
		}
		s = s.trim();
		s = s.toLowerCase();
		int length = s.length();
		if(length <= 1){
			return true;
		}
		int left = 0, right = length-1;
		char c1, c2;
		while(left<right){
			c1 = s.charAt(left);
			c2 = s.charAt(right);
			boolean c1Valid = false;
			if((c1 >= 'a' && c1<= 'z') || (c1 >= '0' && c1<= '9')){
				c1Valid = true;
			}
			boolean c2Valid = false;
			if((c2 >= 'a' && c2<= 'z') || (c2 >= '0' && c2<= '9')){
				c2Valid = true;
			}
			if(!c1Valid){
				left++;
			}
			if(!c2Valid){
				right--;
			}
			if(c1Valid && c2Valid){
				if(c1 != c2){
					return false;
				}
				else{
					left++;
					right--;
				}
			}

		}
		return true;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "A man, a plan, a canal:  Panama ";
		//String s = " race a car  ";
		Solution sol = new Solution();
		System.out.println(sol.isPalindrome(s));

	}

}
