package com.microsoft.test;

import java.util.LinkedList;

public class SumSubArrayKSize {

	public static void main(String[] args) {

		SumSubArrayKSize window = new SumSubArrayKSize();
		int a[] = { 4, 2, 5, -3, -7, 9 };
		int res = window.maxSlidingWindow(a, 3);
		// for (int i = 0; i < res.length; i++) {
		System.out.println(res);
		// }
	}

	public int maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return 0;

		int maxSum = 0;
		// contain index of array nums.
		LinkedList<Integer> deque = new LinkedList<Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			if (!deque.isEmpty() && deque.peekFirst() == i - k) {
				int sumSoFar = deque.stream().map(a -> nums[a]).reduce(0, (a, b) -> a + b);
				if (maxSum < sumSoFar) {
					maxSum = sumSoFar;
				}
				deque.poll();
			}

			deque.offer(i);

			if (i < k) {
				maxSum += nums[i];
			}
		}

		return maxSum;
	}
}
