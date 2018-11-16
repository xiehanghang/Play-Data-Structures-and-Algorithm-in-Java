package xiehang.recursive;

import org.junit.Test;

/**
 * 递归求和数组
 */
public class Sum {
    public static int sum(int[] arr){
        return sum(arr,0);
    }
    public static int sum(int[] arr, int left){
        if (left == arr.length){
            return 0;
        }
        return arr[left] + sum(arr,left + 1);
    }

    @Test
    public void test(){
        int[] arr = {1,2,3,4,4,5,6};
        System.out.println(sum(arr));
    }
}
