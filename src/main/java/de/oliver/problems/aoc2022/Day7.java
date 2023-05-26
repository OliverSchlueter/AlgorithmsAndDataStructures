package de.oliver.problems.aoc2022;

import java.util.*;

public class Day7 {

    public File parseInput(String input){
        File root = new File("/", 0, true, new ArrayList<>(), null);
        File current = root;

        String[] lines = input.split("\r\n");

        // skip first line because it is always starting with "cd /"
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] args = line.split(" ");

            if(args[0].equals("$")){
                // is command

                if(args[1].equals("cd")){
                    // cd command

                    String dirName = args[2];
                    File dir = current.cd(dirName);

                    if(dir != null){
                        current = dir;
                    }

                } else if(args[1].equals("ls")){
                    // ls command

                    for (int j = i+1; j < lines.length; j++) {
                        if(lines[j].startsWith("$")){
                            break;
                        } else if(lines[j].startsWith("dir")){
                            File dir = new File(lines[j].substring(4), 0, true, new ArrayList<>(), current);
                            current.addFile(dir);
                            i++;
                        } else {
                            String[] split = lines[j].split(" ");
                            File file = new File(split[1],Long.parseLong(split[0]), false, new ArrayList<>(), current);
                            current.addFile(file);
                            i++;
                        }
                    }
                }
            }
        }

        return root;
    }

    public long part1(){
        String input = InputHelper.readInput("input7.txt");

        File root = parseInput(input);

        long size = 0;

        Stack<File> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            File c = stack.pop();

            if(c.isDirectory() && c.getSize() <= 100000){
                size += c.getSize();
            }

            for (File f : c.getFiles()) {
                stack.push(f);
            }

        }

        return size;
    }

    public long part2(){
        String input = InputHelper.readInput("input7.txt");

        File root = parseInput(input);

        final long diskSpace = 70_000_000;
        long neededSpace = 30_000_000;
        long unusedSpace = diskSpace - root.getSize();
        neededSpace = neededSpace - unusedSpace;


        List<File> candidates = new ArrayList<>();

        Stack<File> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            File c = stack.pop();

            if(c.isDirectory() && c.getSize() >= neededSpace){
                candidates.add(c);
            }

            for (File f : c.getFiles()) {
                stack.push(f);
            }

        }

        return candidates
                .stream()
                .mapToLong(File::getSize)
                .sorted()
                .findFirst()
                .getAsLong();
    }

    public static void main(String[] args) {
        Day7 day7 = new Day7();
        System.out.println("Part1: " + day7.part1());
        System.out.println("Part2: " + day7.part2());
    }

}

class File{
    private final String name;
    private long size;
    private final boolean isDirectory;
    private final File parent;
    private List<File> files;

    public File(String name, long size, boolean isDirectory, List<File> files, File parent) {
        this.name = name;
        this.size = size;
        this.isDirectory = isDirectory;
        this.files = files;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        if(!isDirectory){
            return size;
        }

        long s = 0;

        Queue<File> queue = new LinkedList<>();
        queue.offer(this);

        while(!queue.isEmpty()){
            File current = queue.poll();

            if(!current.isDirectory()){
                s += current.getSize();
            }

            for (File f : current.getFiles()) {
                queue.offer(f);
            }

        }

        return s;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    public File getParent() {
        return parent;
    }

    public List<File> getFiles() {
        return files;
    }

    public void addFile(File file){
        files.add(file);
    }

    public File cd(String dir){
        if(dir.equals("..")){
            return parent;
        }

        for (File file : files) {
            if(file.isDirectory() && file.getName().equals(dir)){
                return file;
            }
        }

        return null;
    }
}