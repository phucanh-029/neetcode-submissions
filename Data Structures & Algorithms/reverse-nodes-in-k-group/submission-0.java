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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode(0,head);
        ListNode node = res;
        
        while(true){
            ListNode kTh = findKth(node,k);
            if(kTh == null)break;
            int group = k;
            ListNode groupNext = kTh.next;
            ListNode prev = groupNext;
            ListNode curr = node.next;
            while(curr!= groupNext){
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            } 
            ListNode tmp = node.next;
            node.next = kTh;
            node = tmp;
        }
        return res.next; 
    }
    private ListNode findKth(ListNode head, int k){
        while(head!=null && k >0){
            head = head.next;
            k--;
        }
        return head;
    }
}

// head.next = null, l1 =  1->null, head = 2 3 4
// head.next = 1, l1 = 2->1->null, head = 3 4
//  head.next = 2-1, l1 = 3
