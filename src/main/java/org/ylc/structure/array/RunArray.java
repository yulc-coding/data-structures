package org.ylc.structure.array;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * 运行
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2019-12-09
 */
public class RunArray {
    public static void main(String[] args) {
        arrayRun();
        orderArrayRun();
    }

    private static void arrayRun() {
        Array arr = new Array(11);
        arr.insert(11);
        arr.insert(13);
        arr.insert(15);
        arr.insert(17);
        arr.insert(19);
        arr.insert(21);
        arr.insert(23);
        arr.insert(25);
        arr.insert(27);
        arr.insert(29);

        arr.display();
        System.out.println(arr.contains(25));
        arr.deleteFirst(25);
        System.out.println(arr.contains(25));
        arr.display();
    }

    private static void orderArrayRun() {

    }
}
