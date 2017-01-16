package lineReflection;

import java.util.*;

public class Solution {
	
	public boolean isReflected(int[][] points) {
		
		if(points == null || points.length <= 1){
			return true;
		}
		
		int numPoints = points.length;
		HashSet<Point> set = new HashSet<Point>();
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		for(int i=0;i<numPoints;i++){
			int[] point = points[i];
			int x = point[0];
			int y = point[1];
			if(x<minX){
				minX = x;
			}
			if(x>maxX){
				maxX = x;
			}
			set.add(new Point(x,y));
		}
		
		int pivot = minX+maxX;
		for(Point p: set){
			Point q = new Point(pivot-p.x, p.y);
			if(!set.contains(q)){
				return false;
			}
		}
		
		return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		int[][] points = {{1,1}, {-1,1}};
		//int[][] points = {{1,1}, {-1,-1}};
				
		System.out.println(sol.isReflected(points));
		
		
		/*
		Point p = new Point(1,-1);
		HashSet<Point> set = new HashSet<Point>();
		set.add(p);
		Point q = new Point(1,-1);
		System.out.println(set.contains(q));
		System.out.println(p.equals(q));
		*/
		

	}

}

class Point{
	int x;
	int y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int hashCode(){
		StringBuffer sb = new StringBuffer();
		sb.append(this.x);
		sb.append(this.y);
		
		return sb.toString().hashCode();
	}
	
	@Override
	public boolean equals(Object that){
		return that != null && that instanceof Point && this.x == ((Point)that).x && this.y == ((Point)that).y;
	}
	
}