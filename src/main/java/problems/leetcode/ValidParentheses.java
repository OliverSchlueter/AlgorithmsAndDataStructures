package problems.leetcode;

import java.util.Stack;

public class ValidParentheses {

    /*
        https://leetcode.com/problems/valid-parentheses/
     */

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();

        // uneven length cant be valid because there is either missing an opening or closing parentheses
        if(chars.length % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();

        for (char c : chars) {
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;

                switch (c){
                    case ')' -> { if(stack.pop() != '(') return false; }
                    case ']' -> { if(stack.pop() != '[') return false; }
                    case '}' -> { if(stack.pop() != '{') return false; }
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("([])"));
    }

}
