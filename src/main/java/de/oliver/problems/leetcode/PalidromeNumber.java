package de.oliver.problems.leetcode;

public class PalidromeNumber {

    /*
        https://leetcode.com/problems/palindrome-number/
     */

    public boolean isPalindrome(int x) {
        String s = x + "";
        char[] chars = s.toCharArray();

        for(int left = 0; left < (int)(chars.length / 2); left++){
            int right = chars.length - 1 - left;

            if(chars[left] != chars[right]){
                return false;
            }

        }

        return true;

    }

}
