package club.sondge.algorithm.sort;

import club.sondge.algorithm.common.Student;

import java.util.Arrays;

public class InsertionSort {

    private InsertionSort() {

    }

    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j - 1 >= 0 && array[j].compareTo(array[j - 1]) < 0; j--) {
                swap(array, j, j - 1);
            }
        }
    }

    public static <T extends Comparable<T>> void sort2(T[] array) {
        for (int i = 0; i < array.length; i++) {
            T tmp = array[i];
            int j = i;
            for (; j - 1 >= 0 && tmp.compareTo(array[j - 1]) < 0; j--) {
                array[j] = array[j - 1];
            }
            array[j] = tmp;
        }
    }

    public static <T extends Comparable<T>> void sort3(T[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            T tmp = array[i];
            int j = i;
            for (; j + 1 < array.length && tmp.compareTo(array[j + 1]) > 0; j++) {
                array[j] = array[j + 1];
            }
            array[j] = tmp;
        }
    }

    private static <E> void swap(E[] array, int i, int minIndex) {
        if (minIndex != i) {
            E temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        Integer[] array = {1, 34, 5, 1, 46, 7, 9, 29};

        System.out.println(Arrays.toString(array));
//        sort2(array);
        sort3(array);
        System.out.println(Arrays.toString(array));

        Student[] studentArray = {
                new Student("Bob"),
                new Student("Alice"),
                new Student("Mike")
        };

        System.out.println(Arrays.toString(studentArray));
//        sort2(studentArray);
        sort3(studentArray);
        System.out.println(Arrays.toString(studentArray));
    }
}
