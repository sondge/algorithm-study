package club.sondge.algorithm.sort;

import java.util.Arrays;

public class Solution {

    public int reversePairs(int[] nums) {
//        int[] temp = Arrays.copyOf(nums, nums.length);
//        return sort(nums, 0, nums.length - 1, temp);

        return sortBU(nums);
    }

    private int sort(int[] array, int left, int right, int[] temp) {
        if (right <= left) {
            return 0;
        }
        int result = 0;
        int mid = left + (right - left) / 2;
        result += sort(array, left, mid, temp);
        result += sort(array, mid + 1, right, temp);
        if (array[mid] > array[mid + 1]) {
            result += merge(array, left, mid, right, temp);
        }
        return result;
    }

    private int merge(int[] array, int left, int mid, int right, int[] temp) {
        int result = 0;
        System.arraycopy(array, left, temp, left, right - left + 1);
        int l = left;
        int r = mid + 1;
        for (int i = left; i <= right; i++) {
            if (l > mid) {
                array[i] = temp[r];
                r++;
            } else if (r > right) {
                array[i] = temp[l];
                l++;
            } else if (temp[l] <= (temp[r])) {
                array[i] = temp[l];
                l++;
            } else {
                array[i] = temp[r];
//                System.out.println(temp[l] + "," + temp[r]);
                r++;
                result += (mid - l + 1);
            }
        }
        return result;
    }

    public int sortBU(int[] array) {
        int result = 0;
        int[] temp = Arrays.copyOf(array, array.length);
        for (int size = 1; size < array.length; size += size) {
            for (int i = 0; i + size < array.length; i += size + size) {
                if (array[i + size - 1] > (array[i + size])) {
                    result += merge(array, i, i + size - 1, Math.min(i + size + size - 1, array.length - 1), temp);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] array = {7, 5, 6, 4};
        System.out.println(new Solution().reversePairs(array));
    }
}
