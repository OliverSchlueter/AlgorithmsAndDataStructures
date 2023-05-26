package de.oliver.problems.leetcode;

import java.util.Arrays;

public class BoatsToSavePeople {

    /*
        https://leetcode.com/problems/boats-to-save-people/
     */

    public int numRescueBoats(int[] people, int limit) {
        people = Arrays.stream(people).sorted().toArray();

        int boats = 0;

        int left = 0;
        int right = people.length - 1;

        while(left <= right){
            int remain = limit - people[right];
            right--;
            boats++;

            if(left <= right && remain >= people[left]){
                left++;
            }
        }

        return boats;
    }

}
