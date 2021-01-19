package club.sondge.algorithm.sort;

import club.sondge.algorithm.search.ArrayGenerator;

import java.util.Arrays;

public class MergeSort<E> {

    public static <E extends Comparable<E>> void sort(E[] array) {
        E[] temp = Arrays.copyOf(array, array.length);
        sort(array, 0, array.length - 1, temp);
    }

    private static <E extends Comparable<E>> void sort(E[] array, int left, int right, E[] temp) {

        if (right <= left) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(array, left, mid, temp);
        sort(array, mid + 1, right, temp);
        if (array[mid].compareTo(array[mid + 1]) > 0) {
            merge(array, left, mid, right, temp);
        }

    }

    private static <E extends Comparable<E>> void merge(E[] array, int left, int mid, int right, E[] temp) {
        System.arraycopy(array, left, temp, left, right - left + 1);
        int l = left;
        int r = mid + 1;
        for (int i = left; i <= right; i++) {
            if (l > mid) {
                array[i] = temp[r];
                r++;
            } else if (r > right) {
                array[i] = temp[l];
                l++;
            } else if (temp[l].compareTo(temp[r]) <= 0) {
                array[i] = temp[l];
                l++;
            } else {
                array[i] = temp[r];
                r++;
            }
        }
    }

    public static <E extends Comparable<E>> void sortBU(E[] array) {
        E[] temp = Arrays.copyOf(array, array.length);
        for (int size = 1; size < array.length; size += size) {
            for (int i = 0; i + size < array.length; i += size + size) {
                if (array[i + size - 1].compareTo(array[i + size]) > 0) {
                    merge(array, i, i + size - 1, Math.min(i + size + size - 1, array.length - 1), temp);
                }
            }
        }
    }


    public static void main(String[] args) {
        Integer[] array = ArrayGenerator.randomGenerator(100000, 1000000);
        PerformanceSort.test("MergeSort", array);

        Integer[] array1 = ArrayGenerator.randomGenerator(100000, 1000000);
        PerformanceSort.test("MergeSortBU", array1);

//        Integer[] array2 = ArrayGenerator.randomGenerator(100000, 1000000);
//        PerformanceSort.test("InsertSort", array2);
//
//        Integer[] array3 = ArrayGenerator.randomGenerator(100000, 1000000);
//        PerformanceSort.test("SelectionSort", array3);

    }
}
