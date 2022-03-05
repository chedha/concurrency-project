package com.mycompany.app;



import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;



/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
    	int[] arr = new int[200];
		Random rand = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(10) + 1;
		}
		

		singleSum test = new singleSum();
		
		int output = test.sum(arr);
		int pOutput = ParallelSum.parallelArraySum(arr);
		
		assertEquals(pOutput, output);
    }
}
