package de.oliver.problems.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {

    /*
        https://leetcode.com/problems/unique-number-of-occurrences/
     */

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurrences = new HashMap<>();

        for (int i : arr) {
            if(occurrences.containsKey(i)){
                occurrences.replace(i, occurrences.get(i) + 1);
            } else {
                occurrences.put(i, 1);
            }
        }

        // a set only contains unique values and will remove duplicated values
        Set<Integer> uniqueValues = new HashSet<>(occurrences.values());

        return uniqueValues.size() == occurrences.size();
    }

}
