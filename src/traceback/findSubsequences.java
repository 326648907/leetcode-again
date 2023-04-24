package traceback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
// todo 横向去重
public class findSubsequences {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        traceback(nums,1);
        return res;
    }
    public void traceback(int[] nums,int start){
        if (path.size() >= 2){
            res.add(new ArrayList<>(path));
        }
        boolean[] used = new boolean[201];
        Arrays.fill(used,false);
        for (int i = start; i <= nums.length; i++) {
            if (!path.isEmpty() && path.get(path.size()-1) > nums[i-1]) continue;
            if (used[nums[i-1]+100]) continue;
            used[nums[i-1]+100] = true;
            path.add(nums[i-1]);
            traceback(nums,i+1);
            path.removeLast();
        }
    }
    public static void main(String[] args) {
        findSubsequences ts = new findSubsequences();
        int[] nums = new int[]{4,6,7,7};
        System.out.println(ts.findSubsequences(nums));
    }
}
