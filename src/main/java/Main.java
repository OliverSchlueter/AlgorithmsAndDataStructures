import algorithms.*;
import algorithms.searching.BinarySearch;
import algorithms.searching.BreadthFirstSearch;
import algorithms.searching.DepthFirstSearch;
import algorithms.sorting.BogoSort;
import algorithms.sorting.BubbleSort;
import algorithms.sorting.InsertionSort;
import algorithms.sorting.SelectionSort;
import dataStructures.*;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.ValueLayout;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        // Add '--add-modules jdk.incubator.foreign' to VM options and 'Java Compiler - Additional command line parameters'
        //MemorySegment memorySegment = MemorySegment.allocateNative(100L, ResourceScope.globalScope());
        //memorySegment.fill((byte) '\0');
        //memorySegment.set(ValueLayout.JAVA_INT, 12, 1337);

        graphExample();
    }

    public static void graphExample(){
        GraphNode<String> berlin = new GraphNode<>("Berlin");
        GraphNode<String> leipzig = new GraphNode<>("Leipzig");
        GraphNode<String> hamburg = new GraphNode<>("Hamburg");

        berlin.withEdge(leipzig, 1f);
        berlin.withEdge(hamburg, 1.4f);

        leipzig.withEdge(berlin, 1f);

        hamburg.withEdge(berlin, 1.5f);

        System.out.println(berlin);
    }

    public static void breadthFirstSearch(){
        BinaryTree<Character> binaryTree = new BinaryTree<>('a')
                .setLeft(new BinaryTree<>('b')
                        .setLeft(new BinaryTree<>('d'))
                        .setRight(new BinaryTree<>('e')))
                .setRight(new BinaryTree<>('c')
                        .setLeft(new BinaryTree<>('f')));

        BreadthFirstSearch<Character> breadthFirstSearch = new BreadthFirstSearch<>();
        boolean found = breadthFirstSearch.search('f', binaryTree);
        System.out.println("Found: " + found);
    }

    public static void depthFirstSearch(){
        BinaryTree<Character> binaryTree = new BinaryTree<>('a')
                                                .setLeft(new BinaryTree<>('b')
                                                        .setLeft(new BinaryTree<>('d'))
                                                        .setRight(new BinaryTree<>('e')))
                                                .setRight(new BinaryTree<>('c')
                                                        .setLeft(new BinaryTree<>('f')));

        DepthFirstSearch<Character> depthFirstSearch = new DepthFirstSearch<>();
        boolean found = depthFirstSearch.searchRecursive('e', binaryTree);
        System.out.println("Found: " + found);
    }

    public static void binarySearchExample(){
        java.util.List<Integer> input = new ArrayList<>();
        input.add(2);
        input.add(5);
        input.add(8);
        input.add(13);
        input.add(19);
        input.add(23);

        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.search(13, input);
        System.out.println("index of '13' is: " + result);
    }

    public static void binaryTreeExample(){
        BinaryTree<Integer> binaryTree = new BinaryTree<>(
                1,
                new BinaryTree<>(
                        2,
                        new BinaryTree<>(4),
                        new BinaryTree<>(5)
                ),
                new BinaryTree<>(
                        3,
                        new BinaryTree<>(6),
                        new BinaryTree<>(7)
                )
        );

        System.out.println(binaryTree);
    }

    public static void hashMapExample(){
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Oliver", 42);
        hashMap.put("Peter", 15);
        hashMap.put("Hans", 37);

        hashMap.remove("Peter");

        System.out.println(hashMap);
    }

    public static void arraySpeedTest(){
        final int SIZE = 1000;

        long time = System.nanoTime();
        Integer[] javaArray = new Integer[SIZE];

        for (int i = 0; i < SIZE; i++) {
            javaArray[i] = i * i;
        }

        for (int i = 0; i < SIZE; i++) {
            int a = javaArray[i];
        }

        time = System.nanoTime() - time;

        System.out.println("Java: " + time + "ns");

        time = System.nanoTime();
        Array<Integer> myArray = new Array<>(SIZE);

        for (int i = 0; i < SIZE; i++) {
            myArray.set(i, i * i);
        }

        for (int i = 0; i < SIZE; i++) {
            int a = myArray.get(i);
        }

        time = System.nanoTime() - time;

        System.out.println("My: " + time + "ns");
    }

    public static void arrayExample(){
        Array<String> array = new Array<>(5);
        array.set(0, "1");

        Array<String> array2 = new Array<>(31);
        array2.set(0, "2");

        Array<String> array3 = new Array<>(23);
        array3.set(0, "3");
        array3.set(1, "31");

        System.out.println(Array.memoryDump());
    }

    public static void stackExample(){
        Stack<String> stack = new Stack<>();
        stack.offer("World");
        stack.offer("Hello");

        System.out.println("pop: " + stack.pop());

        System.out.println(stack);
    }

    public static void queueExample(){
        Queue<String> queue = new Queue<>();
        queue.offer("Hello");
        queue.offer("World");

        System.out.println("pop: " + queue.pop());

        System.out.println(queue);
    }

    public static void listExample(){
        List<String> list = new List<>();
        list.pushEnd("Hello");
        list.pushEnd("World");

        System.out.println(list);
    }

    public static void linkedListExample(){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.pushEnd("Hello");
        linkedList.pushEnd("World");

        System.out.println(linkedList);
    }
}
