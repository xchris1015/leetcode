package DesignAlgorithm;

import BinaryTree.ListNode;

public class DesignStackUsingLinkedList {

    // because first in last out, use head as the top element, head in head out

    private ListNode head;

    public DesignStackUsingLinkedList () {
        this.head = null;
    }

    public void push (int val) {

        ListNode newNode = new ListNode(val);

        newNode.next = head;
        head = newNode;
    }

    public ListNode pop () {
        if (head == null) {
            return null; //exception
        }

        ListNode popNode = head;
        head = head.next;
        popNode.next = null;

        return popNode;
    }

    public ListNode peek () {
        return head == null ? null : head;
    }


}
