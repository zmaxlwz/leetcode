package reverseWordsInString;

public class Solution {

	public String reverseWords(String s){
		//reverse words in a String
		//"  the  sky is blue " -> "blue is sky the"
		//use a stack

		s = s.trim();
		String[] words = s.split(" ");

		String result = "";
		for(int i=words.length-1;i>=0;i--){
			if(words[i].length()>0)
				result += words[i] + " ";
		}

		return result.trim();
	}

	public String reverseWords2(String s){
		if(s==null){
			return "";
		}
		s = s.trim();
		if(s.length()==0){
			return "";
		}
		String[] words = s.split(" ");
		int length = words.length;
		String sentence = words[length-1];
		for(int i=length-2;i>=0;i--){
			if(words[i].length()>0)
				sentence += " " + words[i];
		}
		return sentence;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "  the  sky is blue ";
		//String s = "  ";

		/*
		s = s.trim();
		String[] words = s.split(" ");
		System.out.println(words.length);
		for(int i=0;i<words.length;i++){
			System.out.println(words[i]);
		}
		 */

		Solution sol = new Solution();
		System.out.println(sol.reverseWords(s));

	}

}
