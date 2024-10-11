package coding.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Q138CopyListWithRandomPointer {
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

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }

    public Node copyRandomList2(Node head) {
        if (head == null) return null;

        Node curr = head;
        while (curr != null) {
            Node cloned = new Node(curr.val);
            cloned.next = curr.next;
            curr.next = cloned;
            curr = cloned.next;
        }
        curr = head;

        while (curr != null) {
            curr.next.random = (curr.random != null) ? curr.random.next : null;
            curr = curr.next.next;
        }

        Node curr_old = head;
        Node curr_new = head.next;
        Node head_new = head.next;
        while (curr_old != null) {
            curr_old.next = curr_old.next.next;
            curr_new.next = (curr_new.next != null) ? curr_new.next.next : null;
            curr_old = curr_old.next;
            curr_new = curr_new.next;
        }

        return head_new;
    }
}

