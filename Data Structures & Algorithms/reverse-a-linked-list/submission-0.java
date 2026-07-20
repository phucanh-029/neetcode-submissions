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
    public ListNode reverseList(ListNode head) {

        ListNode res = null;
        while(head!=null){
            System.out.print(head.val);
            // curr.val = head.val;
            // curr =
            // res.next = curr;
            res = new ListNode(head.val, res);
            // res.next = res;
            head = head.next;
            
        }
        return res;
    }
    // 0 
    // 1 2 3
    // 1 
}
