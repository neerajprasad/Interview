package com.microsoft.test;

public class PrintSpiralMatrix {

	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3, 4, 5, 6 }, 
				{ 7, 8, 9, 10, 11, 12 }, 
				{ 13, 14, 15, 16, 17, 18 } };
		int row = a.length;
		int col = a[0].length ;
		System.out.println(row +" "+col);
		printSpiralMat(a, row, col);
	}

	private static void printSpiralMat(int[][] a, int row, int col) {
		int r = 0;
		int c = 0;
		int i;
		int result[]  = new int[row*col];
		int inc=0;
		while (r < row && c < col) {
			for (i = c; i < col; i++) {
				result[inc++]=a[r][i] ;
			}
			r++;
			for (i = r; i < row; i++) {
				result[inc++]=a[i][col - 1] ;
			}
			col--;
			if (r < row) {
				for (i = col - 1; i >= c; --i) {
					result[inc++]=a[row - 1][i] ;
				}
				row--;
			}
			if (c < col) {
				for (i = row - 1; i >= r; --i) {
					result[inc++]=a[i][c] ;
				}
				c++;
			}
		}
		// if i=0 spiral order
		// if i start length -1 then reverse spiral 
		for(i=result.length-1;i>=0;i--){
		System.out.print(result[i]+" ");
		}
	}

}
