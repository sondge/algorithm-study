package club.sondge.algorithm.sort;

import club.sondge.algorithm.search.ArrayGenerator;

public class QuickSort<E> {

    public static <E extends Comparable<E>> void sort(E[] array) {
        sort(array, 0, array.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] array, int left, int right) {
        if (right <= left) {
            return;
        }
        int p = partion(array, left, right);
        sort(array, left, p);
        sort(array, p + 1, right);
    }

    private static <E extends Comparable<E>> int partion(E[] array, int left, int right) {
        int start = left;
        for (int i = start + 1; i <= right; i++) {
            if (array[left].compareTo(array[i]) > 0) {
                start++;
                swap(array, start, i);
            }
        }
        swap(array, start, left);
        return start;
    }

    private static <E extends Comparable<E>> void swap(E[] array, int start, int index) {
        E temp = array[index];
        array[index] = array[start];
        array[start] = temp;
    }

    public static void main(String[] args) {
        Integer[] array = ArrayGenerator.randomGenerator(10000000, 1000);
        PerformanceSort.test("QuickSort", array);
    }
}
