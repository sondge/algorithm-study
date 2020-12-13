package club.sondge.algorithm.search;

public class LinearSearch {
    private LinearSearch() {
    }

    public static int locatingByLine(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] != target) {
                continue;
            }
            return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 4, 5, 3, 4, 53, 3, 4, 34};

        System.out.println(locatingByLine(array, 34));
        System.out.println(locatingByLine(array, 100));

    }

}
