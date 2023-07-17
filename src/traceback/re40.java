package traceback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class re40 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);// todo 先排序把会重复的元素放在一起
        traceback(candidates,1,0,target);
        return res;
    }
    public void traceback(int[] candidates,int start,int sum,int target){
        if (sum > target){
            return;
        }
        if (sum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= candidates.length; i++) {
            if ( i > start && candidates[i - 1] == candidates[i - 2] ) {
                continue;
            }
            path.add(candidates[i-1]);
            traceback(candidates,i+1,sum+candidates[i-1],target);
            path.removeLast();
        }
    }
    public static void main(String[] args) {
        re40 ts = new re40();
        int[] nums = new int[]{10,1,2,7,6,1,5};
        System.out.println(ts.combinationSum2(nums,8));
    }
}
