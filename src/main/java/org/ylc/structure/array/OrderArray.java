package org.ylc.structure.array;

import com.sun.org.apache.xpath.internal.operations.String;

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
     * 最大索引为 elemNu -1
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
     * 核心功能：二分法查询，新增、删除都调用
     * 查询和删除的时候，如果目标元素不存在，返回-1
     * 新增的时候，
     * -- 如果要插入的元素存在，则返回元素的索引
     * -- 如果不存在，则返回最终定位的索引
     *
     * @param elem     目标元素
     * @param isInsert 是否用于新增
     * @return 索引
     */
    public int find(long elem, boolean isInsert) {
        // 查询的下界
        int lowerBound = 0;
        // 查询的上界
        int upperBound = this.elemNu - 1;
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
                // 新增，返回最终定位的索引
                if (isInsert) {
                    return curIndex;
                }
                return -1;
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
     * 新增 （比普通数组效率低）
     * 先判断是否是添加在头尾的，是的直接添加
     * 不是在头尾的，可以先用二分查询获取需要插入的位置
     * 插入位置后面的的元素后移一位
     *
     * @param elem 新增元素
     */
    public void insert(long elem) {
        // 要插入的索引
        int insertIndex;
        if (this.elemNu == 0 || elem < this.arr[0]) {
            // 在头部插入
            insertIndex = 0;
        } else if (elem > this.arr[this.elemNu - 1]) {
            // 在尾部插入
            insertIndex = this.elemNu;
        } else {
            // 在中间插入
            insertIndex = find(elem, true);
            // 定位点的元素比目标元素小，插入点往后移动一位
            if (this.arr[insertIndex] < elem) {
                insertIndex++;
            }
        }
        // 元素数量+1
        this.elemNu++;
        // 插入位置后面的元素往后以一个位置，防止原来的数据被覆盖从尾部开始移动
        for (int newIndex = this.elemNu - 1; newIndex > insertIndex; newIndex--) {
            this.arr[newIndex] = this.arr[newIndex - 1];
        }
        // 插入目标元素
        this.arr[insertIndex] = elem;
    }

    /**
     * 删除一个元素：
     * 先二分查询索引，不存在直接返回false
     * 存在，删除位后面的元素集体前移一位
     * 元素个数减1
     *
     * @param item 要删除的元素
     * @return boolean
     */
    public boolean deleteOne(long item) {
        int index = find(item, false);
        if (index == this.elemNu) {
            return false;
        }
        this.elemNu--;
        for (int i = index; i < this.elemNu; i++) {
            this.arr[i] = this.arr[i + 1];
        }
        return true;
    }

    /**
     * 删除所有的目标元素
     * 元素是有序的，查询的到元素位置的前后可能也是相同的元素，
     * 因此需要获取到首个目标元素的索引，以及目标元素的个数N，
     * 然后从首个元素的位置开始将后面的元素前移N位。
     *
     * @param elem 要删除的元素
     * @return boolean
     */
    public boolean deleteAll(long elem) {
        // 查询到的目标元素索引
        int findIndex = find(elem, false);
        if (findIndex < 0) {
            return false;
        }
        // 目标元素的首位索引
        int startIndex = findIndex;
        // 目标元素的末位索引
        int endIndex = findIndex;
        // 要删除的数据个数
        int delNu = 1;
        // 定位开始索引
        while (startIndex > 0 && this.arr[startIndex - 1] == elem) {
            startIndex--;
            delNu++;
        }
        // 定位结束索引
        while (endIndex < this.elemNu - 1 && this.arr[endIndex + 1] == elem) {
            endIndex++;
            delNu++;
        }
        // 总元素减少
        this.elemNu -= delNu;
        // 后面的数据前移N位
        for (int newIndex = startIndex; newIndex < this.elemNu; newIndex++) {
            this.arr[newIndex] = this.arr[++endIndex];
        }
        return true;
    }

    /**
     * 展示
     */
    public void display() {
        System.out.println(">>>>>>>>>>>>>>>>");
        System.out.println("size:" + this.elemNu);
        StringBuilder strArray = new StringBuilder("[");
        for (int i = 0; i < this.elemNu; i++) {
            strArray.append(this.arr[i]);
            strArray.append(", ");
        }
        strArray.append("]");
        System.out.println(strArray.toString());
        System.out.println("<<<<<<<<<<<<<<<<");
    }
}
