package de.oliver.problems.CrackingTheCodingInterview;

public class Q1_1 {

        /*
            Is Unique: Implement an algorithm to determine if a string has all uniq ue characters. Whatif you
            cannot use additional data structures?
            Hints: #44, #7 7 7, #732
         */

        public static boolean isUnique(String input){
            char[] seen = new char[input.length()];

            for (char c : input.toCharArray()) {
                for (char s : seen) {
                    if(c == s){
                        return false;
                    }
                }

                seen[seen.length-1] = c;
            }

            return true;
        }

    public static void main(String[] args) {
        System.out.println(isUnique("oliver"));
        System.out.println(isUnique("hello world"));
    }


}
