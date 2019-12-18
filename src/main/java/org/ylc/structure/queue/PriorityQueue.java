package org.ylc.structure.queue;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * 优先级队列（数组实现）
 * 优先级最高的永远在队头，即下标为 items-1 处
 * 优先级最低的永远在队尾，即数组下标为 0 处
 * 这里指定参数必须为实现Comparable接口的类，用于比较优先级
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2019-12-17
 */
public class PriorityQueue<E extends Comparable<E>> {

    /**
     * 队列的最大容量
     */
    private int maxSize;

    /**
     * 当前队列已存在的元素数量
     */
    private int items;

    /**
     * 存储数据的数组
     */
    private Object[] array;

    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        this.array = new Object[maxSize];
        this.items = 0;
    }

    /**
     * 入队
     * 校验是否已满
     * 从队列顶部开始比较，优先级比插入数据大的，索引位置+1
     */
    @SuppressWarnings("unchecked")
    public void enque(E data) {
        if (isFull()) {
            System.out.println("新增" + data + "失败：队列已经满啦！！！");
            return;
        }
        // 要插入的索引位置
        int index;
        for (index = items - 1; index >= 0; index--) {
            // 插入数据的优先级大于当前元素，在当前元素后面插入
            if (data.compareTo((E) array[index]) >= 0) {
                break;
            }
            // 优先级比插入元素大的数据往后移一位
            array[index + 1] = array[index];
        }
        // 插入数据
        array[index + 1] = data;
        items++;
    }

    /**
     * 出队
     * 校验队列是否为空
     * 优先级最高的永远在队列顶部，items-1处
     */
    @SuppressWarnings("unchecked")
    public E deque() {
        if (isEmpty()) {
            System.out.println("删除失败：队列已经空啦！！！");
            return null;
        }
        return (E) array[--items];
    }

    /**
     * 查看优先级最高的元素
     */
    @SuppressWarnings("unchecked")
    public E peekFront() {
        return (E) array[items - 1];
    }

    public boolean isFull() {
        return this.items == this.maxSize;
    }

    public boolean isEmpty() {
        return this.items == 0;
    }
}
