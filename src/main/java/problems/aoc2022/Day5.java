package problems.aoc2022;


import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Day5 {

    public String part1(){
        String input = InputHelper.readInput("input5.txt");

        List<String> lines = input.lines().toList();

        int amountCrates = 0;
        int numberLineIndex = -1;

        // parse amount of crates
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);

            if(line.startsWith(" 1")){
                char[] chars = line.toCharArray();
                amountCrates = Integer.parseInt(String.valueOf(chars[chars.length-2]));
                numberLineIndex = i;
                break;
            }
        }

        Stack<Character>[] crates = new Stack[amountCrates];
        for (int i = 0; i < amountCrates; i++) {
            crates[i] = new Stack<>();
        }

        // parse stacks
        for (int i = numberLineIndex - 1; i >= 0; i--) {
            String line = lines.get(i);

            char[] chars = line.toCharArray();

            if(chars[1] != ' ') {
                crates[0].push(chars[1]);
            }

            for (int j = 1; j < amountCrates; j++) {
                int index = 1 + (j * 4);

                if(index > chars.length - 1){
                    break;
                }

                if(chars[index] != ' ') {
                    crates[j].push(chars[index]);
                }
            }
        }

        // instructions
        for (int i = numberLineIndex + 2; i < lines.size(); i++) {
            String line = lines.get(i);
            line = line.replace("move ", "").replace("from ", "").replace("to ", "");

            String[] split = line.split(" ");
            int amount = Integer.parseInt(split[0]);
            int from = Integer.parseInt(split[1]) - 1;
            int to = Integer.parseInt(split[2]) - 1;

            for (int j = 0; j < amount; j++) {
                crates[to].push(crates[from].pop());
            }
        }

        // pop top items

        String result = "";
        for (int i = 0; i < crates.length; i++) {
            Stack<Character> stack = crates[i];

            result += stack.pop();
        }

        return result;
    }

    public String part2(){
        String input = InputHelper.readInput("input5.txt");

        List<String> lines = input.lines().toList();

        int amountCrates = 0;
        int numberLineIndex = -1;

        // parse amount of crates
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);

            if(line.startsWith(" 1")){
                char[] chars = line.toCharArray();
                amountCrates = Integer.parseInt(String.valueOf(chars[chars.length-2]));
                numberLineIndex = i;
                break;
            }
        }

        Stack<Character>[] crates = new Stack[amountCrates];
        for (int i = 0; i < amountCrates; i++) {
            crates[i] = new Stack<>();
        }

        // parse stacks
        for (int i = numberLineIndex - 1; i >= 0; i--) {
            String line = lines.get(i);

            char[] chars = line.toCharArray();

            if(chars[1] != ' ') {
                crates[0].push(chars[1]);
            }

            for (int j = 1; j < amountCrates; j++) {
                int index = 1 + (j * 4);

                if(index > chars.length - 1){
                    break;
                }

                if(chars[index] != ' ') {
                    crates[j].push(chars[index]);
                }
            }
        }

        // instructions
        for (int i = numberLineIndex + 2; i < lines.size(); i++) {
            String line = lines.get(i);
            line = line.replace("move ", "").replace("from ", "").replace("to ", "");

            String[] split = line.split(" ");
            int amount = Integer.parseInt(split[0]);
            int from = Integer.parseInt(split[1]) - 1;
            int to = Integer.parseInt(split[2]) - 1;

            Character[] toMove = new Character[amount];

            for (int j = 0; j < amount; j++) {
                toMove[amount-j-1] = crates[from].pop();
            }

            crates[to].addAll(List.of(toMove));
        }

        // pop top items

        String result = "";
        for (int i = 0; i < crates.length; i++) {
            Stack<Character> stack = crates[i];

            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        Day5 day5 = new Day5();
        System.out.println("Part1: " + day5.part1());
        System.out.println("Part2: " + day5.part2());
    }

}