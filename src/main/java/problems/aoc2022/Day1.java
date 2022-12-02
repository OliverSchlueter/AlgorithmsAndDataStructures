package problems.aoc2022;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Day1 {

    public int Part1() throws IOException {
        String input = InputHelper.readInput("input1.txt");

        int max = 0;
        for (String elfs : input.split("\r\n\r\n")) {
            int n = 0;
            for (String cal : elfs.split("\r\n")) {
                n += Integer.parseInt(cal);
            }

            if(n > max){
                max = n;
            }
        }

        return max;
    }

    public int Part2(){
        String input = InputHelper.readInput("input1.txt");

        List<Integer> topElfs = new ArrayList<>();

        for (String elfs : input.split("\r\n\r\n")) {
            int n = 0;
            for (String cal : elfs.split("\r\n")) {
                n += Integer.parseInt(cal);
            }

            topElfs.add(n);
        }

        return topElfs
                .stream()
                .mapToInt(Integer::intValue)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static void main(String[] args) {
        Day1 day1 = new Day1();
        try {
            System.out.println("Part1: " + day1.Part1());
            System.out.println("Part2: " + day1.Part2());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
