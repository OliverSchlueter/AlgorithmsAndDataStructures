package problems.leetcode;

import java.util.Stack;

public class ReverseVowelsOfString {

    /*
        https://leetcode.com/problems/reverse-vowels-of-a-string/
     */

    public String reverseVowels(String s) {

        Stack<Character> vowels = new Stack<>();

        char[] chars = s.toCharArray();

        for (char c : chars) {
            if(isVowel(c)){
                vowels.push(c);
            }
        }

        for (int i = 0; i < chars.length; i++) {
            if(isVowel(chars[i])){
                chars[i] = vowels.pop();
            }
        }

        return new String(chars);
    }

    public boolean isVowel(char c){
        return
                c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'
                ;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseVowelsOfString().reverseVowels("leetcode"));
    }

}
