package compareVersionNumber;

public class Solution {

	public int compareVersion(String version1, String version2){
		//compare version1 and version2
		//if version1 < version2, return -1
		//if version1 > version2, return 1
		//otherwise, return 0

		String[] numbers1 = version1.split("\\.");
		String[] numbers2 = version2.split("\\.");		
		int minLength = Math.min(numbers1.length, numbers2.length);
		
		for(int i=0;i<minLength;i++){
			if(numbers1[i].length() == 0 && numbers2[i].length()>0){
				return -1;
			}
			else if(numbers1[i].length() > 0 && numbers2[i].length()==0){
				return 1;
			}
			else if(numbers1[i].length() == 0 && numbers2[i].length() == 0){
				continue;
			}
			else{
				int num1 = Integer.valueOf(numbers1[i]);
				int num2 = Integer.valueOf(numbers2[i]);
				//System.out.println(num1);
				//System.out.println(num2);
				if(num1 < num2){
					return -1;
				}
				else if(num1 > num2){
					return 1;
				}
			}
		}
		
		if(numbers1.length>minLength){
			
			for(int i=minLength;i<numbers1.length;i++){
				if(Integer.valueOf(numbers1[i])>0){
					return 1;
				}
			}
			return 0;
			
		}
		else if(numbers2.length > minLength){
			
			for(int i=minLength;i<numbers2.length;i++){
				if(Integer.valueOf(numbers2[i])>0){
					return -1;
				}
				
			}
			return 0;
			
		}
		else{
			return 0;
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String version1 = "1.3";
		String version2 = "1.1";
		Solution sol = new Solution();
		System.out.println(sol.compareVersion(version1, version2));

	}

}
