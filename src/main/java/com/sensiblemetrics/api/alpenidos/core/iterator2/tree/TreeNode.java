package com.sensiblemetrics.api.alpenidos.core.iterator2.tree;

import lombok.Data;

/**
 * TreeNode Class, representing one node in a Binary Search Tree. Allows for a generically typed
 * value.
 *
 * @param <T> generically typed to accept various data types for the val property
 */
@Data
public class TreeNode<T extends Comparable<T>> {
    private T val;
    private TreeNode<T> left;
    private TreeNode<T> right;

    /**
     * Creates a TreeNode with a given value, and null children
     *
     * @param val The value of the given node
     */
    public TreeNode(final T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    /**
     * Inserts new TreeNode based on a given value into the subtree represented by self
     *
     * @param valToInsert The value to insert as a new TreeNode
     */
    public void insert(final T valToInsert) {
        final TreeNode<T> parent = this.getParentNodeOfValueToBeInserted(valToInsert);
        parent.insertNewChild(valToInsert);
    }

    /**
     * Fetch the Parent TreeNode for a given value to insert into the BST.
     *
     * @param valToInsert Value of the new TreeNode to be inserted
     * @return Parent TreeNode of `valToInsert`
     */
    private TreeNode<T> getParentNodeOfValueToBeInserted(final T valToInsert) {
        TreeNode<T> parent = null;
        TreeNode<T> curr = this;
        while (curr != null) {
            parent = curr;
            curr = curr.traverseOneLevelDown(valToInsert);
        }
        return parent;
    }

    /**
     * Returns left or right child of self based on a value that would be inserted; maintaining the
     * integrity of the BST.
     *
     * @param value The value of the TreeNode that would be inserted beneath self
     * @return The child TreeNode of self which represents the subtree where `value` would be inserted
     */
    private TreeNode<T> traverseOneLevelDown(final T value) {
        if (this.isGreaterThan(value)) {
            return this.left;
        }
        return this.right;
    }

    /**
     * Add a new Child TreeNode of given value to self. WARNING: This method is destructive (will
     * overwrite existing tree structure, if any), and should be called only by this class's insert()
     * method.
     *
     * @param valToInsert Value of the new TreeNode to be inserted
     */
    private void insertNewChild(final T valToInsert) {
        if (this.isLessThanOrEqualTo(valToInsert)) {
            this.setRight(new TreeNode<>(valToInsert));
        } else {
            this.setLeft(new TreeNode<>(valToInsert));
        }
    }

    private boolean isGreaterThan(final T val) {
        return this.val.compareTo(val) > 0;
    }

    private boolean isLessThanOrEqualTo(final T val) {
        return this.val.compareTo(val) < 1;
    }

    @Override
    public String toString() {
        return this.val.toString();
    }
}
