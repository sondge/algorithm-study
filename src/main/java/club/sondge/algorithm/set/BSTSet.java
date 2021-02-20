package club.sondge.algorithm.set;

import club.sondge.algorithm.tree.BinarySearchTree;

import java.util.Random;

public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BinarySearchTree<E> searchTree;

    public BSTSet() {
        searchTree = new BinarySearchTree<>();
    }

    @Override
    public void add(E e) {
        searchTree.add(e);
    }

    @Override
    public void remove(E e) {
        searchTree.remove(e);
    }

    @Override
    public boolean contain(E e) {
        return searchTree.contain(e);
    }

    @Override
    public int getSize() {
        return searchTree.size();
    }

    @Override
    public boolean isEmpty() {
        return searchTree.isEmpty();
    }



    public static void main(String[] args) {
        BSTSet<Integer> bstSet = new BSTSet<>();
        for (int i = 0; i < 10; i++) {
            bstSet.add(new Random().nextInt(10000));
        }

        System.out.println(bstSet.getSize());
    }
}
