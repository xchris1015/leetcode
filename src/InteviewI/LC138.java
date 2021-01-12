package InteviewI;

import java.util.HashMap;
import java.util.Map;

public class LC138 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // two pass, hashmap, construct the node first, then do the next and random

//    public Node copyRandomList(Node head) {
//        if (head == null) {
//            return head;
//        }
//
//        Map<Node, Node> map = new HashMap<>();
//
//        Node current = head;
//
//        while (current != null) {
//            if (!map.containsKey(current)) {
//                map.put(current, new Node(current.val));
//            }
//            current = current.next;
//        }
//
//        Node dummy = new Node(0);
//        Node prev = dummy;
//        current = head;
//
//        while (current != null) {
//            prev.next = map.get(current);
//            prev.next.random = map.get(current.random);
//            prev = prev.next;
//            current = current.next;
//        }
//
//        return dummy.next;
//
//    }

    // two pass, hashmap, construct node and next first and then do the random

//    public Node copyRandomList(Node head) {
//        if (head == null) {
//            return head;
//        }
//
//        Map<Node, Node> map = new HashMap<>();
//
//        Node current = head;
//        Node dummy = new Node(0);
//        Node prev = dummy;
//
//        while (current != null) {
//            if (!map.containsKey(current)) {
//                map.put(current, new Node(current.val));
//            }
//
//            prev.next = map.get(current);
//            prev = prev.next;
//            current = current.next;
//        }
//
//        current = head;
//
//        while (current != null) {
//            map.get(current).random = map.get(current.random);
//            current = current.next;
//        }
//
//        return dummy.next;
//    }

    // one pass with hashmap

//    public Node copyRandomList(Node head) {
////        if (head == null) {
////            return head;
////        }
////
////        Node dummy = new Node(0);
////        Node current = head;
////        Node prev = dummy;
////
////        Map<Node, Node> map = new HashMap<>();
////
////        while (current != null) {
////            if (!map.containsKey(current)) {
////                map.put(current, new Node(current.val));
////            }
////
////            prev.next = map.get(current);
////
//////            if (current.random != null && !map.containsKey(current.random)) {
//////                map.put(current.random, new Node(current.random.val));
//////                map.get(current).random = map.get(current.random);
//////            } else if (current.random == null) {
//////                map.get(current).random = null;
//////            } else {
//////                map.get(current).random = map.get(current.random);
//////            }
////
////            if (current.random != null) {
////                if (!map.containsKey(current.random)) {
////                    map.put(current.random, new Node(current.random.val));
////                }
////                map.get(current).random = map.get(current.random);
////            }
////
////            prev = prev.next;
////            current = current.next;
////        }
////
////        return dummy.next;
////    }

    // three pass with O1 space, use odd and even node, prev and current //TODO
    // 奇偶位置
    // first pass: 1 1' 2 2' 3 3' 4 4'
    // second pass: update forward, cur.next.forward = cur.forward.next;
    // third pass : break the odd and even
    public Node copyRandomList(Node head) {

        if (head == null) {
            return head;
        }

        Node current = head;

        while (current != null) {

            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;

            current = copy.next;
        }

        current = head;

        while (current != null) {
            current.next.random = current.random != null ? current.random.next : null;
            current = current.next.next;
        }

        Node oldHead = head;
        Node newHead = head.next;
        Node returnHead = head.next;
        while (oldHead != null) {

            oldHead.next = oldHead.next.next;
            newHead.next = newHead.next != null ? newHead.next.next : null;

            oldHead = oldHead.next;
            newHead = newHead.next;

        }

        return returnHead;


    }
}
