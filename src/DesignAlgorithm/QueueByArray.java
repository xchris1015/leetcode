package DesignAlgorithm;

public class QueueByArray {

    // use two pointer head and tail, offer == tail++, poll == head++, index need to mod capacity

    private int head, tail;
    private int[] array;
    private int size;
    private static final int CAPACITY = 10;

    public QueueByArray () {
        this(CAPACITY);
    }

    public QueueByArray (int capacity) {
        this.head = 0;
        this.tail = 0;
        this.size = 0;
        this.array = new int[capacity];
    }

    public void offer (int val) {

        if (head == tail) {
            //extend();
        }

        array[tail] = val;
        tail = (tail + 1) % array.length;

        size++;
    }

    public Integer poll () {

        if (size == 0) return null;

        int pollValue = array[head];

        head = (head + 1) % array.length;

        size--;

        return pollValue;
    }

    public int peek () {
        return size == 0 ? null : array[head];
    }

}
