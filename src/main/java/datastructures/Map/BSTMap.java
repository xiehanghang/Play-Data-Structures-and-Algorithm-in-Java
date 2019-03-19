package datastructures.Map;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap() {
        root = null;
        size = 0;
    }

    //向二分搜索树添加新的元素
    public void add(K key, V value) {
        if (root == null) {
            root = new Node(key, value);
            size++;
        } else {
            add(root, key, value);
        }
    }

    //向以node为根节点的二分搜索树插入节点，递归算法
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        //递归调用
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else if (key.compareTo(node.key) == 0) {
            //传来的key已存在，覆盖以存在的value
            node.value = value;
        }
        return node;
    }

    //查询相关的辅助函数,返回以node为根节点的二分搜索树，key所在的节点
    public Node getNode(Node node, K key) {
        if (node == null)
            return null;
        if (key.compareTo(node.key) == 0)
            return node;
        else if (key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else
            return getNode(node.right, key);
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    //删除指定元素e,递归算法
    //并返回删除节点后新的二分搜索树的跟
    private Node remove(Node node, K key) {
        if (node == null)//要删除的元素不存在
            return null;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {// e == node.e
            //第一种情况，待删除左节点为空
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            //第二种情况，待删除右节点为空
            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }
            //第三种情况，待删除左右节点左右不为空
            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点代替被删除的节点
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    //删除掉以node为根的二分搜索树中的最小节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    //返回以node为根的二分搜索树所在的节点
    private Node minimum(Node node){
        if (node.left == null)
            return node;
        return minimum(node.left);
    }
    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException(key + "doesn't exist");
        else
            node.value = newValue;
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
