package problems.leetcode;

import java.util.HashMap;

public class ValidAnagram {

    /*
        https://leetcode.com/problems/valid-anagram/
     */

    public boolean isAnagram(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        if(sc.length != tc.length) return false;

        HashMap<Character, Integer> chars = new HashMap<>();

        for (char c : sc) {
            if(chars.containsKey(c)){
                chars.put(c, chars.get(c) + 1);
            } else {
                chars.put(c, 1);
            }
        }

        for (char c : tc) {
            if(chars.containsKey(c)){
                if(chars.get(c) == 1){
                    chars.remove(c);
                } else {
                    chars.put(c, chars.get(c) - 1);
                }
            } else {
                return false;
            }
        }

        return chars.isEmpty();
    }
}
