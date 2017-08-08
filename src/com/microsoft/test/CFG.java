package com.microsoft.test;

import java.util.Arrays;
import java.util.Scanner;

class GFG {

	public static void main(String[] args) {
		boolean flag=false;
		int arr[] = {1,5,6,0,0,6,0,12,8,0,8,8};
		for (int a = 0; a < arr.length-1; a++) {
			int c=a+1;
			while(arr[c]==0) {
				c++;
			}
			if(arr[a]==arr[c]) {
				arr[a] = arr[a]*2;
				arr[c]=0;
				if(c+1 < arr.length && arr[c+1]==0) {
					c++;
				}
			}
		
			int move=c;
			while( arr[a+1]==0 && a<move && c+1<arr.length) {
				arr[a+1]=arr[c+1];
				arr[c+1]=0;
				a++;
				c++;
				flag=true;
			}
			if(flag) {
				a -=1;
				flag=false;
			}
			if(c==arr.length-1) {
				break;
			}
		}
		for(int a:arr) {
			System.out.print(a +" ");
		}
	}

}