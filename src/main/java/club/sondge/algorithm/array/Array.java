package club.sondge.algorithm.array;

@SuppressWarnings("UnusedReturnValue")
public class Array<E> {

    private E[] data;
    private int size;

    public Array() {
        this(10);
    }

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public int getCapacity() {
        return data.length;
    }

    public int getSize() {
        return size;
    }

    @SuppressWarnings("ManualArrayCopy")
    public void addElement(int index, E element) {
        if (index < 0 && index > size) {
            throw new IllegalArgumentException("索引不能为 0");
        }
        if (size >= data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
    }


    public void addLast(E element) {
        addElement(size, element);
    }

    public void addFirst(E element) {
        addElement(0, element);
    }

    @SuppressWarnings("ManualArrayCopy")
    private void resize(int length) {
        E[] newData = (E[]) new Object[length];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("索引超出范围，获取失败");
        }
        return data[index];
    }

    public void set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("索引超出范围，设置失败");
        }
        data[index] = element;
    }

    @SuppressWarnings("ManualArrayCopy")
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("索引超出范围，删除失败");
        }
        E ret = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        if (size <= data.length / 4 && data.length / 4 > 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E element) {
        int index = find(element);
        if (index != -1) {
            remove(index);
        }

    }

    public int find(E element) {
        if (size == 0) {
            return -1;
        }
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contain(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i < size - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");

        return "Array{" +
                "data=" + builder.toString() +
                ", size=" + getSize() +
                ", capacity=" + getCapacity() +
                '}';
    }

    public static void main(String[] args) {
        Array<Integer> array = new Array<Integer>();
        array.addLast(0);
        System.out.println(array);
        array.addFirst(100);
        System.out.println(array);
        array.addFirst(99);
        System.out.println(array);
        array.addFirst(86);
        System.out.println(array);
        array.addFirst(92);
        System.out.println(array);
        array.addFirst(93);
        System.out.println(array);
        array.addFirst(94);
        System.out.println(array);
        array.addLast(100);
        System.out.println(array);
        array.addLast(100);
        System.out.println(array);
        array.addLast(100);
        System.out.println(array);
        array.addLast(100);
        System.out.println(array);
        array.removeElement(100);
        System.out.println(array);
        array.removeFirst();
        System.out.println(array);
        array.removeLast();
        System.out.println(array);
        array.removeFirst();
        System.out.println(array);
        array.removeLast();
        System.out.println(array);
        array.removeFirst();
        System.out.println(array);
        array.removeLast();
        System.out.println(array);
        System.out.println(array.get(3));
        System.out.println(array.contain(100));
        array.set(2, 65);
        System.out.println(array);

    }
}
