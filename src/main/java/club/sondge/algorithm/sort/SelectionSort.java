package club.sondge.algorithm.sort;

import club.sondge.algorithm.common.Student;

import java.util.Arrays;

/**
 * 选择排序的方法
 */
public class SelectionSort {
    private SelectionSort() {

    }

    public static <E extends Comparable<E>> void selectSort(E[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    public static <E extends Comparable<E>> void sort(E[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int maxIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (array[j].compareTo(array[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            swap(array, i, maxIndex);
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
        sort(array);
//        selectSort(array);
        System.out.println(Arrays.toString(array));

        Student[] studentArray = {
                new Student("Bob"),
                new Student("Alice"),
                new Student("Mike")
        };

        System.out.println(Arrays.toString(studentArray));
        sort(studentArray);
//        selectSort(studentArray);
        System.out.println(Arrays.toString(studentArray));

    }

}
