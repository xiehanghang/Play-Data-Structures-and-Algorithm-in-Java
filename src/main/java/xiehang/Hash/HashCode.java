package xiehang.Hash;

import org.junit.Test;

/**
 * Created by Enzo Cotter on 2018/11/15.
 */
public class HashCode {
    @Test
    public void test1(){
        int a = 2;
        int b = -1;
        System.out.println(((Integer)a).hashCode());
        System.out.println(((Integer)b).hashCode());

        String c = "A";
        System.out.println(c.hashCode());

        Student student = new Student(1,2,"Xie","hang");
        System.out.println(student.hashCode());

    }
}
