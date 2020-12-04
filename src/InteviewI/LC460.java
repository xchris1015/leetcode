package InteviewI;

import java.util.HashMap;
import java.util.Map;

public class LC460 {

    // heap, need to create myheap with an HeapNode[]
    // use Doubly LinedList with HashMap, find frequency is not On is Ok, k is the cache size,
    // To implement LRU and LFU together, we can use a ListNode with bucket of timestamp.


    Map<Integer, Node> cache;
    Node head, tail;
    int capacity, size;

    public LC460(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new Node();
        this.tail = new Node();
        this.cache = new HashMap<>();
    }


    class Node {
        Integer key;
        Integer value;
        Integer frequency;

        
    }

}
