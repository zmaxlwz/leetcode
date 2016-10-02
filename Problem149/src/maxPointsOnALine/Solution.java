package maxPointsOnALine;

import java.util.*;

public class Solution {

	public int maxPoints(Point[] points){
		//return the max number of points lying on a line
		
		if(points == null || points.length == 0){
			return 0;
		}
		
		if(points.length == 1){
			return 1;
		}
		
		//for each point, check the other points and slope
		int maxOverall = 0;
		int maxSinglePoint = 0;
		
		int pointNum = points.length;
		int samePointNum = 0;
		for(int i=0;i<pointNum;i++){
			//check each point
			Point point = points[i];
			HashMap<Double, Integer> map = new HashMap<Double, Integer>();
			maxSinglePoint = 0;
			samePointNum = 0;
			for(int j=0;j<pointNum;j++){
				
					Point other = points[j];
					double slope = 0;
					if(point.x == other.x && point.y != other.y){
						slope = Double.POSITIVE_INFINITY;						
					}
					else if(point.x == other.x){
						samePointNum++;
						continue;
					}					
					else{
						slope = ((double)point.y - (double)other.y)/(point.x - other.x);
					}
					
					if(!map.containsKey(slope)){
						if(maxSinglePoint < 1){
							maxSinglePoint = 1;
						}
						map.put(slope, 1);
					}
					else{
						int times = map.get(slope)+1;
						if(maxSinglePoint < times){
							maxSinglePoint = times;
						}
						map.put(slope, times);
					}
				
				
			}
			maxSinglePoint = maxSinglePoint + samePointNum;
			if(maxSinglePoint > maxOverall){
				maxOverall = maxSinglePoint;
			}
			
		}
			
		return maxOverall;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Point[] points = {new Point(0,0), new Point(0,0)};
		Solution sol = new Solution();
		System.out.println(sol.maxPoints(points));

	}

}
