package substringMatching;

public class Solution {

	public int strStr(String haystack, String needle){
		//use KMP algorithm
		
		return 0;
	}
	
	public int naive_strStr(String haystack, String needle){
		//this naive method is accepted
		
		if(haystack == null || needle==null)
			return -1;
		
		int haystack_len = haystack.length();
		int needle_len = needle.length();
		
		if(needle_len==0)
			return 0;
		
		if(haystack_len < needle_len)
			return -1;
		
		for(int i=0; i <= haystack_len-needle_len; i++){
			if(haystack.substring(i, i+needle_len).equals(needle))
				return i;
		}
		
		return -1;
	}
	
	public int strStr2(String haystack, String needle){
		return haystack.indexOf(needle);
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String haystack = "abcdecd";
		String needle = "cd";
		
		Solution sol = new Solution();
		//int index = sol.naive_strStr(haystack, needle);
		int index = sol.strStr2(haystack, needle);
		System.out.println(index);
	}

}
