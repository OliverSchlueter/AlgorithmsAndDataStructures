package de.oliver.algorithms.searching;

import de.oliver.algorithms.SearchAlgorithm;
import de.oliver.dataStructures.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<T> implements SearchAlgorithm<BinaryTree<T>, T, Boolean> {

    /**
     * @return true if searched element is found, false if not
     */
    @Override
    public Boolean search(T searched, BinaryTree<T> input) {
        if(input == null){
            return false;
        }

        Queue<BinaryTree<T>> queue = new LinkedList<>();
        queue.offer(input);

        while(!queue.isEmpty()){
            BinaryTree<T> current = queue.poll();

            if(current.getValue() == searched){
                return true;
            }

            if(current.getLeft() != null){
                queue.offer(current.getLeft());
            }

            if(current.getRight() != null){
                queue.offer(current.getRight());
            }

        }

        return false;
    }
}
