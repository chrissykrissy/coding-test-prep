class TrieNode{
    int isEnd = 0;
    TrieNode[] children;

    public TrieNode() {
        this.children = new TrieNode[26];
    }
}
class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd++;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if(curr.children[c-'a'] == null) return false;
            curr = curr.children[c-'a'];
        }
        return curr.isEnd > 0;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if(curr.children[c-'a'] == null) return false;
            curr = curr.children[c-'a'];
        }
        return true;
    }
}