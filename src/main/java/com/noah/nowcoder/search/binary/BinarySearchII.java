package com.noah.nowcoder.search.binary;

/**
 * BinarySearchII.java
 *
 * @author yinzongchang
 * 创建时间 2023/1/30
 * @since 1.0
 */
public class BinarySearchII {

    /**
     * NC105 二分查找-II
     * <a href="https://www.nowcoder.com/practice/4f470d1d3b734f8aaf2afb014185b395?tpId=196&tqId=37163&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%25E4%25BA%258C%25E5%2588%2586%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196&difficulty=undefined&judgeStatus=undefined&tags=&title=%E4%BA%8C%E5%88%86">...</a>
     * <p>
     * 给定一个 元素有序的（升序）长度为n的整型数组 nums 和一个目标值 target，
     * 写一个函数搜索 nums 中的第一个出现的target，如果目标值存在返回下标，否则返回 -1
     * <p>
     * 输入：[1,2,4,4,5],4
     * 返回值：2
     * 说明：从左到右，查找到第1个为4的，下标为2，返回2
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        int res = -1;
        while (left <= right) {

            int mid = (right - left) / 2 + left;

            if (nums[mid] == target) {
                res = mid;
                right = mid - 1;
                continue;
            }

            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }

    /**
     * 找最后一个
     *
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        int res = -1;
        while (left <= right) {

            int mid = (right - left) / 2 + left;

            if (nums[mid] == target) {
                res = mid;
                left = mid + 1;
                continue;
            }

            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 4, 4, 4, 5};
        int target = 4;

        System.out.println(new BinarySearchII().search2(arr, target));
    }


}
