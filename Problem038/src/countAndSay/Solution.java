package countAndSay;

public class Solution {

	public String countAndSay(int n){

		String s = "1";
		for(int i=1;i<n;i++){
			s = nextSequence(s);
		}

		return s;
	}

	public String nextSequence(String s){
		int len = s.length();

		String nextSequence = "";
		char c, pre = s.charAt(0);
		int count = 1;

		for(int i=1;i<len;i++){
			c = s.charAt(i);
			if(c==pre){
				count++;
			}
			else{
				nextSequence += String.valueOf(count);
				nextSequence += pre;
				count=1;
				pre = c;
			}

		}
		nextSequence += String.valueOf(count);
		nextSequence += pre;

		return nextSequence;
	}

	public String countAndSay2(int n){
		if(n<=0){
			return "";
		}
		String s = "1";
		for(int i =1;i<n;i++){
			s = getNext(s);
		}
		return s;
	}
	public String getNext(String s){
		int length = s.length();
		StringBuffer sb = new StringBuffer();
		char lastChar = s.charAt(0);
		int count = 1;
		for(int i =1;i<length;i++){
			char c = s.charAt(i);
			if(c == lastChar){
				count++;
			}
			else{
				sb.append(count);
				sb.append(lastChar);				
				lastChar = c;
				count = 1;
			}
		}
		sb.append(count);
		sb.append(lastChar);		
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String s = "111221";

		Solution sol = new Solution();
		//System.out.println(sol.nextSequence(s));

		int n = 5;
		System.out.println(sol.countAndSay2(n));

	}

}
