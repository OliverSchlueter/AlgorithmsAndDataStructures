package de.oliver.problems.aoc2022;

public class Day4 {

    public int part1(){
        String input = InputHelper.readInput("input4.txt");

        int n = 0;

        for (String line : input.split("\r\n")) {
            String[] ranges = line.split(",");
            String[] range1 = ranges[0].split("-");
            String[] range2 = ranges[1].split("-");

            int x1 = Integer.parseInt(range1[0]);
            int y1 = Integer.parseInt(range1[1]);
            int x2 = Integer.parseInt(range2[0]);
            int y2 = Integer.parseInt(range2[1]);

            if(x1 <= x2 && y2 <= y1 || x2 <= x1 && y1 <= y2){
                n++;
            }

        }

        return n;
    }

    public int part2(){
        String input = InputHelper.readInput("input4.txt");

        int n = 0;

        for (String line : input.split("\r\n")) {
            String[] ranges = line.split(",");
            String[] range1 = ranges[0].split("-");
            String[] range2 = ranges[1].split("-");

            int x1 = Integer.parseInt(range1[0]);
            int y1 = Integer.parseInt(range1[1]);
            int x2 = Integer.parseInt(range2[0]);
            int y2 = Integer.parseInt(range2[1]);

            if(!(y1 < x2 || x1 > y2)){
                n++;
            }

        }

        return n;
    }

    public static void main(String[] args) {
        Day4 day4 = new Day4();
        System.out.println("Part1: " + day4.part1());
        System.out.println("Part2: " + day4.part2());
    }

}
