package traceback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class permute_1 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return res;
        used = new boolean[nums.length];
        Arrays.fill(used,false);
        traceback(nums);
        return res;
    }
    public void traceback(int[] nums){
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 1; i <= nums.length; i++) {
            if (used[i-1]){
                continue;
            }
            path.add(nums[i-1]);
            used[i-1] = true;
            traceback(nums);
            used[i-1] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        permute_1 ts = new permute_1();
        List<List<Integer>> res = ts.permute(nums);
        System.out.println(res);
    }
}
