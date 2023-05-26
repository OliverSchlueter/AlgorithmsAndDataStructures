package de.oliver.problems.CrackingTheCodingInterview;

import java.util.Arrays;

public class Q1_2 {

    /*
        Check Permutation: Given two strings, write a method to decide if one is a permutation of the
        other.
        Hints: #7, #84, #722, #737
     */

    public static String sort(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static boolean checkPermutation(String s1, String s2){
        if(s1.length() != s2.length()) return false;

        return sort(s1).equals(sort(s2));
    }

    public static void main(String[] args) {
        System.out.println(checkPermutation("abca", "cbaa"));
        System.out.println(checkPermutation("abca", "cbad"));
    }

}
