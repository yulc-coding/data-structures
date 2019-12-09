package org.ylc.structure.array;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * 简单数组
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2019/12/9 21:33
 */
public class Array {
    /**
     * 数组体
     */
    private long[] arr;

    /**
     * 当前元素的个数
     */
    private int elemNu;

    public Array(int max) {
        this.arr = new long[max];
        this.elemNu = 0;
    }

    /**
     * 在当前空闲位新增，并将数组个数+1
     *
     * @param elem 新增的元素
     */
    public void insert(long elem) {
        this.arr[elemNu++] = elem;
    }

    /**
     * 删除首个指定元素：
     * 获取对应元素的索引，元素不存在，直接返回false；
     * 将要删除元素后面的元素往前移动一位
     * 元素个数-1
     *
     * @param elem 要删除的项目
     * @return boolean
     */
    public boolean deleteFirst(long elem) {
        // 要删除元素的索引
        int delIndex;
        for (delIndex = 0; delIndex < this.elemNu; delIndex++) {
            if (elem == this.arr[delIndex]) {
                break;
            }
        }
        // 不存在，直接返回false
        if (delIndex == elem) {
            return false;
        }
        // 元素个数-1
        this.elemNu--;
        // 将后面的元素向前移动一位
        for (int newIndex = delIndex; newIndex < this.elemNu; newIndex++) {
            System.out.println(newIndex);
            this.arr[newIndex] = this.arr[newIndex + 1];
        }
        return true;
    }

    /**
     * 查看数组是否包含了该元素
     * 遍历元素，查看是否有匹配的
     *
     * @param elem 要查的元素
     * @return boolean
     */
    public boolean contains(long elem) {
        int index;
        for (index = 0; index < this.elemNu; index++) {
            if (elem == this.arr[index]) {
                break;
            }
        }
        return index < this.elemNu;
    }

    /**
     * 遍历数组
     */
    public void display() {
        System.out.println(">>>>>>>>>>>>>>>>");
        for (int i = 0; i < this.elemNu; i++) {
            System.out.println(this.arr[i]);
        }
        System.out.println("<<<<<<<<<<<<<<<<");
    }
}
