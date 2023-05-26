package de.oliver.problems.leetcode;

public class ValidPerfectSquare {

    /*
        https://leetcode.com/problems/valid-perfect-square/
     */

    public boolean isPerfectSquare(int num) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            long n = (long) i * i;

            if(n > Integer.MAX_VALUE || n > num){
                return false;
            }

            if(n == num){
                return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPerfectSquare().isPerfectSquare(Integer.MAX_VALUE-1));
    }

}
