package org.ylc.structure.heap;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 最大堆
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2019/12/31
 */
public class MaxHeap<E extends Comparable<E>> {

    /**
     * 队列的最大容量
     */
    private int maxSize;

    /**
     * 当前队列已存在的元素数量
     */
    private int items;

    /**
     * 存储数据的数组
     */
    private Object[] heapArray;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.items = 0;
        this.heapArray = new Object[maxSize];
    }

    public boolean isEmpty() {
        return items == 0;
    }

    public boolean isFull() {
        return items == maxSize;
    }

    /**
     * 插入：
     * 1. 先将节点插入当前堆的最后一个位置；
     * 2. 和父节点对比，如果大于它当前的父节点，父节点的值存入当前位置，将要插入的节点拿出来临时存储；
     * 3. 重复上述对比步骤，直到遇到小于父节点或者处于根节点为止；
     */
    @SuppressWarnings("unchecked")
    public boolean insert(E data) {
        if (isFull()) {
            System.out.println("插入【" + data + "】失败：堆已经满了！！！");
            return false;
        }
        // 空堆，直接插入根节点
        if (isEmpty()) {
            heapArray[items++] = data;
            return true;
        }
        // 获取插入后最后一位的索引，并将数量+1
        int index = items++;
        // 放入临时变量
        E temp = data;
        // 父节点
        E parent;
        // 小于父节点或者到达根节点
        while (index > 0) {
            parent = (E) heapArray[(index - 1) / 2];
            if (temp.compareTo(parent) < 0) {
                break;
            }
            // 父节点位置下移
            heapArray[index] = parent;
            index = (index - 1) / 2;
        }
        heapArray[index] = temp;
        return true;
    }

    /**
     * 删除最大节点
     * 1. 移除根节点；
     * 2. 把最后一个节点（最后一层最右边的节点）移到拿出来临时存储；
     * 3. 从根节点向下筛选，把子节点中大的节点和最后一个节点比较；
     * 4. 重复上述步骤，直到遇到子节点都小于最后一个节点或者没有子节点为止；
     */
    @SuppressWarnings("unchecked")
    public E removeMax() {
        if (isEmpty()) {
            System.out.println("删除失败：堆已经空了！！！");
            return null;
        }
        // 要删除返回的节点
        E root = (E) heapArray[0];
        // 最后一个节点放入临时变量用来对比
        E temp = (E) heapArray[--items];
        // 最终存放临时变量的位置
        int index = 0;
        // 子节点中较大的节点
        int largerChildIndex;
        E largerData;
        /*
         * 确保当前节点至少有一个子节点
         * 即 2*index - 1 <= 最大索引 (items -1)
         * 即 index < items/2
         */
        while (index < items / 2) {
            largerChildIndex = getLargerChildIndex(index);
            largerData = (E) heapArray[largerChildIndex];
            if (temp.compareTo(largerData) >= 0) {
                break;
            }
            // 子节点上移
            heapArray[index] = largerData;
            index = largerChildIndex;
        }
        heapArray[index] = temp;
        return root;
    }

    /**
     * 获取较大子节点的索引
     *
     * @param curIndex 当前节点的索引
     * @return larger index
     */
    @SuppressWarnings("unchecked")
    private int getLargerChildIndex(int curIndex) {
        int rightIndex = 2 * curIndex + 2;
        if (rightIndex > items - 1) {
            return items;
        }
        int leftIndex = 2 * curIndex + 1;
        E leftChild = (E) heapArray[leftIndex];
        E rightChild = (E) heapArray[rightIndex];
        if (rightChild.compareTo(leftChild) > 0) {
            return rightIndex;
        } else {
            return leftIndex;
        }
    }

    /**
     * 按树形结构打印
     */
    public void display() {
        System.out.println();
        System.out.println("array format: ");
        for (Object o : heapArray) {
            System.out.print(o + " ");
        }
        System.out.println();
        System.out.println("tree format: ");
        System.out.println("========================================================================================");
        // 打印空格数
        int blanks = 32;
        // 每一行节点的个数
        int itemsPreRow = 1;
        // 当前节点的序号
        int column = 0;
        // 当前要打印节点的索引
        int printIndex = 0;
        while (items > 0) {
            // 每一行的首个节点
            if (column == 0) {
                for (int i = 0; i < blanks; i++) {
                    System.out.print(" ");
                }
            }
            System.out.print(heapArray[printIndex]);
            // 所有节点已打印完成
            if (++printIndex == items) {
                break;
            }
            // 每一行的所有节点全部打印完成
            if (++column == itemsPreRow) {
                blanks /= 2;
                itemsPreRow *= 2;
                column = 0;
                // 换行
                System.out.println();
            } else {
                for (int i = 0; i < blanks * 2 - 2; i++) {
                    System.out.print(" ");
                }
            }
        }
        System.out.println();
        System.out.println("========================================================================================");
    }
}
