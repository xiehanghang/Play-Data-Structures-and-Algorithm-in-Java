package datastructures.Hash;

import java.util.TreeMap;

public class HashTable<K, V> {
    private TreeMap<K, V>[] hashtable;
    private int M; //一个合适的素数
    private int size;

    public HashTable(int m) {
        M = m;
        size = 0;
        hashtable = new TreeMap[m];
        for (int i = 0; i < m; i++)
            hashtable[i] = new TreeMap<>();
    }

    public HashTable(){
        this(97);
    }

    //哈希函数
    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize(){
        return size;
    }

    public void add(K k, V v){
        TreeMap<K, V> map = hashtable[hash(k)];
    }
}
