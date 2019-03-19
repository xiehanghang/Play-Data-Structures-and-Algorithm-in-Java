package datastructures.Heap;


import org.junit.Test;

import java.util.Random;

public class Main {
    @Test
    public void testMaxHeap() {
        int n = 1000;
        MaxHeap<Integer> maxHeap = new MaxHeap();
        Random random = new Random();
        for (int i = 0; i < n; i++)
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = maxHeap.extractMax();
        for (int i = 1; i < n; i++)
            if (arr[i - 1] < arr[i])
                throw new IllegalArgumentException("Errors");
        System.out.println("completed");
    }

    private static double testHeap(Integer[] testData, boolean isHeapify){
        long starTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if (isHeapify)
            maxHeap = new MaxHeap<>(testData);
        else {
            maxHeap = new MaxHeap<>();
            /*for (int i = 0; i < testData.length; i ++)
                maxHeap.add(testData[i]);*/
            for (int num : testData)
                maxHeap.add(num);
        }
        long endTime = System.nanoTime();
        return (endTime - starTime) / 1000000000.0;//秒
    }

    @Test
    public void test1(){
        int n = 1000000;
        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i ++)
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        System.out.println("Heap的用时 ：" + testHeap(testData, true));
        System.out.println("NotHeap的用时：" + testHeap(testData, false));

    }
}
