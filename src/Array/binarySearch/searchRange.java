package Array.binarySearch;

public class searchRange {
    public int[] searchRange(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int resleft = -1;
        int resright = -1;
        if (nums.length == 0) return new int[]{resleft,resright};
        while (left <= right){
            int mid = left + ((right - left) / 2);// 防止溢出 等同于(left + right)/2
            if (nums[mid] == target){
                resleft = mid;
                int i = mid;
                while (true){
                    i--;// i 是否超出数组范围
                    if (!isIndexValid(nums,i) || nums[i] != target){
                        break;
                    }else {
                        resleft = i;
                    }
                }
                resright = mid;
                int j =mid;
                while (true){
                    j++;
                    if (!isIndexValid(nums,j) || nums[j] != target){
                        break;
                    }else {
                        resright = j;
                    }
                }
                return new int[]{resleft,resright};
            }
            if (nums[mid] < target) left = mid + 1;
            if (nums[mid] > target) right = mid - 1;
        }
        return new int[]{resleft,resright};
    }
    public static boolean isIndexValid(int[] array, int index) {
        if (index >= 0 && index < array.length) {
            return true; // Index is within the valid range
        } else {
            return false; // Index is out of bounds
        }
    }
    public static void main(String[] args) {
        searchRange ts = new searchRange();
        int[] ls = new int[]{5,7,7,8,8,10};
        System.out.println(ts.searchRange(ls,8));
    }
}
