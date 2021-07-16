package com.sensiblemetrics.api.alpenidos.core.lambda.recursion;

import java.util.LinkedList;
import java.util.List;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public List<Integer> toLinkedList() {
        final List<Integer> list = new LinkedList<>();

        var current = this;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }

        return list;
    }
}
