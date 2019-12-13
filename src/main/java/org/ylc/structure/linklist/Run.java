package org.ylc.structure.linklist;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 执行入口
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2019/12/13
 */
public class Run {

    public static void main(String[] args) {
        insertFirst();
        System.out.println("####");
        insertLast();
        System.out.println("####");
        insert(3, "3");
        System.out.println("####");
        delFirst();
        System.out.println("####");
        delLast();
        System.out.println("####");
        del(3);
    }

    private static void insertFirst() {
        System.out.println(">>>>>> insertFirst >>>>>>");
        LinkList<String> list = new LinkList<>();
        list.insertFirst("a");
        list.insertFirst("b");
        list.insertFirst("c");
        list.insertFirst("d");
        list.insertFirst("e");
        list.insertFirst("f");
        list.display();
        System.out.println("<<<<<< insertFirst <<<<<<");
    }

    private static void insertLast() {
        System.out.println(">>>>>> insertLast >>>>>>");
        LinkList<String> list = new LinkList<>();
        list.insertLast("a");
        list.insertLast("b");
        list.insertLast("c");
        list.insertLast("d");
        list.insertLast("e");
        list.insertLast("f");
        list.display();
        System.out.println("<<<<<< insertLast <<<<<<");
    }

    private static void insert(int index, String data) {
        System.out.println(">>>>>> insert >>>>>>");
        System.out.println("insert index:" + index + ",data:" + data);
        LinkList<String> list = new LinkList<>();
        list.insertLast("a");
        list.insertLast("b");
        list.insertLast("c");
        list.insertLast("d");
        list.insertLast("e");
        list.insertLast("f");
        list.display();
        list.insert(index, data);
        list.display();
        System.out.println("<<<<<< insert <<<<<<");
    }

    private static void delFirst() {
        System.out.println(">>>>>> delFirst >>>>>>");
        LinkList<String> list = new LinkList<>();
        list.insertFirst("a");
        list.insertFirst("b");
        list.insertFirst("c");
        list.insertFirst("d");
        list.insertFirst("e");
        list.insertFirst("f");
        list.display();
        list.delFirst();
        list.delFirst();
        list.delFirst();
        list.delFirst();
        list.display();
        System.out.println("<<<<<< delFirst <<<<<<");
    }

    private static void delLast() {
        System.out.println(">>>>>> delLast >>>>>>");
        LinkList<String> list = new LinkList<>();
        list.insertFirst("a");
        list.insertFirst("b");
        list.insertFirst("c");
        list.insertFirst("d");
        list.insertFirst("e");
        list.insertFirst("f");
        list.display();
        list.delLast();
        list.delLast();
        list.delLast();
        list.delLast();
        list.display();
        System.out.println("<<<<<< delLast <<<<<<");
    }

    private static void del(int index) {
        System.out.println(">>>>>> delLast >>>>>>");
        System.out.println("del index:" + index);
        LinkList<String> list = new LinkList<>();
        list.insertLast("a");
        list.insertLast("b");
        list.insertLast("c");
        list.insertLast("d");
        list.insertLast("e");
        list.insertLast("f");
        list.display();
        list.del(index);
        list.display();
        System.out.println("<<<<<< delLast <<<<<<");
    }
}
