package problems;

public class Palindrome {

    /*
        Check if a String is a palindrome
     */

    public static boolean isPalindrome(String s){
        char[] chars = s.toCharArray();

        for (int left = 0; left < chars.length; left++) {
            int right = chars.length - 1 - left; // right pointer
            if(chars[left] != chars[right]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("otto"));
        System.out.println(isPalindrome("otto2"));
        System.out.println(isPalindrome("oliver"));
        System.out.println(isPalindrome("abba"));
    }

}
