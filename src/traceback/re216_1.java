package traceback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class re216_1 {// 此次将sum 放在里面
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {//k 是个数
        traceback(k,n,1,0);
        return res;
    }
    public  void traceback(int k,int n,int start,int sum){
        if (path.size() < k && sum >= n){
            return;
        }
        if (path.size() == k){
            if (sum == n){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = start; i <= 9; i++ ){// 分几个分叉
            path.add(i);//加入path
            traceback(k,n,i+1,sum+i);
            path.removeLast();// 回退path的加入
        }
    }
    public static void main(String[] args) {
        re216_1 a = new re216_1();
        List<List<Integer>> res = a.combinationSum3(3,9);
        System.out.println(res);
    }
}
