package de.oliver.problems.leetcode;

import java.util.*;

public class TopKFrequentElements {

    /*
        https://leetcode.com/problems/top-k-frequent-elements/
     */

    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];

        Map<Integer, Integer> frequencies = new HashMap<>(); // num, amount

        for (int i = 0; i < nums.length; i++) {
            frequencies.put(nums[i], frequencies.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> sortedNumsByAmount = sort(frequencies).stream().map(Map.Entry::getKey).toList();

        for (int i = 0; i < k; i++) {
            result[i] = sortedNumsByAmount.get(i);
        }

        return result;
    }

    public List<Map.Entry<Integer, Integer>> sort(Map<Integer, Integer> map){
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        Collections.reverse(list);

        return list;
    }

    public static void main(String[] args) {
        for (int i : new TopKFrequentElements().topKFrequent(new int[]{-1, -1}, 1)) {
            System.out.println(i);
        }
    }

}
