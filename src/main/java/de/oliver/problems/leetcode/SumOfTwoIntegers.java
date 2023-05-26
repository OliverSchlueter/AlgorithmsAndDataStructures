package de.oliver.problems.leetcode;

public class SumOfTwoIntegers {

    /*
        https://leetcode.com/problems/sum-of-two-integers/
     */

    public int getSum(int a, int b) {
        while(b != 0){
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }

    public static void main(String[] args) {
        System.out.println(new SumOfTwoIntegers().getSum(20, 22));
    }

}
