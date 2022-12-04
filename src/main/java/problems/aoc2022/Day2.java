package problems.aoc2022;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day2 {

    enum Action{
        ROCK(new String[]{"A", "X"}, 1),
        PAPER(new String[]{"B", "Y"}, 2),
        SCISSORS(new String[]{"C", "Z"}, 3),
        ;

        private static Map<Action, Action> beats;
        static {
            beats = new HashMap<>();
            beats.put(ROCK, SCISSORS);
            beats.put(PAPER, ROCK);
            beats.put(SCISSORS, PAPER);
        }
        private String[] identifier;
        private int score;

        Action(String[] identifier, int score) {
            this.identifier = identifier;
            this.score = score;
        }

        public String[] getIdentifier() {
            return identifier;
        }

        public int getScore() {
            return score;
        }

        public boolean match(String i){
            return Arrays.asList(identifier).contains(i);
        }

        public static Action fromIdentifier(String i) {
            for (Action a : values()) {
                if(a.match(i)){
                    return a;
                }
            }

            return null;
        }

        public static Map<Action, Action> getBeats() {
            return beats;
        }
    }

    public int part1(){
        String input = InputHelper.readInput("input2.txt");

        int totalScore = 0;
        for (String move : input.split("\r\n")) {
            String[] s = move.split(" ");
            Action opponent = Action.fromIdentifier(s[0]);
            Action you = Action.fromIdentifier(s[1]);

            if(Action.getBeats().get(you) == opponent){
                totalScore += 6;
            } else if(you == opponent){
                totalScore += 3;
            } else if(Action.getBeats().get(opponent) == you){
                totalScore += 0;
            }

            totalScore += you.getScore();
        }
        
        return totalScore;
    }

    public int part2(){
        String input = InputHelper.readInput("input2.txt");

        int totalScore = 0;
        for (String move : input.split("\r\n")) {
            String[] s = move.split(" ");
            Action opponent = Action.fromIdentifier(s[0]);
            Action you = null;
            switch (s[1]){

                // lose
                case "X" -> you = Action.getBeats().get(opponent);

                // draw
                case "Y" -> you = opponent;

                // win
                case "Z" -> {
                    for (Action action : Action.getBeats().keySet()) {
                        Action beats = Action.getBeats().get(action);
                        if(beats == opponent){
                            you = action;
                            break;
                        }
                    }
                }
            }

            if(Action.getBeats().get(you) == opponent){
                totalScore += 6;
            } else if(you == opponent){
                totalScore += 3;
            } else if(Action.getBeats().get(opponent) == you){
                totalScore += 0;
            }

            totalScore += you.getScore();
        }

        return totalScore;
    }

    public static void main(String[] args) {
        Day2 day2 = new Day2();
        System.out.println("Part1: " + day2.part1());
        System.out.println("Part2: " + day2.part2());
    }

}
