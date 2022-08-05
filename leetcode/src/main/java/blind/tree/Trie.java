package blind.tree;

/**
 * Created by Anindita Banik on 7/17/22.
 */


class Trie {
    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (Character c : word.toCharArray()) {
            if (node.children[c - 'a'] == null)
                node.children[c - 'a'] = new TrieNode();
            node = node.children[c - 'a'];
        }
        node.word = word;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (Character c : word.toCharArray()) {
            if (node.children[c - 'a'] == null)
                return false;
            node = node.children[c - 'a'];
        }
        if (node.word.equals(word))
            return true;
        else
            return false;
    }

    public boolean startsWith(String word) {
        TrieNode node = root;
        for (Character c : word.toCharArray()) {
            if (node.children[c - 'a'] == null)
                return false;
            node = node.children[c - 'a'];
        }
        return true;
    }
}
