import dataStructures.*;

public class Main {

    public static void main(String[] args) {
        arrayExample();
    }

    public static void arrayExample(){
        Array<String> array = new Array<>(5);
        array.set(0, "1");

        Array<String> array2 = new Array<>(31);
        array2.set(0, "2");
        array2.free();

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
