package de.oliver.problems.leetcode;

public class NonDecreasingArray {

    /*
        https://leetcode.com/problems/non-decreasing-array/
     */

    public boolean checkPossibility(int[] nums) {
        boolean modified = false;

        for (int i = 0; i < nums.length - 1; i++) {
            int current = nums[i];
            int right = nums[i + 1];

            if(current <= right) continue;

            if(modified) return false;

            if(i == 0 || right >= nums[i - 1]){
                nums[i] = right;
            } else {
                nums[i + 1] = current;
            }

            modified = true;
        }

        return true;
    }

}
