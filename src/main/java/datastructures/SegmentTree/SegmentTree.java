package datastructures.SegmentTree;

public class SegmentTree<E> {

    private E[] data;
    private E[] tree;
    private Merger<E> merge;

    public SegmentTree(E[] arr, Merger<E> merge) {
        this.merge = merge;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[arr.length * 4];
        buildSegmentTree(0, 0, data.length - 1);//传入根节点、数组区间
    }

    //在treeIndex的位置创建表示区间[l...r]的线段树,递归函数
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {//区间长度为1，只有一个数
            tree[treeIndex] = data[l];
            return;
        }
        //获取treeIndex的节点的左右节点在tree[]中的索引
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        //int mid = (l + r) / 2; 这种写法可能会整形溢出
        int mid = l + (r - l) / 2;//左[l, mid]  右[mid+1 ,r]
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);
        tree[treeIndex] = merge.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public E get(int index) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("index is illegal");
        else
            return data[index];
    }

    public int getSize() {
        return data.length;
    }

    //--------------------------两个辅助函数，leftChild，rightChild----------
    //返回数组中指定index对应的节点的左节点的索引

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    //返回数组中指定index对应的节点的右节点的索引
    private int rightChild(int index) {
        return 2 * index + 2;
    }
    //-----------------------------两个辅助函数，leftChild，rightChild--------

    //返回[queryL, queryR]的值
    public E query(int queryL, int queryR){
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR > data.length || queryL > queryR)
            throw new IllegalArgumentException("index is illegal");
        return query(0, 0, data.length -1, queryL, queryR);
    }

    //在以treeIndex为根的线段树的[l...r]中范围里，搜索区间[queryL...queryR]的值
    private E query(int treeIndex, int l, int r, int queryL, int queryR){
        if (l == queryL && r == queryR)
            return tree[treeIndex];

        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (queryL >= mid + 1)
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        else if (queryR <= mid)
            return query(leftTreeIndex, l, mid, queryL, queryR);

        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
        return merge.merge(leftResult, rightResult);
    }

    //将index位置的元素修改为e
    public void set(int index, E e){
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("index is illegal");
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    //在以treeIndex为根节点的线段树中更新index的值为e
    private void set(int treeIndex, int l,int r, int index, E e){
        if (l == r){
            tree[treeIndex] = e;
            return;
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeindex = rightChild(treeIndex);

        if (index >= mid + 1)
            set(rightTreeindex, mid + 1, r, index, e);
        else
            set(leftTreeIndex, l, mid, index, e);

        tree[treeIndex] = merge.merge(tree[leftTreeIndex], tree[rightTreeindex]);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < tree.length; i++){
            if (tree[i] != null)
                sb.append(tree[i]);
            else
                sb.append("null");
            if (i != tree.length - 1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
