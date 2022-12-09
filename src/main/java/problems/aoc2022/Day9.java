package problems.aoc2022;

import java.util.HashMap;
import java.util.Map;

public class Day9 {

    enum Direction{
        UP,
        DOWN,
        RIGHT,
        LEFT
    }

    class Rope{
        private int xH;
        private int yH;
        private int xT;
        private int yT;
        private Map<String, Integer> visited; // "x:y" -> amount

        public Rope() {
            this.xH = 0;
            this.yH = 0;
            this.xT = 0;
            this.yT = 0;
            this.visited = new HashMap<>();
        }

        public void moveHead(Direction direction){

            switch (direction){
                case UP -> yH++;
                case DOWN -> yH--;
                case RIGHT -> xH++;
                case LEFT -> xH--;
            }

            if(isTouching()){
                return;
            }

            if(direction == Direction.RIGHT && yH == yT){
                moveTail(Direction.RIGHT);
            } else if(direction == Direction.LEFT && yH == yT){
                moveTail(Direction.LEFT);
            } else if(direction == Direction.UP && xH == xT){
                moveTail(Direction.UP);
            } else if(direction == Direction.DOWN && xH == xT) {
                moveTail(Direction.DOWN);
            }

            int dx = Math.abs(xT - xH);
            int dy = Math.abs(yT - yH);

            if(direction == Direction.RIGHT && dx > 1){
                moveTail(Direction.RIGHT);
            } else if(direction == Direction.LEFT && dx > 1){
                moveTail(Direction.LEFT);
            }

            if(direction == Direction.UP && dy > 1){
                moveTail(Direction.UP);
            } else if(direction == Direction.DOWN && dy > 1){
                moveTail(Direction.DOWN);
            }

            System.out.println("dx " + dx);
            System.out.println("dy " + dy);
        }

        public void moveTail(Direction direction){
            switch (direction){
                case UP -> yT++;
                case DOWN -> yT--;
                case RIGHT -> xT++;
                case LEFT -> xT--;
            }

            String pos = xT + ":" + yT;

            if(visited.containsKey(pos)){
                visited.put(pos, visited.get(pos) + 1);
            } else {
                visited.put(pos, 1);
            }
        }

        private boolean isTouching(){
            if(xH == xT && yH == yT){
                return true;
            }

            return false;
        }

        public Map<String, Integer> getVisited() {
            return visited;
        }
    }

    public int part1(){
        String input = InputHelper.readInput("input9.txt");
        String[] lines = input.split("\r\n");

        Rope rope = new Rope();

        for (String line : lines) {
            String[] split = line.split(" ");

            Direction direction = null;

            switch (split[0]) {
                case "R" -> direction = Direction.RIGHT;
                case "L" -> direction = Direction.LEFT;
                case "U" -> direction = Direction.UP;
                case "D" -> direction = Direction.DOWN;
            }

            int amount = Integer.parseInt(split[1]);

            for (int i = 0; i < amount; i++) {
                rope.moveHead(direction);
            }

        }

        return rope.getVisited().size();
    }

    public int part2(){
        String input = InputHelper.readInput("input9.txt");



        return -1;
    }


    public static void main(String[] args) {


        // https://adventofcode.com/2022/day/9

        // TODO: fix

        Day9 day9 = new Day9();
        System.out.println("Part1: " + day9.part1());
        System.out.println("Part2: " + day9.part2());
    }

}
