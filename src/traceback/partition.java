package traceback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class partition {
    List<List<String>> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {
        traceback(1,s);
        return res;
    }
    
    public void traceback(int start,String s){
        if (start > s.length()) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = start; i <= s.length(); i++) {
            //如果是回文子串，则记录
            if (isHuiWen(start-1,i-1,s)) {
                String str = s.substring(start-1, i);
                path.addLast(str);
            } else {
                continue;
            }
            //起始位置后移，保证不重复
            traceback(i+1,s);
            path.removeLast();
        }
    }

    public boolean isHuiWen(int l, int r,String s){
        int left = l;
        int right = r;
        while (left <= right){
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "aheha";
        partition test = new partition();
        System.out.println(test.partition(a));
    }
}
