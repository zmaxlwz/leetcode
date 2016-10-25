package shortestPalindrome;

public class Solution {

	public String shortestPalindrome(String s){
		//add character to the beginning of s to make it Palindrome
		//return the shortest Palindrome

		if(s==null || s.length()==0){
			return s;
		}
		if(s.length()==1){
			return s;
		}
		if(isPalindrome(s)){
			return s;
		}
		//System.out.println("start.");
		int length = s.length();
		int middle = (length-1)/2;
		int minLength = length*2;
		int minCenter = 0;
		int type = 0;
		for(int i=middle;i>=0;i--){
			//System.out.println(i);
			if(isCenter(s, i)==1){
				//this is a single center
				int len = (length-1-i)*2+1;
				if(len < minLength){
					minLength = len;
					minCenter = i;
					type = 1;
				}
			}
			else if(isCenter(s, i) == 2){
				//there are two centers
				//this is the right one
				int len = (length-i)*2;
				
				if(len < minLength){
					minLength = len;
					minCenter = i;
					type = 2;
				}
			}
		}
		//System.out.println(minLength);
		//System.out.println(minCenter);
		//System.out.println(type);
		return construct(s, minCenter, type);
	}

	private boolean isPalindrome(String s){
		if(s==null || s.length()==0){			
			return true;
		}

		int length = s.length();
		int left = 0;
		int right = length-1;
		while(left<right){
			if(s.charAt(left) != s.charAt(right)){
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public int isCenter(String s, int index){
		//return 0 if index is not a center
		//return 1 if it is a single center
		//return 2 if it is the right of double centers

		int left = 0;
		int right = 0;
		int length = s.length();

		//test single center
		left = index-1;
		right = index+1;
		while(left>=0){
			if(s.charAt(left) != s.charAt(right)){
				break;
			}
			left--;
			right++;

		}
		if(left<0){
			return 1;
		}

		//test double center, it is the right of double center
		left = index-1;
		right = index;
		while(left>=0){
			if(s.charAt(left) != s.charAt(right)){
				break;
			}
			left--;
			right++;
		}
		if(left<0){
			return 2;
		}

		return 0;
	}

	private String construct(String s, int center, int type){
		int left = 0;
		int right = 0;
		int length = s.length();
		if(type == 1){
			left = center-1;
			right = center+1;
		}
		else if(type == 2){
			left = center-1;
			right = center;
		}
		else{
			System.out.println("bad.");
			return "";
		}
		while(left>=0){
			left--;
			right++;
		}

		String result = s;
		while(right<length){
			result = String.valueOf(s.charAt(right)) + result;
			right++;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "aacecaaa";
		//String s = "abcd";
		//String s = "abb";
		Solution sol = new Solution();
		System.out.println(sol.shortestPalindrome(s));
		//System.out.println(sol.isCenter(s, 0));

	}

}
