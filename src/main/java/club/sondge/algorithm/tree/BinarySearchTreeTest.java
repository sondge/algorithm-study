package club.sondge.algorithm.tree;

import java.util.Random;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        Random random = new Random();
        int x = 0;
        for (int i = 0; i < 10; i++) {
            x = random.nextInt(100);
            tree.add(x);
        }
        System.out.println(tree.contain(8));
        System.out.println(tree.contain(10));
        System.out.println(tree.size());
//        System.out.println(tree.preOrder());
        System.out.println("未删除" + tree.inOrder());
//        System.out.println(tree.postOrder());
        System.out.println(tree.removeMin());
        System.out.println("删除最小的" + tree.inOrder());
        System.out.println(tree.removeMax());
        System.out.println("删除最大的" + tree.inOrder());
        tree.remove(x);
        System.out.println("删除x = " + x + ":" + tree.inOrder());

    }
}
