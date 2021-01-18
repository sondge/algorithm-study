package club.sondge.algorithm.array;

import java.util.Arrays;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    private int front, tail;

    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return front == tail;
    }

    public E dequeue() {
        E e = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size > 0 && size <= (data.length - 1) / 4 && data.length >= 2) {
            resize(getCapacity() / 2);
        }
        return e;
    }

    public void enqueue(E e) {
        data[tail] = e;
        size++;
        tail = (tail + 1) % data.length;
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        int startIndex = front;
        for (int i = 0; i < size; i++) {
            newData[i] = data[(startIndex + i) % data.length];
        }
        front = 0;
        tail = size;
        data = newData;
    }

    public E getFront() {
        return data[front];
    }

    @Override
    public String toString() {
        return "LoopQueue{" +
                "data=" + Arrays.toString(data) +
                ", front=" + front +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LoopQueue<Integer>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue);
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue);
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue);
    }
}
