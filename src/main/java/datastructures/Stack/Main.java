package datastructures.Stack;

public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<Integer>();
        for (int i = 0; i <= 5; i++){
            stack.push(i*10);
        }
        System.out.println(stack.toString());

        int i = stack.pop();
        System.out.println(i);
    }
}
