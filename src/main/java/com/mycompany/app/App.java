package com.mycompany.app;
import java.util.Scanner;
import java.util.Random;

/**
 * Concurrency
 *
 */

public class App 

{
	
	public static void main(String[] args) {
		testArraySum();
	}
		
	
	public static void testArraySum() {

		int[] arr = new int[200];
		Random rand = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(10) + 1;
		}
		
		singleSum test = new singleSum();

		long start = System.currentTimeMillis();
		int output = test.sum(arr);
		System.out.println("Single sum time: " + (System.currentTimeMillis() - start + "ms")); // single time

		System.out.println();

		start = System.currentTimeMillis();
		int pOutput = ParallelSum.parallelArraySum(arr);
		System.out.println("Parallel sum time: " + (System.currentTimeMillis() - start) + "ms"); // parallel time

		

	}
	
	
}
