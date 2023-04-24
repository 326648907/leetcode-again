package traceback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class subsets {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        traceback(nums,1);
        return res;
    }
    public void traceback(int[] nums,int start){
        res.add(new ArrayList<>(path));
        for (int i = start; i <= nums.length; i++) {
            path.add(nums[i-1]);
            traceback(nums,i+1);
            path.removeLast();
        }
    }
    public static void main(String[] args) {
        subsets ts = new subsets();
        int[] nums = new int[]{1,2,3};
        System.out.println(ts.subsets(nums));
    }
}
