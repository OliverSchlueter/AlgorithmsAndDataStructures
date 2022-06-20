package dataStructures;

/**
 * Note: not exactly sure if it works this way
 * The MEMORY is a simulation of the actual RAM
 *
 * '\0' means that the cell is reserved
 * null means that the cell is free
 */
public class Array<T> {
    public static Object[] MEMORY = new Object[1024];

    private int size;
    private int startPtr;

    public Array(int size) {
        this.size = size;
        this.startPtr = findPlaceInMemory();

        if(this.startPtr == -1){
            throw new OutOfMemoryError("Could not find enough space in memory");
        }

        for (int i = this.startPtr; i < this.startPtr + this.size; i++) {
            MEMORY[i] = "\0";
        }
    }

    public T get(int i){
        if(i < 0 || i >= size){
            throw new IndexOutOfBoundsException();
        }

        if(MEMORY[startPtr + i] == "\0"){
            return null;
        }

        return (T) MEMORY[startPtr + i];
    }

    public void set(int i, T data){
        if(i < 0 || i >= size){
            throw new IndexOutOfBoundsException();
        }

        MEMORY[startPtr + i] = data;
    }

    public void free(){
        for (int i = startPtr; i < startPtr + size; i++) {
            MEMORY[i] = null;
        }

        size = -1;
        startPtr = -1;
    }

    private int findPlaceInMemory(){

        if(size > MEMORY.length){
            throw new OutOfMemoryError();
        }

        for (int i = 0; i < MEMORY.length; i++) {
            if(MEMORY[i] == null){
                boolean empty = true;
                for (int j = i; j < size; j++) {
                    if(MEMORY[j] != null){
                        empty = false;
                        break;
                    }
                }

                if(empty){
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");

        for (int i = startPtr; i < startPtr + size; i++) {
            if(MEMORY[i] == null || MEMORY[i] == "\0"){
                str.append("null");
            } else {
                str.append(MEMORY[i].toString());
            }

            str.append(", ");
        }

        str = new StringBuilder(str.substring(0, str.length() - 2));

        str.append("]");

        return str.toString();
    }

    public int getSize() {
        return size;
    }

    public int getStartPtr() {
        return startPtr;
    }

    public static String memoryDump(){
        StringBuilder str = new StringBuilder();

        for (int i = 1; i <= MEMORY.length; i++) {
            str.append(MEMORY[i - 1]).append(" ");
            if(i % 8 == 0){
                str.append("\n");
            }
        }

        return str.toString();
    }
}
