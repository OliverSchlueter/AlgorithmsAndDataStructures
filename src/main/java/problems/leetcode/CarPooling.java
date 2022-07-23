package problems.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CarPooling {

    /*
        https://leetcode.com/problems/car-pooling/
     */

    public static boolean carPooling(int[][] trips, int capacity) {

        int maxToPos = 0;

        // sort by starting point
        for (int i = 0; i < trips.length; i++) {
            if(trips[i][2] > maxToPos) maxToPos = trips[i][2]; // set max to-pos

            for (int j = i + 1; j < trips.length; j++) {
                if(trips[j][1] <= trips[i][1]){
                    int[] temp = trips[j];
                    trips[j] = trips[i];
                    trips[i] = temp;
                }
            }
        }

        Integer[] dropOff = new Integer[1001];
        int currentPassengers = 0;
        int currentPosition = 0;

        for (int[] trip : trips) {
            int numPassengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            currentPosition = from;

            // drop off passenger
            for (int i = 0; i < dropOff.length; i++) {
                if(dropOff[i] == null) continue;

                if(i <= currentPosition){
                    currentPassengers -= dropOff[i];
                    dropOff[i] = null;
                }
            }

            if(currentPassengers + numPassengers > capacity){
                return false;
            }

            currentPassengers += numPassengers;
            if(dropOff[to] != null){
                dropOff[to] = dropOff[to] + numPassengers;
            } else {
                dropOff[to] = numPassengers;
            }
        }


        return true;
    }

}
