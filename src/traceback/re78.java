package traceback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
* 备选里无重复,选的时候也不能重复选
* */
public class re78 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        traceback(nums,1);
        return res;
    }
    public void traceback(int[] nums, int start){
        res.add(new ArrayList<>(path));
        for (int i = start; i <= nums.length; i++ ){// 分几个分叉
            path.add(nums[i-1]);//加入path
            traceback(nums,i+1);
            path.removeLast();// 回退path的加入
        }
    }

    public static void main(String[] args) {
        re78 ts = new re78();
        int[] nums = new int[]{1,2,3};
        System.out.println(ts.subsets(nums));
    }
}
