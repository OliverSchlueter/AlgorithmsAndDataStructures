package problems.leetcode;

public class TwoSum {

    /*
        https://leetcode.com/problems/two-sum/
     */

    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(i == j){
                    continue;
                }

                int sum = nums[i] + nums[j];
                if(sum == target){
                    return new int[] {i, j};
                }
            }
        }

        return null;
    }

}
