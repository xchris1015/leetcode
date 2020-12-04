package OOD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyMap<K, V> {

    // attributes
//    private static int capcity;
//    private static int size;
//    private List<Entry>[] buckets;
//    private static final double LOAD_FACTOR = 0.75d;
//
//    // constructor
//
//    public MyMap (int capcity) {
//        this.capcity = capcity;
//        this.size = 0;
//        this.buckets = new ArrayList<Entry>[capcity];
//    }
//
//    public MyMap () {
//        this(10);
//    }
//
//    // methods
//
//    public boolean put(K key, V value) {
//        int idx = findBucket(key);
//        List<Entry> bucket = this.buckets[idx];
//
//        if (bucket == null) {
//            this.buckets[idx] = new ArrayList<>();
//            bucket = this.buckets[idx];
//        }
//
//        Entry<K, V> putItem = new Entry<>(key, value);
//        for (Entry entry : bucket) {
//            if (putItem.equals(entry)) {
//                entry.setVal(value);
//                return true;
//            }
//        }
//
//        bucket.add(putItem);
//        size++;
//
//        if (size >= capcity * LOAD_FACTOR) {
//            extend();
//        }
//
//        return true;
//    }
//
//    private void extend() {
//        capcity = capcity * 2;
//        List<Entry>[] newBuckets = new ArrayList<Entry>[capcity];
//
//        for (List<Entry> bucket : buckets) {
//            for (Entry entry : bucket) {
//                int idx = findBucket(entry.getKey());
//                newBuckets[idx].add(entry);
//            }
//        }
//
//    }
//
//    public boolean remove(K key) {
//        int idx = findBucket(key);
//
//        List<Entry> bucket = buckets[idx];
//        if (bucket == null) {
//            return false;
//        }
//
//        Entry<K, V> removeItem = new Entry<>(key, null);
//
//        for (int i = 0 ; i < bucket.size() ; i++ ) {
//            if (removeItem.equals(bucket.get(i))) {
//                Collections.swap(bucket, i, bucket.size() - 1);
//                bucket.remove(bucket.size() - 1);
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//
//    public Entry get(K key) { // could throw exception;
//        int idx = findBucket(key);
//
//        List<Entry> bucket = buckets[idx];
//        if (bucket == null) {
//            return null;
//        }
//
//        Entry<K, V> getItem = new Entry<>(key, null);
//        for (Entry entry : bucket) {
//            if (getItem.equals(entry)) {
//                return entry;
//            }
//        }
//
//        return null;
//    }
//
//    private int findBucket(K key) {
//        return key == null ? 0 : Math.abs(key.hashCode() % capcity);
//    }
//
//
//
//    // inner class for entry
//
//    public static class Entry<K, V> {
//
//        K key;
//        V val;
//
//        public K getKey() {
//            return key;
//        }
//
//        public void setKey(K key) {
//            this.key = key;
//        }
//
//        public V getVal() {
//            return val;
//        }
//
//        public void setVal(V val) {
//            this.val = val;
//        }
//
//        public Entry (K key, V val) {
//            this.key = key;
//            this.val = val;
//        }
//
//        @Override
//        public int hashCode() {
//            return this.key.hashCode();
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//
//            if (!(obj instanceof Entry)) {
//                return false;
//            }
//
//            Entry<K, V> entry = (Entry<K, V>) obj;
//
//            return entry == null ? false : this.getKey() == null ? entry.getKey() == null : this.getKey().equals(entry.getKey());
//        }
//    }

}
