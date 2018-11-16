package xiehang.UnionFind;

/**
 * 并查集，孩子指向父亲
 */
public class UnionFind5 implements UF{

    private int[] parent; //parent[i] 表示i指向的父节点是谁
    //rank[i]表示以i为根节点的树的“排名”,即使使用了路径压缩优化算法也不必维护这个rank
    //使用路径压缩之后rank不再与深度相等，而是一个排名，作为用来合并两个集合时所需要的参数（够用）
    private int[] rank;

    public UnionFind5(int size){
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++){
            parent[i] = i;//让每个元素指向它自己
            rank[i] = 1; // 每个集合的深度为1
        }
    }

    //查找p元素所在元素集合的根节点，根节点 p = parent[p]
    //o(h)复杂度，H为树的高度
    public int find(int p){
        if (p < 0 && p > parent.length)
            throw new IllegalArgumentException("p is illegal");
        while (p != parent[p]) {//如果p不指向自己 p = parent[p]
            parent[p] = parent[parent[p]];//让p的父节点指向父节点的父节点
            p = parent[p];//p指向它的父节点
        }
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
        if (rank[qRoot] < rank[pRoot]){
            //如果qRoot的集合小于pRoot，让qRoot指向pRoot
            parent[qRoot] = pRoot;
        }else if (rank[qRoot] > rank[pRoot]){
            parent[pRoot] = parent[qRoot];
        }else { //如果两个树深度相等，需要维护rank
            parent[pRoot] = parent[qRoot];
            rank[qRoot] += 1;
        }
    }
}
