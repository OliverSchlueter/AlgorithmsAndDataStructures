import dataStructures.LinkedList;
import dataStructures.List;

public class Main {

    public static void main(String[] args) {

    }

    public static void linkedListExample(){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.pushEnd("Hello");
        linkedList.pushEnd("World");

        System.out.println(linkedList);
    }

    public static void listExample(){
        List<String> list = new List<>();
        list.pushEnd("Hello");
        list.pushEnd("World");

        System.out.println(list);
    }
}
