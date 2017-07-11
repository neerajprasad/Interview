package com.microsoft.test;

public class MagnificientMountain {
	public static void main(String[] args) {
		int[] arr = {2,4,6,8};
		int lcd = magMountaion(arr);
		System.out.println(lcd);
	}

	private static int magMountaion(int[] arr) {
		int ans=0;
		ans = arr[0];
		for (int i=1; i<arr.length; i++)
	        ans = ( ((arr[i]*ans)) /
	                (gcd(arr[i], ans)) );
	 
		return ans;
	}
	static int gcd(int a, int b)
	{
	    if (b==0)
	        return a;
	    return gcd(b, a%b);
	}
	 
}
