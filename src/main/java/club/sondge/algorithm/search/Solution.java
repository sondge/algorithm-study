package club.sondge.algorithm.search;

import java.util.Arrays;

public class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int left = 1, right = Arrays.stream(piles).max().getAsInt();
        while (left < right) {
            int mid = (left + right) / 2;
            int h = eatTime(piles, mid);
            if (H >= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int eatTime(int[] piles, int speed) {
        int result = 0;
        for (int pile : piles) {
            result += ((pile / speed) + ((pile % speed == 0) ? 0 : 1));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        System.out.println(new Solution().minEatingSpeed(piles, 8));
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(new Solution().shipWithinDays(weights, 5));
    }

    public int shipWithinDays(int[] weights, int D) {
        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = (right - left) / 2 + left;
            int day = getDays(weights, mid);
            if (D >= day) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int getDays(int[] weights, int mid) {
        int days = 0;
        int sum = 0;
        for (int weight : weights) {
            if (sum + weight <= mid) {
                sum += weight;
            } else {
                days++;
                sum = weight;
            }
        }

        return days + 1;
    }
}
