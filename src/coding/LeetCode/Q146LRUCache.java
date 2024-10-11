package coding.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Q146LRUCache {
    Map<Integer, DNode> map;
    DoublyLinkedList dll;
    int capacity;

    public Q146LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.dll = new DoublyLinkedList();
        this.capacity = capacity;
    }
    /*
    By getting the value of a key, "refreshes" its recency and becomes most recent.
    We must move it from where it is to the front of the cache (back of the linked list)
    We set a pointer to the desired node. Then we remove it, and add it to the back of the list.
     */
    public int get(int key){
        if(!map.containsKey(key)) return -1;
        DNode target = map.get(key);
        dll.add(dll.remove(target));
        return target.val;
    }

    /*
    A new kv pair/an updated value will also cause it to become the most recent.

    If the key already exists in the cache, we update its value and move it to the front.
    The code is same as in get(key) except we update the value.

    If the key does not exist, we make a new node and add it to the front of the cache (back of the linked list)
    If the capacity is zero when we do this, we are over the limit and must remove the least-recently-used node,
    which is conveniently located at the back of the cache (front of the dll). We store the key in the Node so that we can
    quickly remove from the Hashmap the key whose value is being evicted from cache.
     */
    public void put(int key, int value){
        if(map.containsKey(key)){
            DNode target = map.get(key);
            target.val = value;
            dll.add(dll.remove(target));
        }
        else{
            DNode newNode = new DNode(key, value);
            map.put(key, newNode);
            dll.add(newNode);
            if(capacity == 0){
                map.remove(dll.head.key);
                dll.remove(dll.head);
            }else{
                capacity--;
            }
        }
    }

    class DNode{
        int key;
        int val;
        DNode prev;
        DNode next;

        public DNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DoublyLinkedList {
        DNode head;
        DNode tail;
        public DoublyLinkedList(){
            this.head = null;
            this.tail = null;
        }

        public void add(DNode newNode){
            if(head == null){
                head = newNode;
                tail = newNode;
            }else{
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }
        public DNode remove(DNode node){
            DNode removed = node;
            if(node == head){
                head = head.next;
            }
            else if(node == tail){
                tail = tail.prev;
            }
            else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            return removed;
        }
    }
}
