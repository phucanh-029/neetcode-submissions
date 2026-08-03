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
    public void reorderList(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        ListNode prev =slow.next= null;
        while(second!=null){
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }
        ListNode first = head;
        second = prev;
        while(second!=null){
            ListNode l1 = first.next;
            ListNode l2 = second.next;
            first.next = second;
            second.next = l1;
            first = l1;
            second = l2;
        }
    }
}

// 2, 4, 6, 8 -> 2, 6, 8, 4 -> 2, 8 ,4 ,6
// 2,4,6,8,10 -> 2,6,8,10,4 -> 2,8,10,4,6 ->2,10,4,6,8
