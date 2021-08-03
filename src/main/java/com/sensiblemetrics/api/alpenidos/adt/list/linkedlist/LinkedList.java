package com.sensiblemetrics.api.alpenidos.adt.list.linkedlist;

public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> root;
    private int size;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void remove(T data) {

        this.size--;
        if (root.getData().equals(data)) {
            removeFromTop();
        } else {
            removeNode(data);
        }
    }

    private void removeFromTop() {
        this.root = root.getNextNode();
    }

    private void removeNode(T data) {
        Node currentNode = root.getNextNode();
        Node previousNode = root;

        while (!(currentNode.equals(null))) {
            if (currentNode.getData().compareTo(data) == 0) {
                previousNode.setNextNode(currentNode.getNextNode());
                return;
            } else {
                previousNode = currentNode;
                currentNode = currentNode.getNextNode();
            }
        }
    }

    @Override
    public T addAtBeginning(T data) {
        this.size++;
        if (this.root == null) {
            this.root = new Node<>(data);
            return this.root.getData();
        } else {
            return (addNode(data));
        }
    }

    private T addNode(T data) {
        Node<T> node = new Node<>(data);
        node.setNextNode(this.root);
        this.root = node;
        return data;
    }

    @Override
    public T find(T data) {
        Node searchNode = this.root;

        while (searchNode != null) {
            if (searchNode.getData().compareTo(data) == 0) {
                return data;
            } else {
                searchNode = searchNode.getNextNode();
            }
        }
        return null;
    }

    @Override
    public T findFirst() {
        return root.getData();
    }

    @Override
    public void displayList() {
        Node currentNode = this.root;
        while (currentNode != null) {
            System.out.print(currentNode.getData() + " -> ");
            if (null == currentNode.getNextNode()) {
                System.out.print(" null");
            }
            currentNode = currentNode.getNextNode();
        }
        System.out.println("");
    }
}
