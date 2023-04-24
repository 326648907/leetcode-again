package traceback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
// todo 可重选,只组合不排列
public class combinationSum {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path  = new LinkedList<>();
    int[] list;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        list = candidates;
        traceback(list,target,1,0);
        return res;
    }
    public void traceback(int[] list,int target,int forstart,int sum){
        if (sum > target) return;
        if (sum == target){
            res.add(new ArrayList<>(path));
        }
        for (int i = forstart; i <= list.length; i++) {
            path.add(list[i-1]);
            traceback(list,target,i,sum + list[i-1]);
            path.removeLast();
        }
    }
    public static void main(String[] args) {
        combinationSum a = new combinationSum();
        int[] candidates = new int[]{2, 3, 6, 7};
        List<List<Integer>> res = a.combinationSum(candidates,7);
        System.out.println(res);
    }
}
