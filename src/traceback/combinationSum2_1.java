package traceback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
// todo 加入used[] 数组的写法,更易理解
public class combinationSum2_1 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> combinationSum2_1(int[] candidates, int target) {
        used = new boolean[candidates.length];
        Arrays.fill(used, false);
        Arrays.sort(candidates);// todo 先排序把会重复的元素放在一起
        traceback(candidates,1,0,target);
        return res;
    }
    public void traceback(int[] candidates,int start,int sum,int target){
        if (sum > target) return;
        if (sum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= candidates.length; i++) {
            // todo 重点处,去重对于选过的内容直接跳过.横向选择:若横向之前加入过相同元素,则应去除.因为允许纵向重复(path选过1后可再加入1)所以纵向不去重
            if ( i >= 2 && candidates[i - 1] == candidates[i - 2] && used[i-2] == false) {// todo 这里前面的false代表没有在path里
                continue;
            }
            path.add(candidates[i-1]);
            used[i-1] = true;
            traceback(candidates,i+1,sum+candidates[i-1],target);
            path.removeLast();
            used[i-1] = false;
        }
    }
    public static void main(String[] args) {
        combinationSum2_1 a = new combinationSum2_1();
        int[] candidates = new int[]{1,2,7,6,1,5};
        List<List<Integer>> res = a.combinationSum2_1(candidates,8);
        System.out.println(res);
    }
}

