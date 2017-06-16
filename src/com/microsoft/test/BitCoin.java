package com.microsoft.test;

import java.util.ArrayList;
import java.util.List;
/*//
//first ascending order and from one point it descending
 * 
 * get lis -list increasing sequence
 * lds - list decreasing sequence
 * with same index add the value and get the max
 * 
*/
public class BitCoin {

	static int count = 0;
	static boolean incre = true;

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		List<int[]> arrList = Helper.getValue();

		arrList.forEach(a -> {

			int val = findBitCoinLength(a, a.length);
			list.add(val);
		});

		list.forEach(System.out::println);
	}

	private static int findBitCoinLength(int[] a, int n) {

		Integer lis[] = new Integer[a.length];
		Integer lds[] = new Integer[a.length];

		for (int i = 0; i < n; i++) {
			lis[i] = 1;
			lds[i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}

		}
		for (int i = n - 2; i >= 0; i--) {
			for (int j = n - 1; j > i; j--) {
				if (a[i] > a[j] && lds[i] < lds[j] + 1) {
					lds[i] = lds[j] + 1;
				}
			}

		}
		int max = lis[0] + lds[0] - 1;
		for (int i = 1; i < n; i++)
			if (lis[i] + lds[i] - 1 > max)
				max = lis[i] + lds[i] - 1;

		return max;
	}

}
