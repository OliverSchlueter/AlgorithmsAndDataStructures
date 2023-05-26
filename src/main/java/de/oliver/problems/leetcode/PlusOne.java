package de.oliver.problems.leetcode;

public class PlusOne {

    /*
        https://leetcode.com/problems/plus-one/
     */

    public static int[] plusOne(int[] digits) {

        if(digits.length == 1 && digits[0] == 9){
            return new int[] {1, 0};
        }

        int transfer = 1;

        for(int i = digits.length-1; i >= 0; i--){
            int digit = digits[i];

            if(digit == 9 && transfer == 1){
                digits[i] = 0;
                transfer = 1;
            } else {
                digits[i] = digits[i] + transfer;
                transfer = 0;
            }

        }

        if(transfer == 1){
            int[] newDigits = new int[digits.length + 1];
            for (int i = 1; i < digits.length; i++) {
                newDigits[i] = digits[i];
            }

            newDigits[0] = 1;

            return newDigits;
        }

        return digits;
    }

}
