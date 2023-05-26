package de.oliver.dataStructures;

public class BinaryTree<T> {

    private T value;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public BinaryTree(T value, BinaryTree<T> left, BinaryTree<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BinaryTree(T value){
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public T getValue() {
        return value;
    }

    public BinaryTree<T> setValue(T value) {
        this.value = value;
        return this;
    }

    public BinaryTree<T> getLeft() {
        return left;
    }

    public BinaryTree<T> setLeft(BinaryTree<T> left) {
        this.left = left;
        return this;
    }

    public BinaryTree<T> getRight() {
        return right;
    }

    public BinaryTree<T> setRight(BinaryTree<T> right) {
        this.right = right;
        return this;
    }

    @Override
    public String toString() {
        String str = "";

        str += value;
        if(left != null) {
            str += "[" + left + ", ";
        }

        if(right != null) {
            str += right + "]";
        }

        return str;
    }
}
