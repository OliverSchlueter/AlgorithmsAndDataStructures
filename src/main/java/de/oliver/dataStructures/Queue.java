package de.oliver.dataStructures;

public class Queue<T> extends LinkedList<T>{

    public Queue(){ }

    public Queue(T[] data) {
        super(data);
    }

    public T pop(){
        if(first == null){
            return null;
        }

        LinkedListElement<T> last = first;
        while(last.getNext() != null){
            last = last.getNext();
        }

        LinkedListElement<T> previous = getPreviousOfElement(last);
        if(previous == null){
            first = null;
        } else {
            previous.setNext(null);
        }

        return last.getData();
    }

    public void offer(T data){
        pushEnd(data);
    }

}
