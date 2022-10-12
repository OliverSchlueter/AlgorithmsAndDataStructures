public class RemoveElement {

    /*
        https://leetcode.com/problems/remove-element/
     */

    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;

        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[size] = nums[i];
                size++;
            }
        }

        return size;
    }
}