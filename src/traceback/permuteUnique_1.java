package traceback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
// todo 不用数组排序
public class permuteUnique_1 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;// todo 这个用来确定for的范围,缩小每次待选集合的范围
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.fill(used,false);
        traceback(nums);
        return res;
    }
    public void traceback(int[] nums){
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
        }
        int[] forused = new int[21]; // todo 查表用去本层重复
        Arrays.fill(forused,0);
        for (int i = 1; i <= nums.length; i++) {
            if (used[i-1]) continue;
            if (forused[nums[i-1]+10] > 0) continue;
            forused[nums[i-1]+10]++;
            path.add(nums[i-1]);
            used[i-1] = true;
            traceback(nums);
            used[i-1] = false;
            path.removeLast();
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        permuteUnique_1 ts = new permuteUnique_1();
        List<List<Integer>> res = ts.permuteUnique(nums);
        System.out.println(res);
    }
}
