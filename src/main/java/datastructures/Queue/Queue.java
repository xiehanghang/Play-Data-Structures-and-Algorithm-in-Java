package datastructures.Queue;

public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enQueue(E e);
    E deQueue();
    E getFront();
}
