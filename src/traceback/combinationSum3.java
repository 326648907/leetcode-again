package traceback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class combinationSum3 {
    LinkedList<Integer> list= new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList();
    public List<List<Integer>> combinationSum3(int k, int n) {
        for (int i = 1; i <= 9; i++) {
            list.add(i);
        }
        if (list.size() < k) return res;

        traceback(n,k,0);
        return res;
    }

    public void traceback(int n,int k,int startIndex){
        if (path.size() == k){
            int sum = 0;
            for (int i = 0; i < path.size(); i++) {
                sum += path.get(i);
            }
            if (sum == n){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex; i <= list.size() - 1; i++) {
            path.add(list.get(i));
            traceback(n,k,i+1);
            path.removeLast();
        }
    }
    public static void main(String[] args) {
        combinationSum3 a = new combinationSum3();
        List<List<Integer>> res = a.combinationSum3(3,9);
        System.out.println(res);
    }
}
