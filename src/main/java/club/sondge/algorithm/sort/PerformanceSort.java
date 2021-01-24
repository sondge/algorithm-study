package club.sondge.algorithm.sort;

public class PerformanceSort<E> {

    public static <E extends Comparable<E>> void test(String sortName, E[] array) {
        long start = System.nanoTime();
        if ("MergeSort".equals(sortName)) {
            MergeSort.sort(array);
        } else if ("MergeSortBU".equals(sortName)) {
            MergeSort.sortBU(array);
        } else if ("InsertSort".equals(sortName)) {
            InsertionSort.sort2(array);
        } else if ("SelectionSort".equals(sortName)) {
            SelectionSort.sort(array);
        } else if ("QuickSort".equals(sortName)) {
            QuickSort.sort(array);
        } else if ("QuickSort2".equals(sortName)) {
            QuickSort.sort2Way(array);
        } else if ("QuickSort3".equals(sortName)) {
            QuickSort.sort3Way(array);
        }

        long end = System.nanoTime();
        double time = (end - start) / 1000000000.0;
        System.out.println(sortName + " sort time is : " + time + "s");
        isSort(array);
    }

    private static <E extends Comparable<E>> void isSort(E[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                System.out.println("index is " + i
                        + "， array[" + i + "] = " + array[i]
                        + ": array[" + (i + 1) + "] = " + array[i + 1]);
                throw new RuntimeException("sort is correct");
            }
        }
    }
}
