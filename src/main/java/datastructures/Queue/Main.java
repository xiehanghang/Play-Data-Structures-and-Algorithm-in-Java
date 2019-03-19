package datastructures.Queue;

import datastructures.LinkedList.LinkedListQueue;

import java.util.Random;

public class Main {
    private static  double testQueue(Queue<Integer> queue, int opCount){
        long starTime = System.nanoTime();//纳秒
        Random random = new Random();
        for (int i = 0; i < opCount; i++)
            queue.enQueue(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < opCount; i++)
            queue.deQueue();
        long endTime = System.nanoTime();
        return (endTime - starTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000;
        Queue<Integer> loopQueue = new LoopQueue<>();
        Queue<Integer> arrayQueue = new ArrayQueue<>();
        Queue<Integer> linkQueue = new LinkedListQueue<>();
        System.out.println("loopQueue: " + testQueue(loopQueue, opCount));
        System.out.println("arrayQueue: " + testQueue(arrayQueue, opCount));
        System.out.println("linkQueue: " + testQueue(linkQueue,opCount));
    }
}
