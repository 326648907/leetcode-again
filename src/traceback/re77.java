package traceback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class re77 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n,int k){
        traceback(n,k,1);
        return res;
    }
    public void traceback(int n,int k,int start){
        if (path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++ ){// 分几个分叉
            path.add(i);//加入path
            traceback(n,k,i+1);
            path.removeLast();// 回退path的加入
        }
    }
    public static void main(String[] args) {
        re77 a = new re77();
        List<List<Integer>> res = a.combine(4,2);
        System.out.println(res);
    }
}
