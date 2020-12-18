package club.sondge.algorithm.array;

public class ArrayTest {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<Integer>();
        stack.isEmpty();
        stack.getCapacity();
        stack.push(2);
        System.out.println(stack);
        stack.push(2);
        System.out.println(stack);
        stack.push(1);
        System.out.println(stack);
        stack.push(13);
        System.out.println(stack);
        stack.push(3);
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack);
        stack.isEmpty();
    }
}
