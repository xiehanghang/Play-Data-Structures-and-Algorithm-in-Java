package xiehang.Tree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    //遍历测试
    @Test
    public void testBST(){
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        ////////////////////
        //       5
        //      / \
        //     3   6
        //    / \ / \
        //   2  4    8
        for (int num : nums){
            bst.add(num);
        }
        System.out.println("前序遍历递归实现");
        bst.preOrder();

        System.out.println("中序遍历");
        bst.inOrder();

        System.out.println("后序遍历");
        bst.postOrder();

        System.out.println("层序遍历");
        bst.levelOrder();
    }

    //删除节点测试
    @Test
    public void testDelete(){
        BST<Integer> bst = new BST<>();
        int n = 1000;
        Random random = new Random();
        for (int i = 0; i < n; i++){
            bst.add(random.nextInt(1000));
        }
        ArrayList<Integer> nums = new ArrayList<>();
        while(!bst.isEmpty())
            nums.add(bst.removeMin());
        System.out.println(nums);
    }

}
