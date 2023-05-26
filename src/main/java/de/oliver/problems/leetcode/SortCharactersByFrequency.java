package de.oliver.problems.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {

    /*
        https://leetcode.com/problems/sort-characters-by-frequency/
     */

    public String frequencySort(String s) {
        Map<Character, Integer> frequencies = new HashMap<>();

        char[] chars = s.toCharArray();

        for (char c : chars) {
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }

        String result = "";

        List<Map.Entry<Character, Integer>> sorted = frequencies
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .toList();

        for (Map.Entry<Character, Integer> e : sorted) {
            for (int i = 0; i < e.getValue(); i++) {
                result += e.getKey();
            }
        }

        return result;
    }

}
