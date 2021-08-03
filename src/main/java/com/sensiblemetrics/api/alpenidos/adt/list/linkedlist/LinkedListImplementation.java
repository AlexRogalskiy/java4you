package com.sensiblemetrics.api.alpenidos.adt.list.linkedlist;

public class LinkedListImplementation {

    public static void main(final String[] args) {
        final LinkedList2<Integer> linkedList = new LinkedList2<>();

        linkedList.insertAtBeginning(5);
        linkedList.displayLinkedList();
        linkedList.insertAtBeginning(10);
        linkedList.displayLinkedList();
        linkedList.insertAtEnd(3);
        linkedList.displayLinkedList();
        linkedList.insertAtEnd(6);
        linkedList.displayLinkedList();
        linkedList.insertAtPosition(4, 3);
        linkedList.displayLinkedList();

        System.out.println(linkedList.getLinkedListLength());
    }
}

class LinkedList2<T> {

    private int length = 0;

    private LinkedListNode<T> head;

    public LinkedList2() {
        this.length = 0;
    }

    //insertion methods
    public void insertAtBeginning(T data) {
        final LinkedListNode<T> node = new LinkedListNode<>(data);
        node.setNext(head);
        head = node;
        length++;
    }

    public void insertAtEnd(T data) {
        LinkedListNode<T> currentNode = head;

        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }

        final LinkedListNode<T> node = new LinkedListNode<>(data);

        node.setNext(null);
        currentNode.setNext(node);
        length++;
    }

    public int insertAtPosition(T data, int position) {
        if (position > length + 1) {
            return -1;
        }

        LinkedListNode<T> currentNode = head;

        for (int i = 1; i <= position - 2; i++) {
            currentNode = currentNode.getNext();
        }

        LinkedListNode<T> node = new LinkedListNode<>(data);

        if (currentNode.getNext() != null) {
            node.setNext(currentNode.getNext());
        }
        currentNode.setNext(node);
        length++;

        return 1;
    }

    //display linked list
    public void displayLinkedList() {
        LinkedListNode<T> currentNode = head;

        while (currentNode != null) {
            System.out.print(currentNode.getData() + "->");
            currentNode = currentNode.getNext();
        }

        System.out.print("null");
        System.out.println("\n");
    }

    public int getLinkedListLength() {
        return this.length;
    }

    private static class LinkedListNode<T> {

        private T data;

        private LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public T getData() {
            return this.data;
        }

        public void setNext(LinkedListNode<T> next) {
            this.next = next;
        }

        public LinkedListNode<T> getNext() {
            return this.next;
        }
    }
}
