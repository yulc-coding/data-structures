package org.ylc.structure.heap;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2019/12/31
 */
public class Run {

    public static void main(String[] args) {
        MaxHeap<Integer> heap = new MaxHeap<>(10);
        heap.insert(30);
        heap.insert(35);
        heap.insert(20);
        heap.insert(99);
        heap.insert(80);
        heap.insert(50);
        heap.insert(65);
        heap.insert(21);
        heap.insert(15);
        heap.insert(88);
        heap.insert(99);
        heap.display();
        System.out.println(heap.removeMax());
        System.out.println(heap.removeMax());
        System.out.println(heap.removeMax());
        System.out.println(heap.removeMax());
        System.out.println(heap.removeMax());
        System.out.println(heap.removeMax());
        System.out.println(heap.removeMax());
        System.out.println(heap.removeMax());
        System.out.println(heap.removeMax());
        System.out.println(heap.removeMax());
        System.out.println(heap.removeMax());
    }
}
