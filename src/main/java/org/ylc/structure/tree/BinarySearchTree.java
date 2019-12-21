package org.ylc.structure.tree;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 二叉搜索树
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2019/12/18
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private TreeNode<E> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public TreeNode<E> find(E data) {
        TreeNode<E> curNode = root;
        int compareResult;
        while (true) {
            compareResult = data.compareTo(curNode.data);
            if (compareResult == 0) {
                break;
            }
            if (compareResult < 0) {
                curNode = curNode.leftChild;
            } else {
                curNode = curNode.rightChild;
            }
            if (curNode == null) {
                return null;
            }
        }
        return curNode;
    }

    public void insert(E data) {
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

    public boolean remove(E data) {
        if (isEmpty()) {
            return false;
        }

        TreeNode<E> parentNode;
        TreeNode<E> delNode = root;
        boolean isLeftNode = true;
        int compare;
        // 找到要删除的节点
        while (true) {
            parentNode = delNode;
            compare = data.compareTo(delNode.data);
            if (compare == 0) {
                break;
            }
            if (compare < 0) {
                isLeftNode = true;
                delNode = delNode.leftChild;
            } else {
                isLeftNode = false;
                delNode = delNode.rightChild;
            }
            if (delNode == null) {
                System.out.println(String.format("删除失败，没有当前数据【%s】", data));
                return false;
            }
        }
        // 1、没有子节点
        if (delNode.leftChild == null && delNode.rightChild == null) {
            // 删除根目录
            if (delNode == root) {
                this.root = null;
                return true;
            }
            if (isLeftNode) {
                parentNode.leftChild = null;
            } else {
                parentNode.rightChild = null;
            }
        } else if (delNode.rightChild == null) {
            // 2.1 只有左节点
            if (delNode == root) {
                root = delNode.leftChild;
            } else {
                if (isLeftNode) {
                    parentNode.leftChild = delNode.leftChild;
                } else {
                    parentNode.rightChild = delNode.leftChild;
                }
            }
        } else if (delNode.leftChild == null) {
            // 2.2 只有右节点
            if (delNode == root) {
                root = delNode.rightChild;
            } else {
                if (isLeftNode) {
                    parentNode.leftChild = delNode.rightChild;
                } else {
                    parentNode.rightChild = delNode.rightChild;
                }
            }
        } else {
            // 有2个子节点，先获取代替删除节点的节点
            TreeNode<E> successor = getSuccessor(delNode);
            if (delNode == root) {
                root = successor;
            } else {
                if (isLeftNode) {
                    parentNode.leftChild = successor;
                } else {
                    parentNode.rightChild = successor;
                }
            }
        }
        return true;
    }

    public boolean contains(E data) {
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
    public E findMin() {
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
    public E findMax() {
        if (isEmpty()) {
            return null;
        }
        TreeNode<E> curNode = root;
        while (curNode.rightChild != null) {
            curNode = curNode.rightChild;
        }
        return curNode.data;
    }

    /**
     * 中序打印
     */
    public void printTree() {
        print(root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 获取代替删除节点的节点
     * 第一个比删除节点值大的元素
     * 即删除节点右节点的左子孙节点
     *
     * @param delNode 要删除的元素
     * @return node
     */
    private TreeNode<E> getSuccessor(TreeNode<E> delNode) {
        // 要代替删除节点的节点
        TreeNode<E> successor = delNode;
        // 代替节点的父节点
        TreeNode<E> successorParent = delNode;
        TreeNode<E> curNode = delNode.rightChild;
        while (curNode != null) {
            successorParent = successor;
            successor = curNode;
            curNode = curNode.leftChild;
        }
        // 删除节点的右节点存在左子节点
        if (successor != delNode.rightChild) {
            // 上移代替节点的右子节点
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        // 代替节点的左子节点执行删除节点的左子节点
        successor.leftChild = delNode.leftChild;
        return successor;
    }

    private void print(TreeNode<E> node) {
        if (node != null) {
            print(node.leftChild);
            System.out.println(node.data);
            print(node.rightChild);
        }
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
