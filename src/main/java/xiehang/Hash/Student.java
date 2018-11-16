package xiehang.Hash;

/**
 * Created by Enzo Cotter on 2018/11/15.
 */
public class Student {
    private int grade;
    private int clas;
    private String firstName;
    private String lastName;

    public Student(int grade, int clas, String firstName, String lastName) {
        this.grade = grade;
        this.clas = clas;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        int B = 31;
        int hash = 0;
        hash = hash * B + grade;
        hash = hash * B + clas;
        hash = hash * B + firstName.toLowerCase().hashCode(); //不区分大小写
        hash = hash * B + lastName.toLowerCase().hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object o){

        if(this == o)
            return true;

        if(o == null)
            return false;

        if(getClass() != o.getClass())
            return false;

        Student another = (Student)o;
        return this.grade == another.grade &&
                this.clas == another.clas &&
                this.firstName.toLowerCase().equals(another.firstName.toLowerCase()) &&
                this.lastName.toLowerCase().equals(another.lastName.toLowerCase());
    }
}
