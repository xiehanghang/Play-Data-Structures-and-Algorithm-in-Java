package xiehang.UnionFind;

/**
 * 并查集，孩子指向父亲
 */
public class UnionFind3 implements UF{

    private int[] parent; //parent[i] 表示i指向的父节点是谁
    private int[] sz; //sz[i]表示以i为根节点的集合的个数

    public UnionFind3(int size){
        parent = new int[size];
        sz = new int[size];
        for (int i = 0; i < size; i++){
            parent[i] = i;//让每个元素指向它自己
            sz[i] = 1; // 每个元素自己独立成为一个集合
        }
    }

    //查找p元素所在元素集合的根节点，根节点 p = parent[p]
    //o(h)复杂度，H为树的高度
    public int find(int p){
        if (p < 0 && p > parent.length)
            throw new IllegalArgumentException("p is illegal");
        while (p != parent[p])//如果p不指向自己 p = parent[p]
            p = parent[p];//p指向它的父节点
        return p;//返回p元素所在集合的根节点
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);//o(h)
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (qRoot == pRoot)
            return;
        if (sz[qRoot] < sz[pRoot]){
            //如果qRoot的集合小于pRoot，让qRoot指向pRoot
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }else {
            parent[pRoot] = parent[qRoot];
            sz[qRoot] += sz[pRoot];
        }
    }
}
