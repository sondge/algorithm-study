package club.sondge.algorithm.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTree<E extends Comparable<E>> {

    private TreeNode root;
    private int size;

    public BinarySearchTree() {

    }

    private class TreeNode {
        E e;
        TreeNode left;
        TreeNode right;

        public TreeNode(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    private TreeNode add(TreeNode node, E e) {
        if (node == null) {
            node = new TreeNode(e);
            size++;
            return node;
        }
        if (node.e.compareTo(e) < 0) {
            node.right = add(node.right, e);
        }
        if (node.e.compareTo(e) > 0) {
            node.left = add(node.left, e);
        }
        return node;
    }

    public boolean contain(E e) {
        return contain(root, e);
    }

    private boolean contain(TreeNode node, E e) {
        if (node == null) {
            return false;
        }
        if (node.e.compareTo(e) == 0) {
            return true;
        }
        if (node.e.compareTo(e) > 0) {
            return contain(node.left, e);
        }
        return contain(node.right, e);
    }

    public List<E> preOrder() {
        return preOrder(root);
    }

    private List<E> preOrder(TreeNode node) {
        if (node == null) {
            return Collections.emptyList();
        }
        List<E> list = new ArrayList<>();
        list.add(node.e);
        list.addAll(preOrder(node.left));
        list.addAll(preOrder(node.right));
        return list;
    }

    public List<E> inOrder() {
        return inOrder(root);
    }

    private List<E> inOrder(TreeNode node) {
        if (node == null) {
            return Collections.emptyList();
        }
        List<E> list = new ArrayList<>();
        list.addAll(inOrder(node.left));
        list.add(node.e);
        list.addAll(inOrder(node.right));
        return list;
    }

    public List<E> postOrder() {
        return postOrder(root);
    }

    private List<E> postOrder(TreeNode node) {
        if (node == null) {
            return Collections.emptyList();
        }
        List<E> list = new ArrayList<>();
        list.addAll(postOrder(node.left));
        list.addAll(postOrder(node.right));
        list.add(node.e);
        return list;
    }

    public E removeMin() {
        // 1. 找到对应的 min
        TreeNode ret = minimum(root);
        root = removeMin(root);
        return ret.e;
    }

    private TreeNode removeMin(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            TreeNode right = node.right;
            node.right = null;
            size--;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    private TreeNode minimum(TreeNode node) {
        if (size == 0) {
            throw new IllegalArgumentException("Tree is Empty");
        }
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    public E removeMax() {
        // 1. 找到对应的 min
        TreeNode ret = maximum(root);
        root = removeMax(root);
        return ret.e;
    }

    private TreeNode removeMax(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            TreeNode left = node.left;
            node.left = null;
            size--;
            return left;
        }
        node.right = removeMin(node.right);
        return node;
    }

    private TreeNode maximum(TreeNode node) {
        if (size == 0) {
            throw new IllegalArgumentException("Tree is Empty");
        }
        if (node.right == null) {
            return node;
        }
        return minimum(node.right);
    }

}
