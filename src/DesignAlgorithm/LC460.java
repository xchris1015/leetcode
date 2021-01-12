package DesignAlgorithm;

import java.util.HashMap;
import java.util.Map;

public class LC460 {

    private Map<Integer, Node> mapping;
    private Map<Integer, NodeList> frequency;
    private int capacity;
    private int size;
    private int minFrequency;

    public LC460(int capacity) {
        this.mapping = new HashMap<>();
        this.frequency = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
        this.minFrequency = 0;
    }

    public int get(int key) {
        Node node = mapping.get(key);

        if (node == null) {
            return -1;
        }

        int prevFreqency = node.freq;
        deleteNode(node, prevFreqency);

        node.freq++;
        addToHead(node, node.freq);

        return node.val;
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        Node node = mapping.get(key);

        if (node != null) {
            node.val = value;
            get(node.key);
            return;
        }

        node = new Node(key, value);

        if (size == capacity) {
            removeTail();
            size--;
        }

        minFrequency = 1;
        mapping.put(key, node);

        addToHead(node, node.freq);
        size++;

    }

    private void deleteNode (Node node, int prevFreqency) {
        NodeList list = frequency.get(prevFreqency);

        if (list == null) {
            return;
        }

        list.deleteNode(node);

        if (list.isEmpty()) {
            frequency.remove(prevFreqency);
            if (prevFreqency == minFrequency) {
                minFrequency++; //question, should this be an for loop to find min or frequency?
            }
        }
    }

    private void addToHead (Node node, int curFreqency) {
        NodeList list = frequency.get(curFreqency);

        if (list == null) {
            frequency.put(curFreqency, new NodeList());
        }

        list = frequency.get(curFreqency);
        list.addToHead(node);
    }

    private void removeTail() {
        NodeList list = frequency.get(minFrequency);
        Node remove = list.removeTail();

        mapping.remove(remove.key);
        if (list.isEmpty()) {
            frequency.remove(minFrequency);
            minFrequency++;
        }
    }

    class NodeList {

        private Node head;
        private Node tail;
        private int size;

        public NodeList () {
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            this.size = 0;
            head.next = tail;
            tail.prev = head;
        }

        public void addToHead (Node node) {
            Node next = head.next;

            head.next = node;
            node.next = next;

            node.prev = head;
            next.prev = node;

            size++;
        }

        public void deleteNode (Node node) {
            Node prev = node.prev;
            Node next = node.next;

            node.prev = null;
            node.next = null;

            prev.next = next;
            next.prev = prev;

            size--;
        }

        public Node removeTail () {
            Node prev = tail.prev;

            if (prev == head) {
                return null;
            }

            deleteNode(prev);
            return prev;
        }

        public boolean isEmpty() {
            return size == 0;
        }

    }

    class Node {
        private int key;
        private int val;
        private int freq;

        private Node prev;
        private Node next;

        public Node (int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
            this.prev = null;
            this.next = null;
        }
    }
}
