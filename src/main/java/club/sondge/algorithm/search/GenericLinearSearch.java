package club.sondge.algorithm.search;

public class GenericLinearSearch {
    private GenericLinearSearch() {
    }

    public static void main(String[] args) {
        testLogic();
        testPerformance();
    }

    private static void testPerformance() {
        int[] dataSize = {1000000, 10000000};
        for (int n : dataSize) {
            Integer[] array = ArrayGenerator.orderGenerator(n);
            long startTime = System.nanoTime();
            for (int i = 0; i < 100; i++) {
                linearSearch(array, n);
            }
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0d;
            System.out.println("数组大小为：" + n + "执行次数为：100 次，执行结果为: " + time);

        }
    }

    private static void testLogic() {
        Integer[] array = {1, 34, 56, 2, 4, 6, 43, 124};

        System.out.println(linearSearch(array, 34));
        System.out.println(linearSearch(array, 134));

        Student[] students = new Student[]{
                new Student("Alice"),
                new Student("Bob"),
                new Student("Mike"),
        };

        System.out.println(linearSearch(students, new Student("Mike")));
        System.out.println(linearSearch(students, null));
    }

    public static <T> int linearSearch(T[] data, T target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
}
