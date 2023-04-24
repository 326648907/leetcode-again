package traceback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class solveNQueens {
    List<List<String>> res = new ArrayList<>();
    LinkedList<List<Integer>> path = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        traceback(n);
        return res;
    }

    public void traceback(int n){
        if (path.size() == n){
            List<String> Checkerboard = generateTable(path,n);
            res.add(Checkerboard);
            return;
        }
        int row = path.size() + 1;
        for (int column = 1; column <= n; column++) {
            List<Integer> cur = new ArrayList<>(Arrays.asList(row,column));
            if (!isVaild(path,cur)) continue;
            path.add(cur);
            traceback(n);
            path.removeLast();
        }
    }
    public List<String> generateTable(LinkedList<List<Integer>> path,int n){
        List<String> Checkerboard = new ArrayList<>();
        String line;
        for (int i = 1; i <= n; i++) {
            List<Integer> curQ = path.get(i-1);
            line = (curQ.get(1) == 1) ? "Q" : ".";
            for (int j = 2; j <= n; j++) {
                line += (j == curQ.get(1))?"Q":".";
            }
            Checkerboard.add(line);
        }
        return Checkerboard;
    }
    public boolean isVaild(LinkedList<List<Integer>> path,List<Integer> cur){
        for (int i = 1; i <= path.size(); i++) {
            List<Integer> curpath = path.get(i-1);
            if (curpath.get(0) == cur.get(0) || curpath.get(1) == cur.get(1) ) return false;
            if (Math.abs(cur.get(0)-curpath.get(0)) == Math.abs(cur.get(1)-curpath.get(1))) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        solveNQueens ts = new solveNQueens();
        List<List<String>> res = ts.solveNQueens(4);
        System.out.println(res);
    }
}
