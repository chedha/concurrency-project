package com.mycompany.app;

public class singleSum extends Thread{
	
	public static int sum(int[] arr)
    {
    	
        return sum(arr, 0, arr.length);
    }

    public static int sum(int[] arr, int low, int high)
    {
        int total = 0;

        for (int i = low; i < high; i++) {
            total += arr[i];
        }
        
        System.out.println("Single sum total: " + total);
                
        return total;
    }

}
