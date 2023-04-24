package traceback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class permute {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        traceback(nums,1);
        return res;
    }
    public void traceback(int[] nums,int start){
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= nums.length; i++) {
            path.add(nums[i-1]);
            swap(i-1,start-1,nums);
            traceback(nums,start+1);
            swap(i-1,start-1,nums);
            path.removeLast();
        }
    }
    public void swap(int a, int b,int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        permute ts = new permute();
        System.out.println(ts.permute(nums));
    }
}
