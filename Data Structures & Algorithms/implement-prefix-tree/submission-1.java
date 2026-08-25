class TrieNode{
    public TrieNode[] children;
    public boolean isEnd;
    public TrieNode(){
        children = new TrieNode[26];
    }
}
class PrefixTree {
    private TrieNode root;
    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            TrieNode next = curr.children[c - 'a'];
            if(next == null){
                next = curr.children[c - 'a'] = new TrieNode();   
            } 
            curr = next;
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            TrieNode next = curr.children[c - 'a'];
            if(next == null){
                return false;
            }
            curr = next;
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c : prefix.toCharArray()){
            TrieNode next = curr.children[c - 'a'];
            if(next == null){
                return false;
            }
            curr = next;
        }
        return true;
    }
}
