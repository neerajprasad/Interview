package com.microsoft.test;

import java.util.Arrays;
/*
 *  arr[]  = {1, 2, 10, 5, 5}
    dep[]  = {4, 5, 12, 9, 12}

Below are all events sorted by time.  Note that in sorting, if two
events have same time, then arrival is preferred over exit.
 Time     Event Type         Total Number of Guests Present
------------------------------------------------------------
   1        Arrival                  1
   2        Arrival                  2
   4        Exit                     1
   5        Arrival                  2
   5        Arrival                  3    // Max Guests
   5        Exit                     2
   9        Exit                     1
   10       Arrival                  2 
   12       Exit                     1
   12       Exit                     0 

*/

public class FindMaxGuests {

	public static void main(String[] args) {
		int[] entry = {1, 2, 10, 5, 5};
		int[] exit = {4, 5, 12, 9, 12};
		int length = entry.length;
		
		findMaxGuest(entry,exit,length);
	}

	private static void findMaxGuest(int[] entry, int[] exit, int length) {
		int maxGuest=1;
		int maxIn=1;
		int time=entry[0];
		Arrays.sort(entry);
		Arrays.sort(exit);
		
		int i=1;
		int j=0;
		while(i< length && j< length){
			if(entry[i]<=exit[j]){
				maxIn++;
				
				if(maxGuest < maxIn){
					maxGuest = maxIn;
					time = entry[i];
				}
				i++;
			}
			else{
				maxIn--;
				j++;
			}
		}
		System.out.println("Max guest :"+maxGuest +" at :" +time);
	}

}
