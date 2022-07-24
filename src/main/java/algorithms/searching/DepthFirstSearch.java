package algorithms.searching;

import algorithms.SearchAlgorithm;
import dataStructures.BinaryTree;
import dataStructures.Stack;


public class DepthFirstSearch<T> implements SearchAlgorithm<BinaryTree<T>, T, Boolean> {

    /**
     * @return true if found, false if not found
     */
    @Override
    public Boolean search(T searched, BinaryTree<T> input) {
        if(input == null){
            return false;
        }

        Stack<BinaryTree<T>> stack = new Stack<>();

        stack.offer(input);

        while(stack.getFirst() != null){
            BinaryTree<T> current = stack.pop();

            if(current.getValue() == searched){
                return true;
            }

            if(current.getRight() != null){
                stack.offer(current.getRight());
            }

            if(current.getLeft() != null){
                stack.offer(current.getLeft());
            }
        }

        return false;
    }

    /**
     * @return true if found, false if not found
     */
    public Boolean searchRecursive(T searched, BinaryTree<T> input){
        if(input == null){
            return false;
        }

        if(input.getValue() == searched) return true;

        boolean left = searchRecursive(searched, input.getLeft());
        boolean right = searchRecursive(searched, input.getRight());

        return left | right;
    }
}
