package hot;

import java.util.HashMap;

/**
 * @author: yc_comeon
 * @date: 2023/3/8
 * @description: TODO
 **/
public class LRUCache {
    HashMap<Integer, Node> map = null;
    Node head = new Node();
    Node tail = new Node();
    int capacity = 0;

    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity);
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);

            //change head
            node.pre.next = node.next;
            node.next.pre = node.pre;

            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;

            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.val = value;
            node.pre.next = node.next;
            node.next.pre = node.pre;
        } else {
            node = new Node(key, value);
        }

        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        map.put(key, node);

        if (map.size() > capacity) {
            map.remove(tail.pre.key);
            tail.pre = tail.pre.pre;
            tail.pre.next = tail;
        }
    }

    static class Node {
        int key;
        int val;
        Node next;
        Node pre;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public Node() {
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println();
    }
}
