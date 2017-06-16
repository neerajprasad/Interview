package com.microsoft.test;

public class SubRectangularMatrixWithMaximumSum {

	public static void main(String[] args) {
		int input[][] = { { 2, 1, -3, -4, 5 }, { 0, 6, 3, 4, 1 }, { 2, -2, -1, 4, -5 }, { -3, 3, 1, 0, 3 } };
		SubRectangularMatrixWithMaximumSum max = new SubRectangularMatrixWithMaximumSum();
		Result result = max.subSum(input);
		System.out.println(result);
	}

	private Result subSum(int[][] input) {
		int row = input.length;
		int col = input[0].length;
		int temp[] = new int[row];
		Result result =new Result();
		for (int left = 0; left < col; left++) {
			for (int i = 0; i < row; i++) {
				temp[i] = 0;
			}
			for(int right=left;right<col;right++){
				for(int i=0;i<row;i++){
					temp[i] +=input[i][right];
				}
				
				Kadane kadane = getKadane(temp);
				if(kadane.maxSum > result.maxSum){
					result.maxSum =kadane.maxSum;
					result.left=left;
					result.right =right;
					result.down=kadane.end;
					result.top = kadane.start;
				}
			}
		}
		return result;
	}
	Kadane getKadane(int a[]){
		int max=0;
		int maxSoFar=0;
		int maxStart=-1;
		int maxEnd=-1;
		int currentStart=0;
		
		for (int i = 0; i < a.length; i++) {
			maxSoFar +=a[i];
			
			if(maxSoFar<0){
				maxSoFar=0;
				currentStart = i+1;
			}
			if(max < maxSoFar){
				max=maxSoFar;
				maxStart=currentStart;
				maxEnd=i;
			}
		}
		return new Kadane(max, maxStart, maxEnd);
	}
}

class Result1 {
	int top;
	int down;
	int right;
	int left;
	int maxSum;

	@Override
	public String toString() {
		return "Result [topLeft=" + top + ", bottomLeft=" + down + ", topRight=" + right + ", bottomRight="
				+ left + ", maxSum=" + maxSum + "]";
	}

}

class Kadane1{
	int maxSum;
	int start;
	int end;
	public Kadane1(int maxSum, int start, int end) {
		super();
		this.maxSum = maxSum;
		this.start = start;
		this.end = end;
	}
	
	
}
