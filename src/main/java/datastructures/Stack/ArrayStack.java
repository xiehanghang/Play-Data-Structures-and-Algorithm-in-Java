package datastructures.Stack;


import datastructures.Array.Array;

public class ArrayStack<E> implements Stack{
    Array<E> array;

    public ArrayStack(int capacity){
        array = new Array<E>(capacity);
    }

    public ArrayStack(){
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

    //压进一个元素**********************************这里
    @Override
    public void push(Object o) {
        array.addLast((E)o);
    }

    //从栈顶删除一个元素
    @Override
    public E pop() {
        return array.removeLast();
    }

    //查看栈顶元素
    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < array.getSize(); i++){
            stringBuilder.append(array.get(i));
            if (array.getSize() != i+1)
                stringBuilder.append(", ");
        }
        stringBuilder.append("] top");
        return stringBuilder.toString();
    }
}
