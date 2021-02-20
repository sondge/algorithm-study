package club.sondge.algorithm.map;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private static Integer remove;
    private TreeNode<K, V> root;
    private int size;

    public BSTMap() {
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(key, value, root);
    }

    private TreeNode<K, V> add(K key, V value, TreeNode<K, V> root) {
        if (root == null) {
            size++;
            return new TreeNode<>(key, value);
        }
        if (root.key.compareTo(key) < 0) {
            root.right = add(key, value, root.right);
            return root;
        }
        if (root.key.compareTo(key) > 0) {
            root.left = add(key, value, root.left);
            return root;
        }
        root.value = value;
        return root;
    }

    @Override
    public V remove(K key) {
        V value = get(key);
        root = remove(key, root);
        return value;
    }

    private TreeNode<K, V> remove(K key, TreeNode<K, V> root) {
        if (root == null) {
            return null;
        }
        if (key.compareTo(root.key) < 0) {
            root.left = remove(key, root.left);
            return root;
        }
        if (key.compareTo(root.key) > 0) {
            root.right = remove(key, root.right);
            return root;
        }
        if (root.left == null) {
            TreeNode<K, V> rightNode = root.right;
            root.right = null;
            size--;
            return rightNode;
        }
        if (root.right == null) {
            TreeNode<K, V> leftNode = root.left;
            root.left = null;
            size--;
            return leftNode;
        }
        TreeNode<K, V> minNode = minimal(root.right);
        minNode.left = root.left;
        minNode.right = removeMin(root.right);
        ;
        root.left = null;
        root.right = null;
        return root;
    }

    public TreeNode<K, V> minimal(TreeNode<K, V> node) {
        if (root == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        }
        return minimal(node.left);
    }

    public TreeNode<K, V> removeMin(TreeNode<K, V> node) {
        if (node == null) {
            return null;
        }
        if (node.left != null) {
            node.left = removeMin(node.left);
            return node;
        }
        if (node.right == null) {
            return null;
        }
        TreeNode<K, V> rightNode = node.right;
        node.right = null;
        size--;
        return rightNode;

    }

    @Override

    public boolean contains(K key) {
        return contains(key, root);
    }

    private boolean contains(K key, TreeNode<K, V> root) {
        if (root == null) {
            return false;
        }
        if (key.compareTo(root.key) > 0) {
            return contains(key, root.right);
        }
        if (key.compareTo(root.key) < 0) {
            return contains(key, root.left);
        }
        return true;
    }

    @Override
    public V get(K key) {
        return get(key, root);
    }

    private V get(K key, TreeNode<K, V> root) {
        if (root == null) {
            return null;
        }
        if (root.key.compareTo(key) < 0) {
            return get(key, root.right);
        }
        if (root.key.compareTo(key) > 0) {
            return get(key, root.left);
        }
        return root.value;
    }

    @Override
    public void set(K key, V value) {
        root = set(key, value, root);
    }

    private TreeNode<K, V> set(K key, V value, TreeNode<K, V> root) {
        if (root == null) {
            size++;
            return new TreeNode<>(key, value);
        }
        if (root.key.compareTo(key) > 0) {
            root.left = set(key, value, root.left);
            return root;
        }
        if (root.key.compareTo(key) < 0) {
            root.right = set(key, value, root.right);
            return root;
        }
        root.value = value;
        return root;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private static class TreeNode<K, V> {
        K key;
        V value;
        TreeNode<K, V> left;
        TreeNode<K, V> right;

        public TreeNode() {
            key = null;
            value = null;
            left = null;
            right = null;
        }

        public TreeNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    public static void main(String[] args) {
        BSTMap<Integer, Integer> map = new BSTMap<>();
        for (int i = 0; i < 10; i++) {
            map.set(i, i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(map.get(i) + " ");
        }
        System.out.println();
        System.out.println(map.remove(5));
        for (int i = 0; i < 10; i++) {
            Integer x = map.get(i);
            if (x != null)
            System.out.print(x + " ");
        }
        System.out.println();
    }

}
