package club.sondge.algorithm.array;

public class ArrayStack<E> implements Stack<E> {
    /**
     * 元素的存储方式是以 array 的方式进行的
     */
    private Array<E> array;

    public ArrayStack() {
        array = new Array<E>();
    }

    public ArrayStack(int capacity) {
        array = new Array<E>(capacity);
    }

    public E pop() {
        return array.removeLast();
    }

    public E peek() {
        return array.getLast();
    }

    public void push(E e) {
        array.addLast(e);
    }

    public int getSize() {
        return array.getSize();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        return "Stack{" +
                array +
                '}' + "top";
    }
}
