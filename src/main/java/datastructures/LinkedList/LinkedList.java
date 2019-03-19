package datastructures.LinkedList;

public class LinkedList<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
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

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //向链表index位置之前添加一个元素
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed, index is illegal");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//          Node node = new Node(e);第一二句的顺序不能颠倒
//          node.next = prev.next;
//          prev.next = node;用下面一句话表示
        prev.next = new Node(e, prev.next);
        size++;
    }

    //在链表头添加新元素
    public void addFirst(E e) {
        Node node = new Node(e);
        /*node.next = head;
        head = node;*/

        add(0,e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    //获取链表索引为index的节点的值
    public E get(int index){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get Failed, index is illegal");
        Node curr = dummyHead.next;
        for (int i = 0; i < index; i++){
            curr = curr.next;
        }
        return curr.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(E e){
        return get(size -1 );
    }

    //修改链表中索引为index的元素的值
    public void set(int index, E e){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("set failed, index is illegal");
        Node curr = dummyHead.next;
        for (int i = 0; i < index; i++){
            curr = curr.next;
        }
        curr.e = e;
    }

    //查询链表中是否包含给定的元素
    public boolean contains(E e){
        Node curr = dummyHead;
        while (curr.next != null){
            curr = curr.next;
            if (curr.e.equals(e))
                return true;
        }
        return false;
    }

    //在链表中删除索引为index的元素，并返回
    public E remove(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed, index is illegal.");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++){
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;
        return retNode.e;
    }

    //删除对头元素
    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node curr = dummyHead.next;
        while (curr != null){
            sb.append(curr + "->");
            curr = curr.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
