package com.sensiblemetrics.api.alpenidos.adt.list.linkedlist;

public interface List<T> {
    public int size();

    public void remove(T t);

    public T addAtBeginning(T t);

    public T find(T t);

    public T findFirst();

    public void displayList();
}
