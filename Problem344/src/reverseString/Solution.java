package reverseString;

public class Solution {
	
	public String reverseString(String s) {
		if(s == null || s.length() <= 1){
			return s;
		}
		char[] array = s.toCharArray();
		int length = s.length();
		int left = 0, right = length-1;
		while(left<right){
			char temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			left++;
			right--;
		}
		
		return new String(array);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		String s = "hello";
		System.out.println(sol.reverseString(s));

	}

}
