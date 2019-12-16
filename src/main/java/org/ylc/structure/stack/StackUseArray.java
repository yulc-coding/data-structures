package org.ylc.structure.stack;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * 用数组实现栈
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2019-12-15
 */
public class StackUseArray<E> implements Stack<E> {

    // 最大容量
    private int maxSize;

    // 数据数组
    private Object[] array;

    // 执行栈顶
    private int top;

    public StackUseArray(int maxSize) {
        this.maxSize = maxSize;
        this.array = new Object[maxSize];
        this.top = -1;
    }

    /**
     * 顶端插入数据
     *
     * @param data 数据
     */
    @Override
    public void push(E data) {
        if (isFull()) {
            System.out.println("栈已满，不能再添加了！！！");
            return;
        }
        this.array[++this.top] = data;
    }

    /**
     * 移除顶端数据，并返回移除的数据
     *
     * @return data
     */
    @SuppressWarnings("unchecked")
    @Override
    public E pop() {
        if (isEmpty()) {
            System.out.println("栈已空了，不能再删除了！！！");
            return null;
        }
        return (E) this.array[this.top--];
    }

    /**
     * 查询顶部数据
     *
     * @return data
     */
    @SuppressWarnings("unchecked")
    @Override
    public E peek() {
        if (isEmpty()) {
            System.out.println("这是个空栈！！！");
            return null;
        }
        return (E) this.array[this.top];
    }

    /**
     * 检查是否为空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return this.top == -1;
    }

    /**
     * 检查是否已经满了
     *
     * @return boolean
     */
    @Override
    public boolean isFull() {
        return this.top == (this.maxSize - 1);
    }

}
