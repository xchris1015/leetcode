package DesignAlgorithm;

import java.util.HashMap;

public class LC146 {
    // double linkedList + HashMap;
    // hashMap for cache storeage, at most recent used element in cache to head of doubleLinkedList

    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;
    private int size;
    private int capacity;

    public LC146(int capacity) {
        this.map = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();
        this.size = 0;
        this.capacity = capacity;

        this.head.next = tail;
        this.tail.prev = head;
    }

    public int get(int key) {
        Node hit = map.get(key);

        if (hit == null) {
            return -1;
        }

        moveTohead(hit);

        return hit.value;
    }

    private void moveTohead(Node node) {
        removeNode(node);
        addNode(node);
    }

    public void put(int key, int value) {
        Node node = map.get(key);

        if (node != null) {
            if (node.value != value) {
                node.value = value;
            }
            moveTohead(node);
            return;
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        addNode(newNode);
        size++;

        if (size > capacity) {
            Node remove = removeTail();
            map.remove(remove.key);
            size--;
        }
    }

    private Node removeTail() {
        Node remove = tail.prev;
        removeNode(remove);

        return remove;
    }

    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.value = val;
            this.prev = null;
            this.next = null;
        }

        public Node() {

        }
    }

}
