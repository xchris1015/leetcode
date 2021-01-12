package DesignAlgorithm;

import BinaryTree.ListNode;

public class DesignQueueByLinkedList {

    // head and tail, tail in, head out
    // 1 2 3 4 5 null
    // head    tail

    private ListNode head, tail;

    public DesignQueueByLinkedList () {
        this.head = null;
        this.tail = null;
    }

    public void offer (int val) {
        ListNode newNode = new ListNode(val);

        if (head == null && tail == null) {
            head = newNode;
            tail = newNode.next;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
    }

    public ListNode poll () {
        if (head == null) {
            return head;
        }

        ListNode pollNode = head;
        head = head.next;
        pollNode.next = null;

        return pollNode;
    }

    public ListNode peek () {
        if (head == null) {
            return null;
        }

        return head;
    }

    //use doubly linkedList, but why?






}
