package org.ylc.structure.queue;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 队列
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2019/12/17
 */
public class Queue<E> {

    /**
     * 队列的最大容量
     */
    private int maxSize;

    /**
     * 当前队列已存在的元素数量
     */
    private int items;

    /**
     * 队头
     */
    private int front;

    /**
     * 队尾
     */
    private int rear;

    /**
     * 存储数据的数组
     */
    private Object[] array;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        this.array = new Object[maxSize];
        this.front = 0;
        this.rear = -1;
        this.items = 0;
    }

    /**
     * 入队
     * 校验是否满了
     * 如果当前队尾指向数组最后一位，删除后需要循环数组，将队尾指向数组头部
     *
     * @param data 数据
     */
    public void enque(E data) {
        if (isFull()) {
            System.out.println("新增" + data + "失败：队列已经满啦！！！");
            return;
        }
        if (rear == maxSize - 1) {
            rear = -1;
        }
        array[++rear] = data;
        items++;
    }

    /**
     * 出队
     * 校验是否是空队列
     * 如果当前队头指向数组最后一位，新增后需要循环数组，将队头执行数组头部
     *
     * @return 队头数据
     */
    @SuppressWarnings("unchecked")
    public E deque() {
        if (isEmpty()) {
            System.out.println("删除失败：队列已经空啦！！！");
            return null;
        }
        E frontData = (E) array[front++];
        if (front == maxSize) {
            front = 0;
        }
        items--;
        return frontData;
    }

    /**
     * 查看队头元素
     *
     * @return E
     */
    @SuppressWarnings("unchecked")
    public E peekFront() {
        return (E) array[front];
    }

    /**
     * 查看队尾元素
     *
     * @return E
     */
    @SuppressWarnings("unchecked")
    public E peekRear() {
        return (E) array[rear];
    }

    public boolean isFull() {
        return this.items == this.maxSize;
    }

    public boolean isEmpty() {
        return this.items == 0;
    }

}
