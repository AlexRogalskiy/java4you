package com.sensiblemetrics.api.alpenidos.adt.list.linkedlist;

public class Main {
    public static void main(String[] args) {

        System.out.println("Starting Linked List testing...");
        System.out.println("Linked List with integers");

        testIntegerLinkedList();

        System.out.println("Linked List with strings");
        testStringLinkedList();
    }

    static void testIntegerLinkedList(){
        //creating linked list
        List<Integer> intList = new LinkedList<>();

        //adding stuff to the linked list
        intList.addAtBeginning(2);
        intList.displayList();
        intList.addAtBeginning(4);
        intList.displayList();
        intList.addAtBeginning(6);
        intList.displayList();
        intList.addAtBeginning(8);
        intList.displayList();

        //testing the find functions
        System.out.println(intList.findFirst());
        System.out.println(intList.find(2));

        //testing removal from linked list
        intList.remove(2);
        intList.displayList();

        System.out.println(intList.size());
    }

    static void testStringLinkedList(){
        //creating string based linked list
        List<String> stringList = new LinkedList<>();

        //adding stuff to the linked list
        stringList.addAtBeginning("Apollo");
        stringList.displayList();
        stringList.addAtBeginning("Mars");
        stringList.displayList();
        stringList.addAtBeginning("Ares");
        stringList.displayList();

        //testing the find functions
        System.out.println(stringList.findFirst());
        System.out.println(stringList.find("Mars"));

        stringList.remove("Apollo");
        stringList.displayList();

    }
}
