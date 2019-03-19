package datastructures.Trie;

import java.util.TreeMap;

public class Trie {
    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "isWord=" + isWord +
                    ", next=" + next +
                    '}';
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    //获取Trie中存储的单词数量
    public int getSiez() {
        return size;
    }

    //向Trie中添加一个新的单词,非递归写法
    public void add(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.next.get(c) == null)
                curr.next.put(c, new Node());
            curr = curr.next.get(c);
        }
        if (!curr.isWord) {//如果这个单词以前不存在
            curr.isWord = true;
            size++;
        }
    }

    //查询Trie中是否存在word单词
    public boolean contains(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.next.get(c) == null){
                return false;
            }
            curr = curr.next.get(c);
        }
        return curr.isWord;
    }

    //查询Trie中是否存在word单词
    public boolean isPrefix(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (curr.next.get(c) == null){
                return false;
            }
            curr = curr.next.get(c);
        }
        return true;
    }
}

