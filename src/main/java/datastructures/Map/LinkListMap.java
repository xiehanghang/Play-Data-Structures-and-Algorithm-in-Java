package datastructures.Map;

public class LinkListMap<K, V> implements Map<K, V>{

    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + ":" + value.toString();
        }
    }
    private Node dummyhead;
    private int size;

    public LinkListMap(){
        dummyhead = new Node();
        size = 0;
    }

    private Node getNode(K key){
        Node curr = dummyhead.next;
        while (curr != null){
            if (curr.key.equals(key))
                return curr;
        }
        return null;
    }
    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null){
            dummyhead.next = new Node(key, value, null);
            size ++;
        }else {
            node.value = value;
        }
    }


    @Override
    public V remove(K key) {
        Node prev = dummyhead;
        while (prev.next != null){
            if (prev.next.key.equals(key))
                break;
            prev = prev.next;
        }
        if (prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node != null)
            node.value = newValue;
        else
            throw new IllegalArgumentException(key + "doesn't exist");
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
