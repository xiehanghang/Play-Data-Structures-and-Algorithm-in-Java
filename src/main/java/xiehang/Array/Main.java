package xiehang.Array;

public class Main {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<Integer>(10);
        for (int i = 0; i < 10; i++){
            arr.addLast(i);
        }
        System.out.println(arr);

        /*arr.add(2,99);
        System.out.println(arr);

        System.out.println(arr.get(2));

        arr.set(2,2);
        System.out.println(arr.get(2));*/

        arr.addLast(100);
        System.out.println(arr);

        arr.removeLast();
        System.out.println(arr);
    }
}
