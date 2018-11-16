package xiehang.Heap;

import xiehang.Array.Array;

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    //传入一个数组，构造成一个MaxHeap
    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i --){
            siftDown(i);
        }
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    //三个辅助函数，计算左右节点或者父节点--------------------------------
    private int parent(int index) {
        if (index == 0) throw new IllegalArgumentException("root doesn't have parentNode");
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }
    //三个辅助函数，计算左右节点或者父节点--------------------------------

    //添加一个节点
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    //添加节点之后，通过该节点的SiftUp调整堆的结构
    private void siftUp(int i) {
        while (i > 0 && data.get(parent(i)).compareTo(data.get(i)) < 0) {//i>0, 父节点小于子节点
            data.swap(i, parent(i));
            i = parent(i);
        }
    }

    //查看堆中的最大元素
    public E findMax() {
        if (data.isEmpty()) throw new IllegalArgumentException("Can not find Max, Heap is empty");
        return data.get(0);
    }


    //删除堆的节点（root）
    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    //将节点下沉，调整堆的结构
    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0)
                j = rightChild(k);//此时j是子节点中最大元素的索引

            if (data.get(k).compareTo(data.get(j)) >= 0)
                break;
            data.swap(k, j);
            k = j;
        }
    }

    //取出堆中的最大元素，并且加入新的元素E
    public E replace(E e){
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }
}
