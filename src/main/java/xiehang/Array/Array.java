package xiehang.Array;

public class Array<E> {
    private E[] data;
    private int size;//数组个数

    /**
     * 构造函数，根据传入的数组长度构造数组
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];//不支持new E[],但是可以new object再强转
        size = 0;
    }

    /**
     * 无参构造器，默认长度为10
     */
    public Array() {
        this(10);
    }

    //用传入的数组构造数组
    public Array(E[] arr){
        data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++)
            data[i] = arr[i];
        size = arr.length;
    }

    //获取数组个数
    public int getSize() {
        return size;
    }

    //获取数组容量
    public int getCapacity() {
        return data.length;
    }

    //判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //向所有元素之后添加元素
    public void addLast(E e) {
        /*if (size == data.length){
            throw new IllegalArgumentException("AddLast failed,xiehang.Array.Array if is full");
        }
        data[size] = e;
        size++;*/
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed,Require index > 0 and index <= size");
        }
        if (size == data.length)
            resize(2 * data.length);
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //获取index索引的元素
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("get failed,index is illegal.");
        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    //设置index索引的值为e
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("get failed,index is illegal.");
        data[index] = e;
    }
    //判断是否有元素e

    public boolean contains(E e) {
        for (int i = 0; i < size; i++)
            if (data[i].equals(e))
                return true;
        return false;
    }
    //查找元素e索引,如果不存在，返回-1

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }
    //从data中删除指定元素，并返回该元素

    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("remove failed,index is illegal.");
        E ret = data[index];
        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];
        size--;//现在使用泛型，则数组中存放的是一个对象的引用，这样GC就不会释放data[size]的空间.loitering Object != memory leak
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return ret;
    }
    //删除数组第一个元素

    public E removeFirst() {
        return remove(0);
    }
    //删除数组最后一个元素

    public E removeLast() {
        return remove(size - 1);
    }
    //查找并删除元素

    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }
    //实现动态数组

    private void resize(int newCapacity) {
        E[] newArr = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++)
            newArr[i] = data[i];
        data = newArr;
    }

    public void swap(int i, int j){
        E temp;
        temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("xiehang.Array.Array:size= %d , capacity = %d\n", size, data.length));
        stringBuilder.append('[');
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]);
            if (i != size - 1)
                stringBuilder.append(',');
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
