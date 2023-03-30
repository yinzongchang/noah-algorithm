package com.noah.nowcoder.search.binary;

/**
 * BinarySearch.java
 *
 * @author yinzongchang
 * 创建时间 2023/1/30
 * @since 1.0
 */
public class BinarySearch {


    /**
     * BM17 二分查找-I
     * <p>
     * <a href="https://www.nowcoder.com/practice/d3df40bd23594118b57554129cadf47b?tpId=295&tqId=1499549&ru=%2Fpractice%2Fd3df40bd23594118b57554129cadf47b&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj">...</a>
     * <p>
     * 请实现无重复数字的升序数组的二分查找
     * <p>
     * 给定一个 元素升序的、无重复数字的整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，
     * 如果目标值存在返回下标（下标从 0 开始），否则返回 -1
     * <p>
     * 输入：[-1,0,3,4,6,10,13,14],13
     * 返回值：6
     * <p>
     * 说明：13 出现在nums中并且下标为 6
     *
     * @param nums   int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

//            int mid = (left + right) / 2;
            int mid = (right - left) / 2 + left;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }


//    @Test
//    public void test() {
//
//        int[] arr = {-1, 0, 3, 4, 6, 10, 13, 14};
//        int target = 13;
//
//        System.out.println(new BinarySearch().search(arr, target));
//    }
}
