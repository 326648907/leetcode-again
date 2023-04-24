package traceback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class combine {
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
        for (int i = startIndex; i <= list.size(); i++){
            path.add(i);
            traceback(k, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        combine a = new combine();
        List<List<Integer>> res = a.combine(4,2);
        System.out.println(res);
    }
}
