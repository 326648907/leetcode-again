package traceback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*剪枝优化*/
public class combine_1 {
    LinkedList<Integer> list = new LinkedList<>();
    List<List<Integer>> reslist = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        //回溯算法，排列树
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        traceback(k,1);
        return reslist;
    }

    public void traceback(int k,int startIndex) {
        if (path.size() == k){
            reslist.add(new ArrayList<>(path));//这里不要直接add(path),因为是添加的指针,所以需要添加一份path里的实体内容
            return;
        }
        //下面:这里做剪枝优化,需要的比可用的剩余的多,则比不可能输出合规的结果,故减去
        for (int i = startIndex; i <= list.size() - (k - path.size()) + 1; i++){
            path.add(i);
            traceback(k, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        combine_1 a = new combine_1();
        List<List<Integer>> res = a.combine(4,2);
        System.out.println(res);
    }
}
