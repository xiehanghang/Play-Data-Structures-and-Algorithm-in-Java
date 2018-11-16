package xiehang.Array;

/**
 * Created by Enzo Cotter on 2018/10/19.
 */
public class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString(){
        return String.format("xiehang.Array.Student(name:%s,score:%d",name,score);
    }

    public static void main(String[] args) {
        Array<Student> arr = new Array<Student>();
        arr.addLast(new Student("xiehang",60));
        arr.addLast(new Student("xiaowang",80));
        arr.addLast(new Student("xiaohong",22));
        System.out.println(arr.toString());
    }
}
