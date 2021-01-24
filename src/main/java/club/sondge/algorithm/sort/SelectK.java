package club.sondge.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class SelectK {

    public int findKthLargest(int[] nums, int k) {
        Random random = new Random();
        return findKthLargest(nums, 0, nums.length - 1, k, random);
    }

    private int findKthLargest(int[] nums, int left, int right, int k, Random random) {
        int p = partition(nums, left, right, random);
        if (p == nums.length - k) {
            return nums[p];
        } else if (p > nums.length - k) {
            return findKthLargest(nums, left, p - 1, k, random);
        }
        return findKthLargest(nums, p + 1, right, k, random);

    }

    private int partition(int[] nums, int left, int right, Random random) {
        int p = random.nextInt(right - left + 1) + left;
        swap(nums, p, left);
        int lt = left + 1, gt = right;
        while (true) {
            while (lt <= gt && nums[left] > nums[lt]) {
                lt++;
            }
            while (lt <= gt && nums[left] < nums[gt]) {
                gt--;
            }
            if (gt < lt) {
                break;
            }
            swap(nums, lt, gt);
            gt--;
            lt++;
        }
        swap(nums, left, gt);
        return gt;
    }

    private static void swap(int[] array, int start, int index) {
        int temp = array[index];
        array[index] = array[start];
        array[start] = temp;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        Random random = new Random();
        return getLeastNumbers(arr, 0, arr.length - 1, random, k);
    }

    private int[] getLeastNumbers(int[] arr, int left, int right, Random random, int k) {
        if (k <= 0) {
            return new int[0];
        }
        int p = partition(arr, left, right, random);
        if (k - 1 == p) {
            return Arrays.copyOfRange(arr, 0, k);
        } else if (k - 1 > p) {
            return getLeastNumbers(arr, p + 1, right, random, k);
        }
        return getLeastNumbers(arr, left, p - 1, random, k);
    }

//    private int partitionLeastNumbers(int[] arr, int left, int right, Random random) {
//        return 0;
//    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        System.out.println(Arrays.toString(new SelectK().getLeastNumbers(nums, 2)));
    }
}
