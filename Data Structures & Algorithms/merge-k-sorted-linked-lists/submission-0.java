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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val - b.val);
        for(ListNode list: lists){
            if(list == null) continue;
            while(list!=null){
                pq.add(list);
                list = list.next;
            }
        }
        ListNode res = new ListNode(0);
        ListNode node = res;
        while(!pq.isEmpty()){
            node.next = pq.poll();
            node = node.next;
        }
        // node.next = null;
        return res.next;
    }
}
