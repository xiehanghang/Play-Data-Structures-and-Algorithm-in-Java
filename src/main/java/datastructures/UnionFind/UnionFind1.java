package datastructures.UnionFind;

public class UnionFind1 implements UF{
    private int[] id;
    public UnionFind1(int size){
        id = new int[size];

        for (int i = 0; i < id.length; i++){
            id[i] = i;
        }
    }

    //查找元素p所对应的集合编号
    private int find(int p){
        if (p < 0 && p > id.length)
            throw new IllegalArgumentException("p is illegal");
        return id[p];
    }

    @Override
    public int getSize() {
        return id.length;
    }

    //查看p，q是否属于一个集合
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pID = id[p];
        int qID = id[q];
        for (int i = 0; i < id.length; i++){
            if (id[i] == pID)
                id[i] = qID;
        }
    }
}
