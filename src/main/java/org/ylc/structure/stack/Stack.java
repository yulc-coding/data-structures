package org.ylc.structure.stack;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 栈接口
 *
 * @author yulc
 * @version 1.0.0
 * @date 2019/12/16
 */
public interface Stack<E> {

    /**
     * 顶端插入数据
     *
     * @param data 数据
     */
    void push(E data);

    /**
     * 移除顶端数据，并返回移除的数据
     *
     * @return data
     */
    E pop();

    /**
     * 查询顶部数据
     *
     * @return data
     */
    E peek();

    /**
     * 检查是否为空
     *
     * @return boolean
     */
    boolean isEmpty();

    /**
     * 检查是否已经满了
     *
     * @return boolean
     */
    boolean isFull();

}