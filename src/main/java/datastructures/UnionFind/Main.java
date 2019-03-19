package datastructures.UnionFind;

import org.junit.Test;

import java.util.Random;

public class Main {

    private static double testUF(UF uf, int m){
        int size = uf.getSize();

        long startTime = System.nanoTime();
        Random random = new Random(size);
        for (int i = 0; i < m; i++)
            uf.unionElements(random.nextInt(size), random.nextInt(size));
        for (int i = 0; i < m; i++)
            uf.isConnected(random.nextInt(size), random.nextInt(size));
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
    @Test
    public void testUnionFind1and2(){
        int size = 10000000;
        int m = 10000000;
//        UnionFind1 unionFind1 = new UnionFind1(size);
//        UnionFind2 unionFind2 = new UnionFind2(size);
        UnionFind3 unionFind3 = new UnionFind3(size);
        UnionFind4 unionFind4 = new UnionFind4(size);
        UnionFind5 unionFind5 = new UnionFind5(size);
        UnionFind6 unionFind6 = new UnionFind6(size);
//        System.out.println("UnionFind1: " + testUF(unionFind1, m));
//        System.out.println("UnionFind2: " + testUF(unionFind2, m));
        System.out.println("UnionFind3: " + testUF(unionFind3, m));
        System.out.println("UnionFind4: " + testUF(unionFind4, m));
        System.out.println("UnionFind5: " + testUF(unionFind5, m));
        System.out.println("UnionFind6: " + testUF(unionFind6, m));//比6慢一点,因为在递归上有所消耗
    }
}
