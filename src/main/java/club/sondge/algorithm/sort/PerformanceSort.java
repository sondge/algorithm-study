package club.sondge.algorithm.sort;

public class PerformanceSort<E> {

    public static <E extends Comparable<E>> void test(String sortName, E[] array) {
        long start = System.nanoTime();
        if ("MergeSort".equals(sortName)) {
            MergeSort.sort(array);
        } else if ("MergeSort2".equals(sortName)) {
            MergeSort.sort2(array);
        } else if ("InsertSort".equals(sortName)) {
            InsertionSort.sort2(array);
        } else if ("SelectionSort".equals(sortName)) {
            SelectionSort.sort(array);
        }
        long end = System.nanoTime();
        double time = (end - start) / 100000000.0;
        System.out.println("sort time is : " + time);
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
