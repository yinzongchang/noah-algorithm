package com.noah.demo.linkedlist;

/**
 * Title: InsertionSortList.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2022/8/24
 */
public class InsertionSortList {

    /**
     * 147. 对链表进行插入排序
     * 给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。
     *
     * 插入排序 算法的步骤:
     *
     * 1. 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
     * 2. 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
     * 3. 重复直到所有输入数据插入完为止。
     * 下面是插入排序算法的一个图形示例。部分排序的列表(黑色)最初只包含列表中的第一个元素。每次迭代时，从输入数据中删除一个元素(红色)，并就地插入已排序的列表中。
     *
     * 对链表进行插入排序。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/insertion-sort-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode insertionSortList(ListNode head) {


        if (head == null || head.next == null) {
            return head;
        }


        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        // 链表已排序部分的最后一个节点
        ListNode lastSorted = head;

        // 待排序节点
        ListNode curr = head.next;

        while (curr != null) {

            if (lastSorted.val <= curr.val) {

                lastSorted = lastSorted.next;
            } else {

                ListNode prev= dummyNode;

                while (prev.next.val <= curr.val) {

                    prev = prev.next;
                }

                // 此时prev 节点为第一个大于curr.val 的前一个节点
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }

            curr = lastSorted.next;
        }

        return dummyNode.next;
    }


}
