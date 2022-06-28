import algorithms.*;
import algorithms.sorting.SelectionSort;
import dataStructures.*;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.ValueLayout;


public class Main {

    public static void main(String[] args) {
        // Add '--add-modules jdk.incubator.foreign' to VM options and 'Java Compiler - Additional command line parameters'
        //MemorySegment memorySegment = MemorySegment.allocateNative(100L, ResourceScope.globalScope());
        //memorySegment.fill((byte) '\0');
        //memorySegment.set(ValueLayout.JAVA_INT, 12, 1337);


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
