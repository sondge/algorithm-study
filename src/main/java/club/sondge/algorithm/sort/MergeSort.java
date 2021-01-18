package club.sondge.algorithm.sort;
import club.sondge.algorithm.search.ArrayGenerator;

import java.util.Arrays;

public class MergeSort<E> {

    public static <E extends Comparable<E>> void sort(E[] array) {
        sort(array, 0, array.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] array, int left, int right) {

        if (right <= left) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(array, left, mid);
        sort(array, mid + 1, right);
        if (array[mid].compareTo(array[mid + 1]) > 0) {
            merge(array, left, mid, right);
        }

    }

    private static <E extends Comparable<E>> void merge(E[] array, int left, int mid, int right) {

        E[] tmp = Arrays.copyOfRange(array, left, right + 1);
        int l = left;
        int r = mid + 1;
        for (int i = left; i <= right; i++) {
            if (l > mid) {
                array[i] = tmp[r - left];
                r++;
            } else if (r > right) {
                array[i] = tmp[l - left];
                l++;
            } else if (tmp[l - left].compareTo(tmp[r - left]) <= 0) {
                array[i] = tmp[l - left];
                l++;
            } else {
                array[i] = tmp[r - left];
                r++;
            }
        }
    }





    public static void main(String[] args) {
        Integer[] array = ArrayGenerator.randomGenerator(100000, 1000000);
        PerformanceSort.test("MergeSort", array);

        Integer[] array1 = ArrayGenerator.randomGenerator(100000, 1000000);
        PerformanceSort.test("MergeSort2", array1);

//        Integer[] array2 = ArrayGenerator.randomGenerator(100000, 1000000);
//        PerformanceSort.test("InsertSort", array2);
//
//        Integer[] array3 = ArrayGenerator.randomGenerator(100000, 1000000);
//        PerformanceSort.test("SelectionSort", array3);

    }
}
