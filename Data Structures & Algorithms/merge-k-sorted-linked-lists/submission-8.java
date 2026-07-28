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
        if(lists.length==0)return null;
        if(lists.length==1)return lists[0];
        if(lists.length==2) return merge2Lists(lists[0], lists[1]);
        ListNode res = merge2Lists(lists[0], lists[1]);
        for(int i =2; i< lists.length;i++){
            res= merge2Lists(res, lists[i]);
        }
        return res;
    }
    public ListNode merge2Lists(ListNode a, ListNode b){
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        while(a!=null && b!=null){
            if(a.val<b.val){
                dummy.next = a;
                a = a.next;
            }
            else{
                dummy.next = b;
                b = b.next;
            }
            dummy = dummy.next;
        }
        if(a!=null) dummy.next = a;
        if(b!=null) dummy.next = b;
        return res.next;
    }
}
