package Array.binarySearch;

import java.util.Arrays;

public class re_searchRange {
    int[] re_searchRange(int[] nums, int target) {
        int leftBorder = leftBound(nums, target);
        int rightBorder = rightBound(nums, target);
        return new int[]{leftBorder, rightBorder};
    }
    public int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left - (left - right) / 2;
            // 向左收缩
            if (nums[mid] == target) right = mid - 1;
            else if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
        }
        if (left == nums.length || nums[left] != target) return -1;
        return left;
    }
    public int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left - (left - right) / 2;
            // 向右收缩
            if (nums[mid] == target) left = mid + 1;
            else if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
        }
        // 结束情况 : right = left - 1
        // 未找到的情况
        if (right < 0 || nums[right] != target) return -1;
        return right;
    }
    public static void main(String[] args) {
        re_searchRange ts = new re_searchRange();
        int[] ls = new int[]{5,7,7,8,8,10};
        System.out.println(Arrays.toString(ts.re_searchRange(ls,1)));
    }
}
