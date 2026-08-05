/*
// Definition for a Node.
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
*/

class Solution {
    HashMap<Node, Node> copy = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        if(copy.containsKey(head)) return copy.get(head);
        Node cp  = new Node(head.val);
        copy.put(head, cp);
        cp.next = copyRandomList(head.next);
        cp.random = copyRandomList(head.random);
        return cp;
    }
}
