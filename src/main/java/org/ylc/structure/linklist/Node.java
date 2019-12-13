package org.ylc.structure.linklist;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 链表节点
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2019/12/12
 */
public class Node<E> {

    /**
     * 数据
     */
    private E data;

    /**
     * 指向下一个节点
     */
    private Node<E> next;

    /**
     * 指向上一节点
     */
    private Node<E> prev;

    public Node(Node<E> prev, E data, Node<E> next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }
}
