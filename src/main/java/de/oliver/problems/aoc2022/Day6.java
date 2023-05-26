package de.oliver.problems.aoc2022;

public class Day6 {

    public boolean checkIfCharsAreDifferent(char ... c){
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                if(c[i] == c[j] && i != j){
                    return false;
                }
            }
        }

        /*Set<Character> set = new HashSet<>();

        for (char c1 : c) {
            if(!set.add(c1)){
                return false;
            }
        }*/

        return true;
    }

    public int part1(){
        String input = InputHelper.readInput("input6.txt");
        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length-4-1; i++) {
            char[] window = new char[4];

            for (int j = 0; j < 4; j++) {
                window[j] = chars[i+j];
            }
            if(checkIfCharsAreDifferent(window)){
                return i+4;
            }
        }

        return -1;
    }

    public int part2(){
        String input = InputHelper.readInput("input6.txt");
        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length-14-1; i++) {
            char[] window = new char[14];

            for (int j = 0; j < 14; j++) {
                window[j] = chars[i+j];
            }

            if(checkIfCharsAreDifferent(window)){
                return i+14;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Day6 day6 = new Day6();
        System.out.println("Part1: " + day6.part1());
        System.out.println("Part2: " + day6.part2());
    }

}
