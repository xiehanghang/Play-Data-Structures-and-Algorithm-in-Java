package xiehang.LinkedList;

import xiehang.Queue.Queue;

public class LinkedListQueue<E> implements Queue<E> {
    private class Node {
        public E e;
        public LinkedListQueue.Node next;

        public Node(E e, LinkedListQueue.Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head,tail;
    private int size;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enQueue(E e) {
        if (tail == null){
            tail = new Node(e);
            head = tail;
        }
        else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E deQueue() {
        if (isEmpty())
            throw new IllegalArgumentException("Stack is empty");
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null)
            tail = null;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Stack is empty");
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedListQueue front[ ");
        Node curr = head;
        while (curr != null){
            sb.append(curr + "->");
            curr = curr.next;
        }
        sb.append("NULL ]tail");
        return sb.toString();
    }
}
