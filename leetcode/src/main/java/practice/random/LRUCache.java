package practice.random;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anindita Banik on 8/7/22.
 */
public class LRUCache {
    class DLinkedlist{
        int key;
        int value;
        DLinkedlist next;
        DLinkedlist prev;
    }
    int size, capacity;
    Map<Integer, DLinkedlist> cache = new HashMap<>();
    DLinkedlist head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkedlist();
        tail = new DLinkedlist();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedlist node = cache.get(key);
        if(node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(DLinkedlist node) {
        removeNode(node);
        addNode(node);
    }

    private void addNode(DLinkedlist node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedlist node) {
        DLinkedlist prev = node.prev;
        DLinkedlist next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void put(int key, int value) {
        DLinkedlist node = cache.get(key);

        if(node==null){
            DLinkedlist newNode = new DLinkedlist();
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);

            size++;

            if(size>capacity){
                DLinkedlist tail = popTail();
                cache.remove(tail.key);
                size--;
            }
        } else{
            node.value = value;
            moveToHead(node);
        }
    }

    private DLinkedlist popTail() {
        DLinkedlist node = tail.prev;
        removeNode(node);
        return node;
    }
}
