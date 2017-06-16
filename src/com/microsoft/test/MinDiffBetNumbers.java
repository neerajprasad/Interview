package com.microsoft.test;

public class MinDiffBetNumbers {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4};
		int index=findMinDifference(a);
		System.out.println(a[index]+1);
	}

	private static int findMinDifference(int[] a) {
		int max=Integer.MAX_VALUE;
		int index=0;
		for (int i = 0; i < a.length-1; i++) {
			int diff = a[i]-a[i+1];
			if(Math.abs(diff)<=max){
				max=Math.abs(diff);
				index=i;
			}
		}
		return index;
	}

}
