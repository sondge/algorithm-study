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
        int p = partition(array, left, right, random);
        sort(array, left, p, random);
        sort(array, p + 1, right, random);
    }

    private static <E extends Comparable<E>> int partition(E[] array, int left, int right, Random random) {
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


    public static <E extends Comparable<E>> void sort2Way(E[] array) {
//        System.out.println(Arrays.toString(array));
        Random random = new Random();
        sort2Way(array, 0, array.length - 1, random);
    }

    private static <E extends Comparable<E>> void sort2Way(E[] array, int left, int right, Random random) {
        if (right <= left) {
            return;
        }
//        System.out.println("进入循环:left = " + left + ", right = " + right);
        int p = partition2Way(array, left, right, random);
        sort2Way(array, left, p - 1, random);
        sort2Way(array, p + 1, right, random);

    }

    private static <E extends Comparable<E>> int partition2Way(E[] array, int left, int right, Random random) {

        int swapIndex = random.nextInt(right - left + 1) + left;
        swap(array, left, swapIndex);
        int ri = right, li = left + 1;
        while (true) {
            while (li <= ri && array[left].compareTo(array[li]) > 0) {
                li++;
            }
            while (li <= ri && array[left].compareTo(array[ri]) < 0) {
                ri--;
            }
            if (li >= ri) {
                break;
            }
            swap(array, li, ri);
            ri--;
            li++;
        }
        swap(array, left, ri);
//        System.out.println(Arrays.toString(array));
        return ri;
    }

    public static <E extends Comparable<E>> void sort3Way(E[] array) {
        Random random = new Random();
        sort3Way(array, 0, array.length - 1, random);
    }

    private static <E extends Comparable<E>> void sort3Way(E[] array, int left, int right, Random random) {
//        System.out.println("进入循环:left = " + left + ", right = " + right);
        if (right <= left) {
            return;
        }
        int temp = random.nextInt(right - left + 1) + left;
        swap(array, temp, left);
        int lt = left, gt = right + 1, i = left + 1;
        while (i < gt) {
            if (array[left].compareTo(array[i]) > 0) {
                lt++;
                swap(array, lt, i);
                i++;
            } else if (array[left].compareTo(array[i]) < 0) {
                gt--;
                swap(array, i, gt);
            } else {
                i++;
            }
        }
        swap(array, lt, left);
        sort3Way(array, left, lt - 1, random);
        sort3Way(array, gt, right, random);


    }


    private static <E extends Comparable<E>> void swap(E[] array, int start, int index) {
        E temp = array[index];
        array[index] = array[start];
        array[start] = temp;
    }

    public static void main(String[] args) {
//        int n = 100000000;
//        Integer[] array = ArrayGenerator.randomGenerator(n, n);
//        Integer[] arr = Arrays.copyOf(array, array.length);
//        PerformanceSort.test("QuickSort", array);
//        PerformanceSort.test("MergeSort", arr);
//        Integer[] array1 = ArrayGenerator.orderGenerator(n);
//        Integer[] arr1 = Arrays.copyOf(array1, array1.length);
//        PerformanceSort.test("QuickSort", array1);
//        PerformanceSort.test("MergeSort", arr1);
//
        int n = 5000000;
        Integer[] array = ArrayGenerator.randomGenerator(n, 3);
        Integer[] arr = Arrays.copyOf(array, array.length);

        PerformanceSort.test("QuickSort3", array);
        PerformanceSort.test("QuickSort2", arr);
//        Integer[] array = new Integer[]{1, 8, 7, 6, 4};
//        PerformanceSort.test("QuickSort2", array);

    }
}
