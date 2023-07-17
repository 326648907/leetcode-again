package Array.binarySearch;

public class searchInsert {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + ((right - left) / 2);// 防止溢出 等同于(left + right)/2
            if (nums[mid] == target) return mid;
            if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        searchInsert ts = new searchInsert();
        int[] ls = new int[]{-1,0,3,5,9,12};
        System.out.println(ts.searchInsert(ls,9));
    }
}
