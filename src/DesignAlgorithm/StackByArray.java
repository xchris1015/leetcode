package DesignAlgorithm;

public class StackByArray {

    // push head++;
    // pop() head--
    // peek head-1!!!;

    private int head;
    private int size;
    private int[] array;
    private static final int CAPACITY = 10;

    public StackByArray (int capacity) {
        this.head = 0;
        this.size = -1; // prevent as empty
        this.array = new int[capacity];
    }

    public StackByArray () {
        this(CAPACITY);
    }

    public void offer (int val) {
        if (head >= array.length) {
            //expand()
        }

        array[++head] = val;
    }

    public Integer peek () {
        return (head == -1) ? null : array[head - 1];
    }

    public Integer pop () {
        if (head == -1) {
            return null;
        }

        return array[head--];
    }







}
