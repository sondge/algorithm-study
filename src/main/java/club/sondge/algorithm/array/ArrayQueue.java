package club.sondge.algorithm.array;

public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<E>();
    }

    public ArrayQueue() {
        array = new Array<E>();
    }


    public int getSize() {
        return array.getSize();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public boolean contains(E e) {
        return array.contain(e);
    }

    public E dequeue() {
        return array.removeFirst();
    }

    public void enqueue(E e) {
        array.addLast(e);
    }

    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        return "ArrayQueue front{" +
                "array=" + array +
                "} tail";
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayQueue<Integer>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue);
    }

}
