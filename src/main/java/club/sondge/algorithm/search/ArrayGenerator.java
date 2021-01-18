package club.sondge.algorithm.search;

import java.util.Random;

public class ArrayGenerator {

    private ArrayGenerator() {

    }

    public static Integer[] orderGenerator(int n) {
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }

        return array;
    }

    public static Integer[] randomGenerator(int n, int r) {
        Random random = new Random();
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(r);
        }

        return array;
    }
}
