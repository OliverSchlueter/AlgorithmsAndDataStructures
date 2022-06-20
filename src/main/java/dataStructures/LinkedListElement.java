package dataStructures;

public class LinkedListElement<T> {
    private T data;
    private LinkedListElement<T> next;

    public LinkedListElement(T data, LinkedListElement<T> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "LinkedListElement{\n" +
                "data=" + data + "\n" +
                "next=" + next + "\n" +
                '}';
    }

    public LinkedListElement<T> clone() {
        return new LinkedListElement<T>(this.data, this.next);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkedListElement<T> getNext() {
        return next;
    }

    public void setNext(LinkedListElement<T> next) {
        this.next = next;
    }
}
