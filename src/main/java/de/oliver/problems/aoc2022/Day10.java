package de.oliver.problems.aoc2022;

import java.util.HashMap;
import java.util.Map;

public class Day10 {

    public int part1(){
        String input = InputHelper.readInput("input10.txt");

        String[] lines = input.split("\r\n");

        Map<Integer, Integer> cycles = new HashMap<>();
        int clock = 1;
        int x = 1;

        for (String line : lines) {
            String[] args = line.split(" ");

            switch (args[0].toLowerCase()){
                case "noop" -> {
                    cycles.put(clock, x);
                    clock++;
                }
                case "addx" -> {
                    cycles.put(clock, x);
                    cycles.put(clock+1, x);
                    clock += 2;
                    x += Integer.parseInt(args[1]);
                }
            }

        }

        int totalSignalStrength = 0;

        for (int i = 20; i < cycles.size(); i+=40) {
            int signalStrength = i * cycles.get(i);
            totalSignalStrength += signalStrength;
        }

        return totalSignalStrength;
    }

    public static void main(String[] args) {
        Day10 day10 = new Day10();
        System.out.println("Part1: " + day10.part1());
    }

}
