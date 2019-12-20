package org.ylc.structure.tree;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2019/12/20
 */
public class Run {

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(9);
        tree.insert(6);
        tree.insert(13);
        tree.insert(5);
        tree.insert(7);
        tree.insert(15);
        tree.insert(12);
        System.out.println("max:" + tree.findMax());
        System.out.println("min:" + tree.findMin());
        System.out.println("exists 9 :" + tree.contains(9));
        tree.printTree();
        System.out.println("remove 9 result:" + tree.remove(9));
        System.out.println("exists 9 :" + tree.contains(9));
        tree.printTree();
    }
}
