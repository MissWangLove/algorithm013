package time1.a1;

public class Trie {
    /**
     *  实现 Trie (前缀树)
     * 实现一个 Trie (前缀树)，包含insert,search, 和startsWith这三个操作。
     *
     * 示例:
     *
     * Trie trie = new Trie();
     *
     * trie.insert("apple");
     * trie.search("apple");   // 返回 true
     * trie.search("app");     // 返回 false
     * trie.startsWith("app"); // 返回 true
     * trie.insert("app");
     * trie.search("app");     // 返回 true
     * 说明:
     *
     * 你可以假设所有的输入都是由小写字母a-z构成的。
     * 保证所有输入均为非空字符串。
     */

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (! node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
            } else {
                return false;
            }
        }
        return node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (node.containsKey(prefix.charAt(i))) {
                node = node.get(prefix.charAt(i));
            } else {
                return false;
            }
        }
        // 需要考虑前缀是本身么？
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        // 返回 true
        System.out.println(trie.search("apple"));
        // 返回 false
        System.out.println(trie.search("app"));
        // 返回 true
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        // 返回 true
        System.out.println(trie.search("app"));
    }
}

class TrieNode {
    private TrieNode[] trieNode;
    private final int LEN = 26;
    private Boolean isEnd = false;

    /** Initialize your data structure here. */
    public TrieNode() {
        trieNode = new TrieNode[LEN];
    }

    public boolean containsKey(char ch) {
        return trieNode[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return trieNode[ch -'a'];
    }

    public void put(char ch, TrieNode node) {
        trieNode[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}
