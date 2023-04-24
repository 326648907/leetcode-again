package traceback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
// todo 与之前的组合总和不同,这次,待选集合里有重复元素,故在通常处理后,结果会出现排序不同,但集合相同的的数组的情况,需要去重
public class combinationSum2 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if ( i > start && candidates[i - 1] == candidates[i - 2] ) {
                continue;
            }
            path.add(candidates[i-1]);
            traceback(candidates,i+1,sum+candidates[i-1],target);
            path.removeLast();
        }
    }
    public static void main(String[] args) {
        combinationSum2 a = new combinationSum2();
        int[] candidates = new int[]{1,2,7,6,1,5};
        List<List<Integer>> res = a.combinationSum2(candidates,8);
        System.out.println(res);
    }
}
