package com.microsoft.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Helper {

	static List<int[]> getValue(){
		List<int[]> arrList = new ArrayList<>();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int totalInputSize=sc.nextInt();
		for(int i=0;i<totalInputSize;i++){
			int inputSize = sc.nextInt();
			int a[]=new int[inputSize];
			for(int j=0;j<inputSize;j++){
				a[j]=sc.nextInt();
			}
			arrList.add(a);
		}
		return arrList;
	}
}
