package datastructures.LinkedList;

import org.junit.Test;
import datastructures.Queue.Queue;
import datastructures.Stack.ArrayStack;
import datastructures.Stack.Stack;

import java.util.Random;

public class Main {
    private static  double testStack(Stack<Integer> stack, int opCount){
        long starTime = System.nanoTime();//纳秒
        Random random = new Random();
        for (int i = 0; i < opCount; i++)
            stack.push(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < opCount; i++)
            stack.pop();
        long endTime = System.nanoTime();
        return (endTime - starTime) / 1000000000.0;
    }
    @Test
    public void testLinkedList(){
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (int i = 0; i < 5; i++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2,22);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);
    }

    @Test
    public void testLinkedListStack(){
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i <= 5; i++){
            stack.push(i*10);
        }
        System.out.println(stack.toString());

        int i = stack.pop();
        System.out.println(i);
    }

    @Test
    public void compareStack(){
        int opCount = 1000;
        Stack<Integer> linkStack = new LinkedListStack<>();
        Stack<Integer> stack = new ArrayStack();
        System.out.println("linkStack " + testStack(linkStack,opCount));
        System.out.println("Stack " + testStack(stack,opCount));
    }

    @Test
    public void testLinkedListQueue(){
        Queue<Integer> linkQueue = new LinkedListQueue<>();
        for (int i = 0; i < 5; i++){
            linkQueue.enQueue(i);
            System.out.println(linkQueue);
        }

        linkQueue.deQueue();
        System.out.println(linkQueue);

        linkQueue.enQueue(100);
        System.out.println(linkQueue);

    }

}
