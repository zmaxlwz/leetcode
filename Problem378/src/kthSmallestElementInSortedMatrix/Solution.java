package kthSmallestElementInSortedMatrix;

import java.util.*;

public class Solution {
	
	public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
		PriorityQueue<Element> pq = new PriorityQueue<Element>(n, new ElemComparator());
		for(int j = 0;j<n;j++){
			pq.offer(new Element(matrix[0][j], 0, j));
		}
		for(int i=0;i<k-1;i++){
			Element e = pq.poll();
			int rowIndex = e.rowIndex;
			int colIndex = e.colIndex;
			if(rowIndex<n-1){
				pq.offer(new Element(matrix[rowIndex+1][colIndex], rowIndex+1, colIndex));
			}
			
		}
		
		return pq.poll().val;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Element{
	int val;
	int rowIndex;
	int colIndex;
	public Element(int v, int r, int c){
		val = v;
		rowIndex = r;
		colIndex = c;
	}
}

class ElemComparator implements Comparator<Element>{
	
	public int compare(Element e1, Element e2){
		return e1.val - e2.val;
	}
	
}