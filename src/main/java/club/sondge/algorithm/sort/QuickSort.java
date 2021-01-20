package club.sondge.algorithm.sort;

import club.sondge.algorithm.search.ArrayGenerator;

import java.util.Arrays;
import java.util.Random;

public class QuickSort<E> {

    public static <E extends Comparable<E>> void sort(E[] array) {
        Random random = new Random();
        sort(array, 0, array.length - 1, random);
    }

    private static <E extends Comparable<E>> void sort(E[] array, int left, int right, Random random) {
        if (right <= left) {
            return;
        }
        int p = partion(array, left, right, random);
        sort(array, left, p, random);
        sort(array, p + 1, right, random);
    }

    private static <E extends Comparable<E>> int partion(E[] array, int left, int right, Random random) {
        int rdm = random.nextInt(right - left + 1) + left;
        swap(array, left, rdm);
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
        int n = 100000000;
        Integer[] array = ArrayGenerator.randomGenerator(n, n);
        Integer[] arr = Arrays.copyOf(array, array.length);
        PerformanceSort.test("QuickSort", array);
        PerformanceSort.test("MergeSort", arr);
        Integer[] array1 = ArrayGenerator.orderGenerator(n);
        Integer[] arr1 = Arrays.copyOf(array1, array1.length);
        PerformanceSort.test("QuickSort", array1);
        PerformanceSort.test("MergeSort", arr1);
    }
}
