package com.microsoft.test;

import java.util.Arrays;
import java.util.List;
/*
print negative first ans then positive numnber.
1. iterate array and print negative first
2.Iterate again and print positive number
*/
public class ArrangementNumber {
	public static void main(String[] args) {
		ArrangementNumber arr = new ArrangementNumber();
		List<int[]> arrList = Helper.getValue();

		arrList.forEach(a -> {
			int ar[] = arr.arrangeNumber(a, a.length);
			System.out.println(Arrays.toString(ar) );
		});

	}

	private int[] arrangeNumber(int[] a, int length) {
		int j = 0;
		int temp;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < 0) {
				temp = a[i];
				a[i] = a[j];
				a[j++] = temp;

			}
		}
		return a;
	}
}
