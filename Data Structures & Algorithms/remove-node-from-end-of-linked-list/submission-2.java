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
    public ListNode removeNthFromEnd(ListNode head, int n) {
  
        ListNode second = new ListNode(0);
        ListNode first = head;
        while(n>0){
            first = first.next;
            n--;
        }
        // return first;
        if(first == null) return head.next;
        ListNode dummy = second;
        while(first!=null){
            dummy.next = head;
            head = head.next;
            dummy = dummy.next;
            first = first.next;
        }
        if(dummy.next!=null) dummy.next = dummy.next.next;
        else dummy.next = null;
        return second.next;
    }
}

// 1 -> 2 -> 3 ->4  
