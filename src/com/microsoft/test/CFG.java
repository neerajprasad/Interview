package com.microsoft.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CFG {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		List<Result> list = new ArrayList<Result>();
		for (int ii = 0; ii < t; ++ii)

		{
			int row = s.nextInt();
			int col = s.nextInt();
			int input[][] = new int[row][col];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					input[i][j] = s.nextInt();
				}
			}
			SubRectangularSum max = new SubRectangularSum();
			Result result = max.subSum(input);
			list.add(result);
		}
		list.forEach(System.out::println);
s.close();
	}
}

class SubRectangularSum {

	public Result subSum(int[][] input) {
		int row = input.length;
		int col = input[0].length;
		int temp[] = new int[row];
		Result result = new Result();
		for (int left = 0; left < col; left++) {
			for (int i = 0; i < row; i++) {
				temp[i] = 0;
			}
			for (int right = left; right < col; right++) {
				for (int i = 0; i < row; i++) {
					temp[i] += input[i][right];
				}

				Kadane kadane = getKadane(temp);
				if (kadane.maxSum > result.maxSum) {
					result.maxSum = kadane.maxSum;
					result.left = left;
					result.right = right;
					result.down = kadane.end;
					result.top = kadane.start;
				}
				
			}
		}
		return result;
	}

	Kadane getKadane(int a[]) {
		int max = 0;
		int maxSoFar = 0;
		int maxStart = -1;
		int maxEnd = -1;
		int currentStart = 0;

		for (int i = 0; i < a.length; i++) {
			maxSoFar += a[i];

			if (maxSoFar < 0) {
				maxSoFar = 0;
				currentStart = i + 1;
			}
			if (max < maxSoFar) {
				max = maxSoFar;
				maxStart = currentStart;
				maxEnd = i;
			}
		}
		return new Kadane(max, maxStart, maxEnd);
	}
}

class Result {
	int top;
	int down;
	int right;
	int left;
	int maxSum;

	@Override
	public String toString() {
		return "" + maxSum;
	}

}

class Kadane {
	int maxSum;
	int start;
	int end;

	public Kadane(int maxSum, int start, int end) {
		super();
		this.maxSum = maxSum;
		this.start = start;
		this.end = end;
	}
}
