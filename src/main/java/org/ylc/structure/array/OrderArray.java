package org.ylc.structure.array;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * 有序数组
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2019-12-09
 */
public class OrderArray {
    /**
     * 数组体
     */
    private long[] arr;

    /**
     * 当前元素的个数
     */
    private int elemNu;

    public OrderArray(int max) {
        this.arr = new long[max];
        this.elemNu = 0;
    }

    /**
     * 返回元素个数
     *
     * @return size
     */
    public int size() {
        return this.elemNu;
    }

    /**
     * 二分法查询
     *
     * @param elem 目标元素
     * @return 索引
     */
    public int find(long elem) {
        // 查询的下界
        int lowerBound = 0;
        // 查询的上界
        int upperBound = elemNu - 1;
        // 当前查询的索引
        int curIndex;
        while (true) {
            // 每次取中间的数据
            curIndex = (lowerBound + upperBound) / 2;
            //  相等，直接返回索引
            if (this.arr[curIndex] == elem) {
                return curIndex;
            }
            // 查询下界 > 查询上界，说明没有查询到
            if (lowerBound > upperBound) {
                return this.elemNu;
            }
            // 中间值小于目标值，说明目标在后半部分数据中（即大的数据）
            if (this.arr[curIndex] < elem) {
                lowerBound = curIndex + 1;
            } else {
                // 中间值大于目标值，说明目标在前半部分数据中
                upperBound = curIndex - 1;
            }
        }
    }

    /**
     * 新增
     * 可以先用二分查询获取需要插入的位置
     * 插入元素后面的元素后移一位
     *
     * @param elem 新增元素
     */
    public void insert(long elem) {

    }

    /**
     * 删除：
     * 先二分查询索引，不存在直接返回false
     * 存在，删除位后面的元素集体前移一位
     * 元素个数减1
     *
     * @param item 要删除的元素
     * @return boolean
     */
    public boolean delete(long item) {
        int index = find(item);
        if (index == this.elemNu) {
            return false;
        }
        this.elemNu--;
        for (int i = index; i < this.elemNu; i++) {
            this.arr[i] = this.arr[i + 1];
        }
        return true;
    }

}
