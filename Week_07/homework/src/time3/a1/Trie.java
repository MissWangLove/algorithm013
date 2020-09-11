package time3.a1;

public class Trie {
    /**
     *  实现 Trie (前缀树) 字典树
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

    private TreeNode root;

    public Trie() {
        root = new TreeNode();
    }


    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode node = root;
        char[] chars = word.toCharArray();
        for (char aChar : chars) {
            if (!node.constainKey(aChar)) {
                node.put(aChar, new TreeNode());
            }
            node = node.getTreeNode(aChar);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode node = root;
        for (char c : word.toCharArray()) {
            if (node.constainKey(c)) {
                node = node.getTreeNode(c);
            } else {
                return false;
            }
        }
        return node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.constainKey(c)) {
                node = node.getTreeNode(c);
            } else {
                return false;
            }
        }
        return !node.isEnd();
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

class TreeNode {
    private TreeNode[] treeNodes;

    private Integer LEN = 26;

    private boolean isEnd;

    public TreeNode() {
        treeNodes = new TreeNode[LEN];
    }

    public boolean constainKey(char ch) {
        return treeNodes[ch - 'a'] != null;
    }

    public TreeNode getTreeNode(char ch) {
        return treeNodes[ch - 'a'];
    }

    public void put(char ch, TreeNode treeNode) {
        treeNodes[ch - 'a'] = treeNode;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}


