package de.oliver.problems.leetcode;

public class SingleNumber {

    /*
        https://leetcode.com/problems/single-number/
     */

    /**
     * The XOR will cancel the same numbers out
     */
    public int singleNumber(int[] nums) {
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }

        return result;
    }

}
