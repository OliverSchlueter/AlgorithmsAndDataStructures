import dataStructures.LinkedList;
import dataStructures.List;
import dataStructures.Queue;
import dataStructures.Stack;

public class Main {

    public static void main(String[] args) {
        stackExample();
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
