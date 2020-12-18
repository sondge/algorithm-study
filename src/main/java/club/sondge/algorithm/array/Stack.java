package club.sondge.algorithm.array;

public interface Stack<E> {
    /**
     * 出栈操作
     */
    E pop();

    /**
     * 获取栈顶元素
     */
    E peek();

    /**
     * 将元素 e 入栈
     */
    void push(E e);

    /**
     * 获取栈的大小
     */
    int getSize();

    /**
     * 栈是否为空
     */
    boolean isEmpty();
}
