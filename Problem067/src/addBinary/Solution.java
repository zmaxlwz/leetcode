package addBinary;

public class Solution {

	public String addBinary(String a, String b){
		//add two binary number, return the sum as a String

		if(a == null || a.length()==0){
			return b;
		}
		if(b == null || b.length()==0){
			return a;
		}

		int indexA = a.length()-1;
		int indexB = b.length()-1;
		int flag = 0;
		int va = 0;
		int vb = 0;
		int sum = 0;
		String result = "";

		while(indexA>=0 || indexB>=0){
			va = 0;
			vb = 0;

			if(indexA>=0){
				va = a.charAt(indexA)=='0'? 0:1;
				indexA--;
			}
			if(indexB>=0){
				vb = b.charAt(indexB)=='0'? 0:1;
				indexB--;
			} 

			sum = va + vb + flag;

			if(sum>=2){
				flag = 1;
				result = String.valueOf(sum-2) + result;
			}
			else{
				flag = 0;
				result = String.valueOf(sum) + result;
			}

		}

		if(flag>0){
			result = String.valueOf(flag) + result;
		}

		return result;
	}

	public String addBinary2(String a, String b){
		if(a == null || a.length() == 0){
			return b;
		}
		if(b == null || b.length() == 0){
			return a;
		}
		int lengthA = a.length();
		int lengthB = b.length();
		int carry = 0;
		int indexA = lengthA-1;
		int indexB = lengthB-1;
		int va, vb, sum;
		StringBuffer sb = new StringBuffer();
		while(indexA>=0 || indexB>=0 || carry>0){
			va = 0;
			vb = 0;
			if(indexA>=0){
				va = a.charAt(indexA)-'0';
				indexA--;
			}
			if(indexB>=0){
				vb = b.charAt(indexB)-'0';
				indexB--;
			}
			sum = va + vb + carry;
			if(sum>=2){
				carry = 1;
				sb.insert(0, sum-2);
			}
			else{
				carry = 0;
				sb.insert(0, sum);
			}
		}
		return sb.toString();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a = "11";
		String b = "1";

		Solution sol = new Solution();
		System.out.println(sol.addBinary2(a, b));

	}

}
