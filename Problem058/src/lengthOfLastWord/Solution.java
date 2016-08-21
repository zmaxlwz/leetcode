package lengthOfLastWord;

public class Solution {

	public int lengthOfLastWord(String s){
		//s consistes of alphabets and space " "
		//return the length of the last word

		s = s.trim();
		if(s.length() == 0)
			return 0;

		String[] words = s.split(" ");

		return words[words.length-1].length();
	}

	public int lengthOfLastWord2(String s){
		if(s==null || s.length() == 0){
			return 0;
		}
		s = s.trim();
		if(s.length() == 0){
			return 0;
		}
		String[] words = s.split(" ");
		int length = words.length;
		return words[length-1].length();
	}

	public int lengthOfLastWord3(String s){
		if(s==null || s.length() == 0){
			return 0;
		}
		s = s.trim();
		if(s.length() == 0){
			return 0;
		}
		int length = s.length();
		int count = 0;
		for(int i =length-1;i>=0;i--){
			if(s.charAt(i) != ' '){
				count++;
			}
			else{
				break;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "  Hello   boy ";
		//String s = "  boy ";
		Solution sol = new Solution();
		System.out.println(sol.lengthOfLastWord3(s));

	}

}
