package de.oliver.problems.leetcode;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicatesInAnArray {

    /*
        https://leetcode.com/problems/find-all-duplicates-in-an-array/
     */

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            if(!set.add(n)){
                duplicates.add(n);
            }
        }

        return duplicates;
    }

}
