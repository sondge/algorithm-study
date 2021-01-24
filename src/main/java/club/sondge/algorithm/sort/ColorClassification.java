package club.sondge.algorithm.sort;

import java.util.Random;

public class ColorClassification {
    public void sortColors(int[] nums) {
        Random random = new Random();
        sortColors(nums, 0, nums.length - 1, random);
    }

    private void sortColors(int[] nums, int left, int right, Random random) {
        if (right <= left) {
            return;
        }
        int p = random.nextInt(right - left + 1) + left;
        swap(nums, p, left);

        int lt = left + 1, gt = right + 1, index = left + 1;

        while (index < gt) {
            if (nums[left] > nums[index]) {
                lt++;
                swap(nums, index, lt);
                index++;
            } else if (nums[left] < nums[index]) {
                gt--;
                swap(nums, index, gt);
            } else {
                index++;
            }
        }
        swap(nums, left, lt);
        sortColors(nums, left, lt - 1, random);
        sortColors(nums, gt, right, random);
    }

    private static void swap(int[] array, int start, int index) {
        int temp = array[index];
        array[index] = array[start];
        array[start] = temp;
    }
}
