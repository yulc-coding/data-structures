package org.ylc.structure.stack;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 用链表实现栈，链表没有最大容量，所以实现的栈也没有大小限制
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2019/12/16
 */
public class StackUseLink<E> {

    private LinkList<E> linkList;

    public StackUseLink() {
        this.linkList = new LinkList<>();
    }

    /**
     * 顶端插入数据
     *
     * @param data 数据
     */
    public void push(E data) {
        linkList.insertFirst(data);
    }

    /**
     * 移除顶端数据，并返回移除的数据
     *
     * @return data
     */
    public E pop() {
        return linkList.deleteFirst();
    }

    /**
     * 检查是否为空
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * 内部类实现头插法单链表
     *
     * @param <E>
     */
    private static class LinkList<E> {

        Node<E> first;

        void insertFirst(E data) {
            first = new Node<>(data, first);
        }

        E deleteFirst() {
            if (isEmpty()) {
                System.out.println("删除失败，已经空了");
                return null;
            }
            Node<E> delNode = first;
            first = first.next;
            delNode.next = null;
            return delNode.data;
        }

        boolean isEmpty() {
            return first == null;
        }

        /**
         * 链表节点
         *
         * @param <E>
         */
        private static class Node<E> {
            /**
             * 数据
             */
            E data;

            /**
             * 指向下一个节点
             */
            Node<E> next;

            Node(E data, Node<E> next) {
                this.data = data;
                this.next = next;
            }
        }

    }
}
