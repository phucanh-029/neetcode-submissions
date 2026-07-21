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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(0);
        ListNode node = res;
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        // if(list1.val > list2.val){
        //     res = list2;
        //     list2 = list2.next;
        // }
        // else{
        //     res = list1;
        //     list1 = list1.next;
        // }
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                node.next = list1;
                list1 = list1.next;
            }
            else{
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        if(list1!=null){
            node.next = list1;
        }
        if(list2!=null){
            node.next = list2;
        }
        // ListNode curr = list1
        // while(list1!= null || list2!=null){
        //     if(list1!= null && list2!=null){
        //         if(list1.val < list2.val){
        //             ListNode tmp = new ListNode(list1.val, null);
        //             res = tmp;

        //             list1 = list1.next;
        //         }
        //         else{
        //             ListNode tmp = new ListNode(list2.val, null);
        //             res = tmp;
        //             list2 = list2.next;
        //         }
        //     }
        //     else{
        //         if(list1 == null){
        //             res.next = list2;
        //             list2 = list2.next;
        //         }
        //         else{
        //             res.next= list1;
        //             list1 = list1.next;
        //         }
        //     }
        // }
        return res.next;
    }
}