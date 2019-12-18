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
        queueTest();
        priorityQueueTest();
    }

    private static void queueTest() {
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

    private static void priorityQueueTest() {
        PriorityQueue<Integer> queue = new PriorityQueue<>(5);
        queue.enque(26);
        System.out.println("插入26，目前顶端数据：" + queue.peekFront());
        queue.enque(13);
        System.out.println("插入13，目前顶端数据：" + queue.peekFront());
        queue.enque(78);
        System.out.println("插入78，目前顶端数据：" + queue.peekFront());
        queue.enque(50);
        System.out.println("插入50，目前顶端数据：" + queue.peekFront());
        queue.enque(11);
        System.out.println("插入11，目前顶端数据：" + queue.peekFront());
        queue.enque(100);
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
    }
}
