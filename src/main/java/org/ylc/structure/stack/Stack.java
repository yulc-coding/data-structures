package org.ylc.structure.stack;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * 栈
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2019-12-15
 */
public class Stack<E> {

    private int maxSize;

    private Object[] array;

    private int top;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.array = new Object[maxSize];
        this.top = -1;
    }

    public void push(E data) {
        this.array[++this.top] = data;
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        return (E) this.array[this.top--];
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        return (E) this.array[this.top];
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return this.top == (this.maxSize - 1);
    }

}
