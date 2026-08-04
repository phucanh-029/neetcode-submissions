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
    public Node copyRandomList(Node head) {
        Map<Node, Node> copy = new HashMap<>();
        copy.put(null,null);
        Node curr = head;
        while(curr!=null){
            Node valueToCopy = new Node(curr.val);
            copy.put(curr, valueToCopy);
            curr = curr.next;
        }
        curr = head;
        while(curr!=null){
            Node cp = copy.get(curr);
            cp.next = copy.get(curr.next);
            cp.random = copy.get(curr.random);
            curr = curr.next;
        }
        return copy.get(head);
    }
}
