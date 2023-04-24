package traceback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class subsetsWithDup {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        traceback(nums,1);
        return res;
    }
    public void traceback(int[] nums, int start){
        res.add(new ArrayList<>(path));
        for (int i = start; i <= nums.length; i++) {
            if(i > start && nums[i-1] == nums[i-2]){
                continue;
            }
            path.add(nums[i-1]);
            traceback(nums,i+1);
            path.removeLast();
        }
    }
    public static void main(String[] args) {
        subsetsWithDup ts = new subsetsWithDup();
        int[] nums = new int[]{1,2,2};
        System.out.println(ts.subsetsWithDup(nums));
    }
}
