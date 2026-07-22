/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> sorted_collection = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode list : lists){
            if(list != null) sorted_collection.add(list);
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(!sorted_collection.isEmpty()) {
            ListNode minNode = sorted_collection.poll();
            current.next = minNode;
            current = current.next;

            if(minNode.next != null)sorted_collection.add(minNode.next);
        }
        return dummy.next;
    }
}