package dataStructures;

public class LinkedList<T> {
    protected LinkedListElement<T> first;

    public LinkedList(){ }

    public LinkedList(T[] elements){
        for (T element : elements) {
            pushEnd(element);
        }
    }

    public void pushEnd(T data){
        LinkedListElement<T> newEnd = new LinkedListElement<>(data, null);

        if(first == null){
            first = newEnd;
            return;
        }

        LinkedListElement<T> last = first;
        while(last.getNext() != null){
            last = last.getNext();
        }

        last.setNext(newEnd);
    }

    public void pushStart(T data){
        if(first == null){
            first = new LinkedListElement<>(data, null);
        } else {
            first = new LinkedListElement<>(data, first.clone());
        }
    }

    /**
     * Pushes the data after the first match
     */
    public void pushAfter(T data, T after){
        if(first == null){
            first = new LinkedListElement<>(data, null);
            return;
        }

        LinkedListElement<T> afterElement = findElementByData(after);

        if(afterElement == null){
            throw new NullPointerException("Could not find matching element with data: '" + after + "'");
        }

        afterElement.setNext(new LinkedListElement<>(data, afterElement.getNext()));
    }

    /**
     * Pushes the data before the first match
     */
    public void pushBefore(T data, T before){
        if(first == null){
            first = new LinkedListElement<>(data, null);
            return;
        }

        LinkedListElement<T> beforeElement = findElementByData(before);

        if(beforeElement == null){
            throw new NullPointerException("Could not find matching element with data: '" + before + "'");
        }

        LinkedListElement<T> previous = getPreviousOfElement(beforeElement);

        if(previous == null){
            first = new LinkedListElement<>(data, beforeElement);
        } else {
            previous.setNext(new LinkedListElement<>(data, beforeElement));
        }
    }

    /**
     * @return the i'th element of the chain
     */
    public LinkedListElement<T> getElement(int i){
        if(i < 0){
            throw new IndexOutOfBoundsException("Can not access at negative index");
        }

        if(i == 0){
            return first;
        }

        LinkedListElement<T> current = first;
        while(current.getNext() != null){
            if(i == 0){
                return current;
            } else {
                i--;
            }
            current = current.getNext();
        }

        if(i == 0){
            return current;
        } else {
            return null;
        }
    }

    /**
     * @return the data of the i'th element
     */
    public T get(int i){
        return getElement(i).getData();
    }

    /**
     * set the data of the i'th
     */
    public void set(T data, int i){
        if(i < 0){
            throw new IndexOutOfBoundsException("Can not access at negative index");
        }

        if(i == 0){
            first = new LinkedListElement<>(data, first == null ? null : first.getNext());
        }
        getElement(i).setData(data);
    }

    /**
     * replaces the first match with the new replacement
     */
    public void replace(T search, T replacement){
        LinkedListElement<T> element = findElementByData(search);

        if(element == null){
            throw new NullPointerException("Could not find matching element with data: '" + search + "'");
        }

        element.setData(replacement);

    }

    public void clear(){
        first = null;
    }

    public LinkedListElement<T> findElementByData(T data){
        if(first == null){
            return null;
        }

        LinkedListElement<T> current = first;
        while(current.getNext() != null){
            if(current.getData().equals(data)){
                return current;
            }
            current = current.getNext();
        }

        if(current.getData().equals(data)){
            return current;
        }

        return null;
    }

    public LinkedListElement<T> getPreviousOfElement(LinkedListElement<T> element){
        LinkedListElement<T> current = first;
        while(current.getNext() != null){
            if(current.getNext().equals(element)){
                return current;
            }
            current = current.getNext();
        }

        return null;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");

        if(first == null){
            str.append("]");
            return str.toString();
        }

        LinkedListElement<T> current = first;

        str.append(first.getData().toString()).append(" -> ");

        while(current.getNext() != null){
            current = current.getNext();
            str.append(current.getData().toString()).append(" -> ");
        }

        str = new StringBuilder(str.substring(0, str.length() - 4));

        str.append("]");

        return str.toString();
    }

    public LinkedListElement<T> getFirst() {
        return first;
    }
}
