package org.ylc.structure.stack;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 用链表实现栈
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2019/12/16
 */
public class StackUseLink<E> implements Stack<E> {

    /**
     * 顶端插入数据
     *
     * @param data 数据
     */
    @Override
    public void push(E data) {

    }

    /**
     * 移除顶端数据，并返回移除的数据
     *
     * @return data
     */
    @Override
    public E pop() {
        return null;
    }

    /**
     * 查询顶部数据
     *
     * @return data
     */
    @Override
    public E peek() {
        return null;
    }

    /**
     * 检查是否为空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * 检查是否已经满了
     *
     * @return boolean
     */
    @Override
    public boolean isFull() {
        return false;
    }
}
