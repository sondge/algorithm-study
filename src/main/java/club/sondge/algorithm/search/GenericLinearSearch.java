package club.sondge.algorithm.search;

public class GenericLinearSearch {
    private GenericLinearSearch() {
    }

    public static void main(String[] args) {
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
