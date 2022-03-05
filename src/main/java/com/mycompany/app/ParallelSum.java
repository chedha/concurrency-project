package com.mycompany.app;

public class ParallelSum extends Thread{
	
	private int[] arr;

    private int low, high, partial;
    
    public ParallelSum(int[] arr, int low, int high)
    {
        this.arr = arr;
        this.low = low;
        this.high = Math.min(high, arr.length);
    }
    
    public void run()
    {
        partial = sum(arr, low, high);
    }
    
    public int getPartialSum()
    {
        return partial;
    }

        
    public static int sum(int[] arr, int low, int high)
    {
        int total = 0;

        for (int i = low; i < high; i++) {
            total += arr[i];
        }
                
        return total;
    }
    
    public static int parallelArraySum(int[] arr)
    {
        return parallelArraySum(arr, Runtime.getRuntime().availableProcessors());
    }

    public static int parallelArraySum(int[] arr, int threads)
    {
        int size = (int)Math.ceil(arr.length * 1.0 / threads);

        ParallelSum[] sums = new ParallelSum[threads];

        for (int i = 0; i < threads; i++) {
            sums[i] = new ParallelSum(arr, i * size, (i + 1) * size);
            sums[i].start();
        }

        try {
            for (ParallelSum sum : sums) {
                sum.join();
            }
        } catch (InterruptedException e) { }

        int total = 0;

        for (ParallelSum sum : sums) {
            total += sum.getPartialSum();
        }
        
        System.out.println("Parallel sum total is: " + total);
        
        return total;
        
        
    }

}
