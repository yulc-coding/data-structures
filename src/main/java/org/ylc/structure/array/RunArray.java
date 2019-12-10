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
        // arrayRun();

        orderArrayRun();
    }

    private static void arrayRun() {
        System.out.println("======== array begin ========");
        Array arr = new Array(5);
        arr.insert(17);
        arr.insert(55);
        arr.insert(55);
        arr.insert(17);
        arr.insert(19);

        arr.display();
        System.out.println("是否包含元素[17]：" + arr.contains(17));
        System.out.println("删除单个元素[17]：" + arr.deleteOne(17));
        System.out.println("是否包含元素[17]：" + arr.contains(17));

        System.out.println("删除所有[55]：" + arr.deleteAll(55));
        System.out.println("是否包含元素[55]：" + arr.contains(55));

        System.out.println("删除所有[66]：" + arr.deleteAll(66));
        arr.display();
        System.out.println("======== array end ========");
    }

    private static void orderArrayRun() {
        System.out.println("======== order begin ========");
        OrderArray array = new OrderArray(8);
        array.insert(11);
        array.insert(20);
        array.insert(13);
        array.insert(15);
        array.insert(30);
        array.insert(18);
        array.insert(18);
        array.insert(15);
        array.display();
        // [11, 13, 15, 15, 18, 18, 20, 30]   index = 2,3
        System.out.println("【15】的位置:" + array.find(15, false));
        System.out.println("删除首次找到的元素【15】：" + array.deleteOne(15));
        // [11, 13, 15, 18, 18, 20, 30]    index = 2
        System.out.println("删除后【15】的位置:" + array.find(15, false));

        array.display();
        // index = 3,4
        System.out.println("【18】的位置:" + array.find(18, false));
        System.out.println("删除所有找到的元素【18】：" + array.deleteAll(18));
        // [11, 13, 15, 20, 30]
        System.out.println("删除后【18】的位置:" + array.find(18, false));

        array.display();
        System.out.println("======== order end ========");
    }
}
