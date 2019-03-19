package datastructures.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * BinarySearchTree
 */
public class BST<E extends Comparable> {
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    //向二分搜索树添加新的元素
    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    //向以node为根节点的二分搜索树插入节点，递归算法
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        //递归调用
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    //查找搜索树中是否存在元素e
    public boolean contains(E e) {
        return contains(root, e);

    }

    //看以node为根节点的二分搜索树是否存在元素e
    private boolean contains(Node node, E e) {
        //首先处理最基本的情况
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    //二分搜索树的前序遍历
    public void preOrder() {
        preOrder(root);
    }

    //二分搜索树前序遍历的递归算法
    private void preOrder(Node node) {
        if (node == null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //二分搜索树的中序遍历
    public void inOrder() {
        inOrder(root);
    }

    //中序遍历递归算法
    private void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //中序遍历非递归算法
    private void inOrderNR(Node node) {
        Stack<Node> stack = new Stack<>();
        if (node != null)
            stack.push(node);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.println(curr.e);
            if (curr.right != null)
                stack.push(curr.right);
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
    }

    //后序遍历
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    //层序遍历
    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.remove();
            System.out.println(curr.e);
            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
    }

    //寻找二分搜索树的最小元素
    public E minimum() {
        if (size == 0)
            throw new IllegalArgumentException("Tree is empty");
        return minimum(root).e;
    }

    //寻找二分搜索树的最小元素,递归算法
    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    //寻找二分搜索树的最大元素
    public E maximum() {
        if (size == 0)
            throw new IllegalArgumentException("Tree is empty");
        return maximum(root).e;
    }

    //寻找二分搜索树的最大元素,递归算法
    private Node maximum(Node node) {
        if (node.left == null)
            return node;
        return maximum(node.left);
    }

    //删除二分搜索树的最小元素,并返回
    public E removeMin() {
        E curr = minimum();
        root = removeMin(root);
        return curr;
    }

    //删除掉以node为根节点的二分搜索树中的最小节点
    //并返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {
        //递归最基本的情况
        if (node.left == null) {//遍历到了树中最左边的节点，也就是该树中最小的节点
            Node rightNode = node.right;//把要删除的节点的右子树根节点保存好
            node.right = null;//需要先记录右子树在删除节点，否则先删除节点则丢失了右子树根节点
            size--;
            return rightNode;//把右子树返回到上一层以供连接使用
        }

        node.left = removeMin(node.left);//连接记录好的右子树的根地址，重组为父节点的左子树
        return node;//
    }

    //删除二分搜索树的最大元素,并返回
    public E removeMax() {
        E curr = maximum();
        root = removeMax(root);
        return curr;
    }

    //删除掉以node为根节点的二分搜索树中的最小节点
    //并返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node) {
        //递归最基本的情况
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    //删除指定元素e
    public void remove(E e) {
        root = remove(root, e);
    }

    //删除指定元素e,递归算法
    //并返回删除节点后新的二分搜索树的跟
    public Node remove(Node node, E e) {
        if (node == null)//要删除的元素不存在
            return null;
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
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


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBSTString(root, 0, sb);
        return sb.toString();
    }

    //生成以node为节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder sb) {
        if (node == null) {
            sb.append(generateDepthString(depth) + "null\n");
            return;
        }
        sb.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, sb);
        generateBSTString(node.right, depth + 1, sb);
    }

    //生成深度字符串
    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("  ");
        }
        return sb.toString();
    }
}
