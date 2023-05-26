package de.oliver.dataStructures;

import java.util.NoSuchElementException;

public class List<T> {
    protected static final int DEFAULT_ARRAY_SIZE = 20;
    protected static final float RESIZE_FACTOR = 1.5f;

    protected Array<T> dataArray;
    protected int size;

    public List() {
        this.dataArray = new Array<>(DEFAULT_ARRAY_SIZE);
    }
    
    public List(Array<T> data){
        this.dataArray = data;
        this.size = data.getSize();
    }
    
    public void pushEnd(T data){
        if(size + 1 > dataArray.getSize()){
            growArray();
        }

        dataArray.set(size, data);
        size++;
    }

    public void pushStart(T data){
        if(size + 1 > dataArray.getSize()){
            growArray();
        }

        // Shift array right
        for(int i = size - 1; i >= 0; i--){
            dataArray.set(i + 1, dataArray.get(i));
        }

        dataArray.set(0, data);
        size++;
    }
    
    public void pushBefore(int i, T data){
        if(i < 0 || i > size){
            throw new IndexOutOfBoundsException();
        }

        if(i == 0){
            pushStart(data);
            return;
        }

        if(i == size){
            pushEnd(data);
            return;
        }

        if(size + 1 > dataArray.getSize()){
            growArray();
        }

        for(int j = size - 1; j >= i-1; j--){
            dataArray.set(j + 1, dataArray.get(j));
        }

        set(i, data);
        size++;
    }
    
    public void pushAfter(int i, T data){
        if(i < -1 || i >= size){
            throw new IndexOutOfBoundsException();
        }

        if(size + 1 > dataArray.getSize()){
            growArray();
        }

        if(i == -1){
            pushStart(data);
            return;
        }

        if(i == size-1){
            pushEnd(data);
            return;
        }

        for(int j = size - 1; j >= i+1; j--){
            dataArray.set(j + 1, dataArray.get(j));
        }

        set(i + 1, data);
        size++;
    }

    public void removeAtIndex(int i){
        if(i < 0 || i >= size){
            throw new IndexOutOfBoundsException();
        }

        for(int j = i + 1; j < size; j++){
            dataArray.set(j - 1, dataArray.get(j));
        }

        size--;

        float potentialNewSize = dataArray.getSize() / RESIZE_FACTOR;
        if(potentialNewSize > size && potentialNewSize > DEFAULT_ARRAY_SIZE){
            shrinkArray();
        }
    }

    public void remove(T data){
        int i = indexOf(data);
        removeAtIndex(i);
    }

    public void clear(){
        dataArray = new Array<>(DEFAULT_ARRAY_SIZE);
        size = 0;
    }

    public void set(int i, T data){
        if(i < 0 || i >= size){
            throw new IndexOutOfBoundsException();
        }

        dataArray.set(i, data);
    }

    public T get(int i){
        if(i < 0 || i >= size){
            throw new IndexOutOfBoundsException();
        }

        return dataArray.get(i);
    }

    public int indexOf(T data){
        for (int i = 0; i < size; i++) {
            if(dataArray.get(i).equals(data)){
                return i;
            }
        }

        throw new NoSuchElementException();
    }

    public boolean contains(T data){
        for (int i = 0; i < size; i++) {
            if(dataArray.get(i).equals(data)){
                return true;
            }
        }

        return false;
    }

    public List<T> subList(int start, int end){
        if(end < start){
            throw new RuntimeException("End-index can not be lower than start-index");
        }

        if(start < 0 || start >= size || end >= size){
            throw new IndexOutOfBoundsException();
        }

        List<T> subList = new List<>();
        for (int i = start; i <= end; i++) {
            subList.pushEnd(dataArray.get(i));
        }

        return subList;
    }

    private void growArray(){
        Array<T> newArray = new Array<>((int)(dataArray.getSize() * RESIZE_FACTOR));
        for (int i = 0; i < size; i++) {
            newArray.set(i, dataArray.get(i));
        }

        dataArray = newArray;
    }

    private void shrinkArray(){
        Array<T> newArray = new Array<>((int)(dataArray.getSize() / RESIZE_FACTOR));
        for (int i = 0; i < size; i++) {
            newArray.set(i, dataArray.get(i));
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
            str.append(dataArray.get(i).toString() + ", ");
        }

        str = new StringBuilder(str.substring(0, str.length() - 2));

        str.append("]");

        return str.toString();
    }

    public Array<T> getDataArray() {
        return dataArray;
    }

    public int getSize() {
        return size;
    }
}
