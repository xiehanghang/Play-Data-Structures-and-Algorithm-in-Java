package datastructures.SegmentTree;


import org.junit.Test;

public class Main {
    @Test
    public void testSegmentTree(){
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);
//        System.out.println(segmentTree);
        System.out.println(segmentTree.query(0,5));
    }
}
