package com.sensiblemetrics.api.alpenidos.core.lambda.recursion;

public class ListReverse {

    static ListNode withRecur(ListNode currentNode) {
        if (isLast(currentNode)) {
            return currentNode;
        }

        var newHead = withRecur(currentNode.next);

        reverseLink(currentNode);
        cutNext(currentNode);

        return newHead;
    }

    static ListNode withLoop(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    static ListNode withTailRecur(ListNode head) {
        return withTailRecur(head, null);
    }

    private static ListNode withTailRecur(ListNode head, ListNode reversed) {
        if (head == null) {
            return reversed;
        }
        return withTailRecur(head.next, prepend(head, reversed));
    }

    private static ListNode prepend(ListNode newHead, ListNode list) {
        newHead.next = list;
        return newHead;
    }

    private static void reverseLink(ListNode node) {
        node.next.next = node;
    }

    private static void cutNext(ListNode node) {
        node.next = null;
    }

    private static boolean isLast(ListNode node) {
        return node.next == null;
    }
}
