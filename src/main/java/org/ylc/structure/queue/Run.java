package org.ylc.structure.queue;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2019/12/17
 */
public class Run {

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>(5);
        queue.enque("A");
        queue.enque("B");
        queue.enque("C");
        queue.enque("D");
        queue.enque("E");
        queue.enque("F");
        System.out.println("front:" + queue.peekFront());
        System.out.println("rear:" + queue.peekRear());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
    }

}
