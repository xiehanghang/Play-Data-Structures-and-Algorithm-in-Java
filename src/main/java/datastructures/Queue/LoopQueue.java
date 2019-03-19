package datastructures.Queue;

public class LoopQueue<E> implements Queue<E>{
    private E[] data;
    private int front,tail;
    private int size;

    public LoopQueue(int capacity){
        data = (E[])new Object[capacity+1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length-1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enQueue(E e) {
        if ((tail + 1) % data.length == front)//通过这种操作可以让索引循环起来，结果就是tail指向下一个索引
            resize(getCapacity() * 2);
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E deQueue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequque from an empty queue");
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity()/4 && getCapacity()/2 != 0)
            resize(getCapacity()/2);
        return ret;
    }

    private void resize(int capacity){
        E[] newData = (E[])new Object[capacity + 1];
        for (int i = 0; i < size; i++)
            newData[i] = data[(i + front) % data.length];
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequque from an empty queue");
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("LoopQueue: size= %d , capacity = %d\n",size,getCapacity()));
        stringBuilder.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length){
            stringBuilder.append(data[i]);
            if ((i + 1) % data.length != tail)
                stringBuilder.append(", ");
        }
        stringBuilder.append("] tail");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            queue.enQueue(i * 10);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.deQueue();
                System.out.println(queue);
            }
        }
    }
}
