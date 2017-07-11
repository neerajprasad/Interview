package com.microsoft.test;

import java.util.Arrays;

/*
 * arr = 2,7,5,6,7,4,3,8,0,5,4,3,6
 * n=5
 * print all number less than N in left and greater in right and number itself in middle
*/
public class ArrangeNum {

	public static void main(String[] args) {
		int[] arr = { 2, 7, 5, 6, 10, 4, 3, 8, 5, 10, 4, 13, 16 };
		int N = 5;
//		 firstSolution(arr,N);
		 int[] res=secondSolution(arr,N);
		System.out.println(" final  " + Arrays.toString(res));
	}

	private static int[] secondSolution(int[] arr, int n) {
		Arrays.sort(arr);
		return arr;

	}

	private static void firstSolution(int[] arr, int n) {
		for (int a : arr) {
			if (a < n)
				System.out.print(a + " ");
		}
		for (int a : arr) {
			if (a == n)
				System.out.print(a + " ");
		}
		for (int a : arr) {
			if (a > n)
				System.out.print(a + " ");
		}
	}

}
