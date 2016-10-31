
public class Solution {

	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H){

		int overlapX = getOverlap(A,C,E,G);
		int overlapY = getOverlap(B,D, F, H);
		int overlapArea = overlapX*overlapY;

		return (C-A)*(D-B) + (G-E)*(H-F) - overlapArea;

	}

	private int getOverlap(int low1, int high1, int low2, int high2){
		if(high1 <= low2 || high2 <= low1){
			return 0;
		}

		int low = Math.max(low1, low2);
		int high = Math.min(high1, high2);
		return high-low;
	}

	public int computeArea2(int A, int B, int C, int D, int E, int F, int G, int H){
		int xOverlap = oneDimOverlap(A, C, E, G);
		int yOverlap = oneDimOverlap(B, D, F, H);
		int totalArea = (C-A)*(D-B)+(G-E)*(H-F);

		if(xOverlap>0 && yOverlap>0){
			return totalArea- xOverlap* yOverlap;
		}
		else{
			return totalArea;
		}
	}

	public int oneDimOverlap(int x1, int x2, int y1, int y2){
		int a1 = Math.max(x1, y1);
		int a2 = Math.min(x2, y2);
		if(a1>=a2){
			return 0;
		}
		else{
			return a2-a1;
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution sol = new Solution();
		System.out.println(sol.computeArea2(-3, 0, 3, 4, 0, -1, 9, 2));

	}

}
