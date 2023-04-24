package traceback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class permuteUnique {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        Arrays.fill(used,false);
        traceback(nums);
        return res;
    }
    public void traceback(int[] nums){
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
        }
        for (int i = 1; i <= nums.length; i++) {
            if (used[i-1]) continue;
            if (i > 1 && nums[i-1] == nums[i-2] && !used[i-2]) continue;
            path.add(nums[i-1]);
            used[i-1] = true;
            traceback(nums);
            used[i-1] = false;
            path.removeLast();
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        permuteUnique ts = new permuteUnique();
        List<List<Integer>> res = ts.permuteUnique(nums);
        System.out.println(res);
    }
}
