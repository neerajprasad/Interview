package com.microsoft.test;

import java.util.LinkedList;
/*

*/
public class MaxSlideWindow {

	public static void main(String[] args) {

		MaxSlideWindow window = new MaxSlideWindow();
		int a[] = { 4, 2, 5, 3, 7, 9 };
		int res[] = window.maxSlidingWindow(a, 3);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return new int[0];

		int[] result = new int[nums.length - k + 1];
		LinkedList<Integer> deque = new LinkedList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			/*
			 * check deque is empty or not and get the first element and check it with size k
			 * if k=2 and deque contain 1,2 and for third element 3-2=1 and peekFirst() will have 1 .
			 * so delete the first element and add 3 to it.
			*/
			if (!deque.isEmpty() && deque.peekFirst() == i - k) {
				deque.poll();
			}
			/*
			 * check the element contain  in deque is smaller then new element then remove from last till the 
			 * condition satisfied
			*/
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.removeLast();
			}
			// add it to last in deque
			deque.offer(i);
			/*
			 * a.length = 5
			 * k=2
			 * result size 5-2+1 = 4
			 * till k size will have largest element and with every i ++ will as 
			 * deque will contain the largest element index
			*/
			if (i + 1 >= k) {
				result[i + 1 - k] = nums[deque.peek()];
			}
		}

		return result;
	}
}
