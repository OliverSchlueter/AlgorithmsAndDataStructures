package de.oliver.problems.aoc2022;

public class Day8 {

    int[][] parseHeights(String input){
        String[] lines = input.split("\r\n");
        int size = lines.length;
        int[][] heights = new int[size][size];

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];

            String[] trees = line.split("");

            for (int j = 0; j < trees.length; j++) {
                heights[j][i] = Integer.parseInt(trees[j]);
            }
        }

        return heights;
    }

    public int part1(){
        String input = InputHelper.readInput("input8.txt");

        int heights[][] = parseHeights(input);

        int result = heights.length * 4 - 4;

        for (int y = 1; y < heights.length-1; y++) {
            for (int x = 1; x < heights.length-1; x++) {
                int current = heights[x][y];

                boolean isVisibleLeft = true;
                boolean isVisibleRight = true;
                boolean isVisibleTop = true;
                boolean isVisibleBottom = true;

                // right
                for (int x1 = x+1; x1 < heights.length; x1++) {
                    if(x1 != x && heights[x1][y] >= current){
                        isVisibleRight = false;
                        break;
                    }
                }

                // left
                for (int x1 = x-1; x1 >= 0; x1--) {
                    if(x1 != x && heights[x1][y] >= current){
                        isVisibleLeft = false;
                        break;
                    }
                }

                // bottom
                for (int y1 = y+1; y1 < heights.length; y1++) {
                    if(y1 != y && heights[x][y1] >= current){
                        isVisibleBottom = false;
                        break;
                    }
                }

                // top
                for (int y1 = y-1; y1 >= 0; y1--) {
                    if(y1 != y && heights[x][y1] >= current){
                        isVisibleTop = false;
                        break;
                    }
                }

                if(isVisibleLeft || isVisibleRight || isVisibleTop || isVisibleBottom){
                    result++;
                }
            }
        }

        return result;
    }

    public int part2(){
        String input = InputHelper.readInput("input8.txt");

        int heights[][] = parseHeights(input);

        int maxScore = 0;

        for (int y = 0; y < heights.length; y++) {
            for (int x = 0; x < heights.length; x++) {
                int current = heights[x][y];

                int scenicScore = 0;

                int distanceRight = 0;
                int distanceLeft = 0;
                int distanceBottom = 0;
                int distanceTop = 0;

                // right
                for (int x1 = x+1; x1 < heights.length; x1++) {
                    distanceRight++;
                    if(x1 != x && heights[x1][y] >= current){
                        break;
                    }
                }

                // left
                for (int x1 = x-1; x1 >= 0; x1--) {
                    distanceLeft++;
                    if(x1 != x && heights[x1][y] >= current){
                        break;
                    }
                }

                // bottom
                for (int y1 = y+1; y1 < heights.length; y1++) {
                    distanceBottom++;
                    if(y1 != y && heights[x][y1] >= current){
                        break;
                    }
                }

                // top
                for (int y1 = y-1; y1 >= 0; y1--) {
                    distanceTop++;
                    if(y1 != y && heights[x][y1] >= current){
                        break;
                    }
                }

                scenicScore = distanceTop * distanceBottom * distanceRight * distanceLeft;

                if(scenicScore > maxScore){
                    maxScore = scenicScore;
                }
            }
        }

        return maxScore;
    }

    public static void main(String[] args) {
        Day8 day8 = new Day8();
        System.out.println("Part1: " + day8.part1());
        System.out.println("Part2: " + day8.part2());
    }

}
