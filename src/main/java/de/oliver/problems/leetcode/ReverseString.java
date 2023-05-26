package de.oliver.problems.leetcode;

public class ReverseString {

    /*
     * https://leetcode.com/problems/reverse-string/
     */

    public void reverseString(char[] s) {
        if(s.length == 1)
            return;

        for (int i = 0; i < s.length/2f; i++) {
            char current = s[i];
            char swap = s[s.length - 1 - i];

            s[i] = swap;
            s[s.length  -1 - i] = current;
        }
    }

    public static void main(String[] args) {
        new ReverseString().reverseString(new char[] {'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'});
    }

}
