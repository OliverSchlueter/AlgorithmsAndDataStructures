package problems.leetcode;

import java.util.ArrayList;
import java.util.List;

public class DestinationCity {

    /*
        https://leetcode.com/problems/destination-city/
     */

    public String destCity(List<List<String>> paths) {
        List<String> possible = new ArrayList<>();

        for(List<String> path : paths){
            String b = path.get(1);
            possible.add(b);
        }

        for(List<String> path : paths){
            String a = path.get(0);
            String b = path.get(1);

            if(possible.contains(a)){
                possible.remove(a);
            }
        }


        return possible.get(0);
    }

}
