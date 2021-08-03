package com.sensiblemetrics.api.alpenidos.pattern.commander.queue;

import com.sensiblemetrics.api.alpenidos.pattern.commander.exception.IsEmptyException;
import lombok.Data;

/**
 * Queue data structure implementation.
 *
 * @param <T> is the type of object the queue will hold.
 */
@Data
public class Queue<T> {
    private Node<T> front;
    private Node<T> rear;
    public int size = 0;

    class Node<T> {
        private T value;
        private Node<T> next;

        Node(final T obj, final Node<T> b) {
            value = obj;
            next = b;
        }
    }

    /**
     * Queue constructor
     */
    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void enqueue(T obj) {
        if (front == null) {
            front = new Node(obj, null);
            rear = front;
        } else {
            Node temp = new Node(obj, null);
            rear.next = temp;
            rear = temp;
        }
        size++;
    }

    public T dequeue() throws IsEmptyException {
        if (isEmpty()) {
            throw new IsEmptyException();
        } else {
            Node temp = front;
            front = front.next;
            size = size - 1;
            return ((T) temp.value);
        }
    }

    public T peek() throws IsEmptyException {
        if (isEmpty()) {
            throw new IsEmptyException();
        } else {
            return ((T) front.value);
        }
    }
}
