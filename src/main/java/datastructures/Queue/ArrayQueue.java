package datastructures.Queue;

import datastructures.Array.Array;

public class ArrayQueue<E> implements Queue {
    private Array array;
    public ArrayQueue(int capacity){
        array = new Array<E>(capacity);
    }

    public ArrayQueue(){
        array = new Array<E>(10);
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enQueue(Object o) {
        array.addLast((E)o);
    }

    @Override
    public E deQueue() {
        return (E)array.removeFirst();
    }

    @Override
    public E getFront() {
        return (E)array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Queue: ");
        stringBuilder.append("front [");
        for (int i = 0; i < array.getSize(); i++){
            stringBuilder.append(array.get(i));
            if (i != array.getSize()-1)
                stringBuilder.append(',');
        }
        stringBuilder.append("] tail");
        return stringBuilder.toString();
    }
}
