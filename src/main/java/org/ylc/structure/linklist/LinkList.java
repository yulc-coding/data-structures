package org.ylc.structure.linklist;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 链表
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2019/12/12
 */
public class LinkList<E> {

    /**
     * 链表大小
     */
    private int size;

    /**
     * 首个节点的引用
     */
    private Node<E> first;

    /**
     * 最后一个节点的引用
     */
    private Node<E> last;

    public LinkList() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    /**
     * 在首位插入
     * 空的，首节点和末节点都指向新节点；
     * 新节点的next指向原来首节点，
     * 原来首节点存在的prev指向新节点
     *
     * @param data 数据
     */
    public void insertFirst(E data) {
        // 新节点 next 为原来第一个节点，prev 为 null
        Node<E> newNode = new Node<>(null, data, this.first);
        // 空的，需要将最后的节点也指向新的节点
        if (this.first == null) {
            this.last = newNode;
        } else {
            this.first.setPrev(newNode);
        }
        this.first = newNode;
        this.size++;
    }

    /**
     * 在末尾插入
     * 空的，首节点和末节点都指向新节点；
     * 新节点的prev指向原来尾节点，
     * 原来尾节点存在的next指向新节点
     *
     * @param data 数据
     */
    public void insertLast(E data) {
        // 新节点 prev 为原来最后一个节点，next 为 null
        Node<E> newNode = new Node<>(this.last, data, null);
        if (this.first == null) {
            this.first = newNode;
        } else {
            this.last.setNext(newNode);
        }
        this.last = newNode;
        this.size++;
    }

    /**
     * 在目标节点前添加
     *
     * @param data    数据
     * @param tagNode 目标节点
     */
    public void insertBefore(E data, Node<E> tagNode) {
        // 前置节点
        Node<E> prevNode = tagNode.getPrev();
        // 新节点的前置节点为目标节点的前置节点，后置节点为目标节点
        Node<E> newNode = new Node<>(prevNode, data, tagNode);
        // 重置next节点
        prevNode.setNext(newNode);
        // 重置prev节点
        tagNode.setPrev(newNode);
        this.size++;
    }

    /**
     * 在指定位置插入
     *
     * @param index 索引
     * @param data  数据
     */
    public void insert(int index, E data) {
        if (index < 0 || index > this.size) {
            System.out.println("插入失败：数组越界啦！！！");
            return;
        }
        if (index == 0) {
            // 在头部插入
            this.insertFirst(data);
        } else if (index == size) {
            // 在尾部插入
            this.insertLast(data);
        } else {
            // 在中间插入
            insertBefore(data, getNode(index));
        }
    }

    /**
     * 删除头部数据
     * 只有一个节点的删除后，将最后节点引用设为null；
     * 首个节点的引用设为原来第二个节点
     * 原来第二个节点的前置节点设为null
     */
    public void delFirst() {
        Node<E> fNode = this.first;
        if (fNode == null) {
            System.out.println("删除失败，这是个空链表！！！");
            return;
        }
        Node<E> sNode = fNode.getNext();
        fNode.setData(null);
        // 去除引用，用于GC
        fNode.setNext(null);
        // 重置首个节点
        this.first = sNode;
        // 链表只有1个节点的，删除后最后一个节点指向null
        if (sNode == null) {
            this.last = null;
        } else {
            // 重置prev节点
            sNode.setPrev(null);
        }
        this.size--;
    }

    /**
     * 删除尾部
     * 只有一个节点的删除后，将首个节点引用设为null；
     * 最后一个节点的引用设为原来倒数第二个节点
     * 原来倒数第二个节点的后置节点设为null
     */
    public void delLast() {
        Node<E> lNode = this.last;
        if (lNode == null) {
            System.out.println("删除失败，这是个空链表！！！");
            return;
        }
        Node<E> prevNode = lNode.getPrev();
        lNode.setData(null);
        lNode.setPrev(null);
        this.last = prevNode;
        if (prevNode == null) {
            this.first = null;
        } else {
            prevNode.setNext(null);
        }
        this.size--;
    }


    /**
     * 删除指定的节点
     *
     * @param delNode 删除节点
     */
    public void del(Node<E> delNode) {
        Node<E> prevNode = delNode.getPrev();
        Node<E> nextNode = delNode.getNext();
        // 先处理左边2个引用关系
        if (prevNode == null) {
            // 删除首个
            this.first = nextNode;
        } else {
            prevNode.setNext(nextNode);
            delNode.setPrev(null);
        }
        // 再处理右边2个引用关系
        if (nextNode == null) {
            // 删除尾部节点
            this.last = prevNode;
        } else {
            nextNode.setPrev(prevNode);
            delNode.setNext(null);
        }
        delNode.setData(null);
        this.size--;
    }

    /**
     * 删除指定索引的数据
     *
     * @param index 索引
     */
    public void del(int index) {
        if (index < 0 || index > this.size) {
            System.out.println("删除失败：数组越界啦！！！");
            return;
        }
        del(getNode(index));
    }

    public void display() {
        System.out.println("size:" + this.size);
        StringBuilder str = new StringBuilder("[");
        Node<E> node = this.first;
        for (int i = 0; i < this.size; i++) {
            str.append(node.getData());
            str.append(",");
            node = node.getNext();
        }
        str.append("]");
        System.out.println(str.toString());
    }

    /**
     * 获取指定位置的节点
     *
     * @param index 索引
     * @return node
     */
    private Node<E> getNode(int index) {
        // 对半比较，减少循环次数
        if (index < (this.size >> 1)) {
            // 位于前半部分，从前面开始循环
            Node<E> node = this.first;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
            return node;
        } else {
            // 后半部分开始循环
            Node<E> node = this.last;
            for (int i = this.size - 1; i > index; i--) {
                node = node.getPrev();
            }
            return node;
        }
    }


}
