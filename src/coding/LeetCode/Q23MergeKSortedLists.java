package coding.LeetCode;

import java.util.PriorityQueue;

public class Q23MergeKSortedLists {
    /*
    - add all the heads of the lists to a min heap
    */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode l : lists){
            if(l != null){
                pq.add(l);
            }
        }
        ListNode newHead = new ListNode();
        ListNode dummy = newHead;
        while(!pq.isEmpty()){
            dummy.next = pq.poll();
            dummy = dummy.next;
            if(dummy.next != null){
                pq.add(dummy.next);
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {
//        System.out.println(new ListNode[]{{1,4,5}, });
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
