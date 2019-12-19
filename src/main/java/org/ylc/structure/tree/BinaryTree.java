package org.ylc.structure.tree;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 二叉树
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2019/12/18
 */
public class BinaryTree<E extends Comparable<E>> {

    private TreeNode<E> root;

    public BinaryTree() {
        this.root = null;
    }

    private void insert(E data) {
        TreeNode<E> newNode = new TreeNode<>(data, null, null);
        if (root == null) {
            this.root = newNode;
            return;
        }
        TreeNode<E> parentNode = root;
        int compare;
        while (true) {
            compare = data.compareTo(parentNode.data);
            // 左节点
            if (compare < 0) {
                if (parentNode.leftChild == null) {
                    parentNode.leftChild = newNode;
                    return;
                } else {
                    parentNode = parentNode.leftChild;
                }
            } else if (compare > 0) {
                // 右节点
                if (parentNode.rightChild == null) {
                    parentNode.rightChild = newNode;
                    return;
                } else {
                    parentNode = parentNode.rightChild;
                }
            } else {
                System.out.println(String.format("已存在相同元素【%s】", data));
                return;
            }
        }
    }

    private boolean remove(E data) {
        if (isEmpty()) {
            return false;
        }

        TreeNode<E> parentNode;
        TreeNode<E> curNode = root;
        boolean isLeftNode = true;
        int compare;
        while (true) {
            parentNode = curNode;
            compare = data.compareTo(curNode.data);
            if (compare == 0) {
                break;
            }
            if (compare < 0) {
                isLeftNode = true;
                curNode = curNode.leftChild;
            } else {
                isLeftNode = false;
                curNode = curNode.rightChild;
            }
            if (curNode == null) {
                System.out.println(String.format("删除失败，没有当前数据【%s】", data));
                return false;
            }
        }
        // 1、没有子节点
        if (curNode.leftChild == null && curNode.rightChild == null) {
            // 删除根目录
            if (curNode == root) {
                this.root = null;
                return true;
            }
            if (isLeftNode) {
                parentNode.leftChild = null;
            } else {
                parentNode.rightChild = null;
            }
        } else if (curNode.rightChild == null) {
            if (curNode == root) {
                root = curNode.leftChild;
            } else {
                if (isLeftNode) {
                    parentNode.leftChild = curNode.leftChild;
                } else {
                    parentNode.rightChild = curNode.leftChild;
                }
            }
        } else if (curNode.leftChild == null) {
            if (curNode == root) {
                root = curNode.rightChild;
            } else {
                if (isLeftNode) {
                    parentNode.leftChild = curNode.rightChild;
                } else {
                    parentNode.rightChild = curNode.rightChild;
                }
            }
        }

        return true;
    }

    private boolean contains(E data) {
        if (isEmpty()) {
            return false;
        }
        TreeNode<E> curNode = root;
        int compareResult;
        while (true) {
            compareResult = data.compareTo(curNode.data);
            if (compareResult == 0) {
                return true;
            } else if (compareResult < 0) {
                curNode = curNode.leftChild;
            } else {
                curNode = curNode.rightChild;
            }
            if (curNode == null) {
                return false;
            }
        }
    }

    /**
     * 获取最小值
     *
     * @return 最左边的节点值
     */
    private E findMin() {
        if (isEmpty()) {
            return null;
        }
        TreeNode<E> curNode = root;
        while (curNode.leftChild != null) {
            curNode = curNode.leftChild;
        }
        return curNode.data;
    }

    /**
     * 获取最大值
     *
     * @return 最右边的节点值
     */
    private E findMax() {
        if (isEmpty()) {
            return null;
        }
        TreeNode<E> curNode = root;
        while (curNode.rightChild != null) {
            curNode = curNode.rightChild;
        }
        return curNode.data;
    }

    private boolean isEmpty() {
        return root == null;
    }

    private static class TreeNode<E> {

        E data;

        TreeNode<E> leftChild;

        TreeNode<E> rightChild;

        public TreeNode(E data, TreeNode<E> leftChild, TreeNode<E> rightChild) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }
}
