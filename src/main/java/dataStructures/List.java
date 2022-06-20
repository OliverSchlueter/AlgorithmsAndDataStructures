package dataStructures;

import java.util.NoSuchElementException;

public class List<T> {
    private static final int DEFAULT_ARRAY_SIZE = 20;
    private static final float RESIZE_FACTOR = 1.5f;

    private Object[] dataArray;
    private int size;

    public List() {
        this.dataArray = new Object[DEFAULT_ARRAY_SIZE];
    }
    
    public List(T[] data){
        this.dataArray = data;
        this.size = data.length;
    }
    
    public void pushEnd(T data){
        if(size + 1 > dataArray.length){
            growArray();
        }

        dataArray[size] = data;
        size++;
    }

    public void pushStart(T data){
        if(size + 1 > dataArray.length){
            growArray();
        }

        // Shift array right
        for(int i = size - 1; i >= 0; i--){
            dataArray[i + 1] = dataArray[i];
        }

        dataArray[0] = data;
        size++;
    }

    public void removeAtIndex(int i){
        if(i < 0 || i >= size){
            throw new IndexOutOfBoundsException();
        }

        for(int j = i + 1; j < size; j++){
            dataArray[j - 1] = dataArray[j];
        }

        size--;

        float potentialNewSize = dataArray.length / RESIZE_FACTOR;
        if(potentialNewSize > size && potentialNewSize > DEFAULT_ARRAY_SIZE){
            shrinkArray();
        }
    }

    public void remove(T data){
        int i = indexOf(data);
        removeAtIndex(i);
    }

    public void clear(){
        dataArray = new Object[DEFAULT_ARRAY_SIZE];
        size = 0;
    }

    public void set(int i, T data){
        if(i < 0 || i >= size){
            throw new IndexOutOfBoundsException();
        }

        dataArray[i] = data;
    }

    public T get(int i){
        if(i < 0 || i >= size){
            throw new IndexOutOfBoundsException();
        }

        return (T) dataArray[i];
    }

    public int indexOf(T data){
        for (int i = 0; i < size; i++) {
            if(dataArray[i].equals(data)){
                return i;
            }
        }

        throw new NoSuchElementException();
    }

    public boolean contains(T data){
        for (int i = 0; i < size; i++) {
            if(dataArray[i].equals(data)){
                return true;
            }
        }

        return false;
    }

    private void growArray(){
        Object[] newArray = new Object[(int)(dataArray.length * RESIZE_FACTOR)];
        for (int i = 0; i < size; i++) {
            newArray[i] = dataArray[i];
        }

        dataArray = newArray;
    }

    private void shrinkArray(){
        Object[] newArray = new Object[(int)(dataArray.length / RESIZE_FACTOR)];
        for (int i = 0; i < size; i++) {
            newArray[i] = dataArray[i];
        }

        dataArray = newArray;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");

        if(size == 0){
            return str.append("]").toString();
        }

        for (int i = 0; i < size; i++) {
            str.append(dataArray[i].toString() + ", ");
        }

        str = new StringBuilder(str.substring(0, str.length() - 2));

        str.append("]");

        return str.toString();
    }

    public Object[] getDataArray() {
        return dataArray;
    }

    public int getSize() {
        return size;
    }
}
