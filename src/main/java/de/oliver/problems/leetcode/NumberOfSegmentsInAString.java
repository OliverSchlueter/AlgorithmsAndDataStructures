package de.oliver.problems.leetcode;

public class NumberOfSegmentsInAString {

    /*
        https://leetcode.com/problems/number-of-segments-in-a-string/
     */

    public int countSegments(String s){
        if(s.length() == 0){
            return 0;
        }

        int segments = 0;

        char[] chars = s.toCharArray();
        boolean lastWasSpace = true;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if(c != ' ' && lastWasSpace){
                segments++;
                lastWasSpace = false;
            } else if(c == ' '){
                lastWasSpace = true;
            }
        }

        return segments;
    }

}
