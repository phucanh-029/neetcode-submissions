class PrefixTree {
    private Set<String> tree;
    public PrefixTree() {
        this.tree = new HashSet<>();
    }

    public void insert(String word) {
        tree.add(word);
    }

    public boolean search(String word) {
        return tree.contains(word);
    }

    public boolean startsWith(String prefix) {
        for( String s: tree){
            if(s.startsWith(prefix)) return true;
        }
        return false;
    }
}
