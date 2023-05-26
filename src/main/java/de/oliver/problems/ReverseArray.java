package de.oliver.problems;

import de.oliver.dataStructures.Array;

public class ReverseArray {

    /*
        Reverse an array

        [3, 5, 7, 6] -> [6, 7, 5, 3]
     */

    public static Array<Object> reverse(Array<Object> input){

        Array<Object> result = new Array<>(input.getSize());

        int j = 0;
        for (int i = input.getSize() - 1; i >= 0; i--) {
            result.set(j, input.get(i));
            j++;
        }

        return result;
    }

    public static void main(String[] args) {
        Array<Object> array = new Array<>(3);
        array.set(0, "Hello");
        array.set(1, "World");
        array.set(2, "!");

        Array<Object> reversed = reverse(array);

        System.out.println(array);
        System.out.println(reversed);
    }

}
