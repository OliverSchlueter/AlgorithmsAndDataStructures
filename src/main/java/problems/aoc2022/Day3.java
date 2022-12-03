package problems.aoc2022;

public class Day3 {

    public int Part1(){
        String input = InputHelper.readInput("input3.txt");

        int sum = 0;
        for (String line : input.split("\r\n")) {
            String left = line.substring(0, line.length()/2);
            String right = line.substring(line.length()/2, line.length());

            for (char c : left.toCharArray()) {
                if(right.contains(String.valueOf(c))){
                    sum += Character.getNumericValue(c)-9;
                    if(Character.isUpperCase(c)){
                        sum += 26;
                    }
                    break;
                }
            }
        }

        return sum;
    }

    public int Part2(){
        String input = InputHelper.readInput("input3.txt");

        int sum = 0;

        String[] lines = input.split("\r\n");

        for (int i = 0; i < lines.length; i+=3) {
            String line1 = lines[i + 0];
            String line2 = lines[i + 1];
            String line3 = lines[i + 2];

            for (char c : line1.toCharArray()) {
                if(line2.contains(String.valueOf(c)) && line3.contains(String.valueOf(c))){
                    sum += Character.getNumericValue(c)-9;
                    if(Character.isUpperCase(c)){
                        sum += 26;
                    }
                    break;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Day3 day3 = new Day3();
        System.out.println(day3.Part2());
    }

}
