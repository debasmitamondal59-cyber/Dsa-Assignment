import java.util.*;

class Solution {
    public int minOperations(int[] nums, int step) {
        int size = nums.length;

        int base = nums[0] % step;
        for (int i = 1; i < size; i++) {
            if (nums[i] % step != base) return -1;
        }

        int[] temp = new int[size];
        for (int i = 0; i < size; i++) {
            temp[i] = nums[i] / step;
        }

        Arrays.sort(temp);

        int mid = temp[size / 2];
        int moves = 0;

        for (int i = 0; i < size; i++) {
            moves += Math.abs(temp[i] - mid);
        }

        return moves;
    }
}
