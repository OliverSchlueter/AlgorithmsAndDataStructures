package de.oliver.dataStructures;

public class Stack<T> extends LinkedList<T>{

    public Stack(){ }

    public Stack(T[] data){
        super(data);
    }

    public T pop(){
        if(first == null){
            return null;
        }

        T data = first.getData();

        if(first.getNext() != null){
            first = first.getNext();
        } else {
            first = null;
        }

        return data;
    }

    public void offer(T data){
        pushStart(data);
    }

}
