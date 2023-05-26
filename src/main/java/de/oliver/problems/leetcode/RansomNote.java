package de.oliver.problems.leetcode;

public class RansomNote {

    /*
        https://leetcode.com/problems/ransom-note/
     */

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] magazineChars = magazine.toCharArray();
        char[] ransomNoteChars = ransomNote.toCharArray();

        for(char r : ransomNoteChars){
            boolean found = false;
            for(int i = 0; i < magazineChars.length; i++){
                if(magazineChars[i] != '\0' && r == magazineChars[i]){
                    found = true;
                    magazineChars[i] = '\0';
                    break;
                }
            }

            if(!found){
                return false;
            }

        }

        return true;
    }

}
