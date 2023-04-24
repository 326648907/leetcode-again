package traceback;

import java.util.ArrayList;
import java.util.List;

public class restoreIpAddresses {
    List<String> res = new ArrayList<>();
    String path = "";
    int pot_num = 0;
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return res;
        traceback(s,1);
        return res;
    }
    public void traceback(String s,int start){

        if (pot_num <= 2){
            for (int i = start; i <= s.length(); i++) {
                String cur_str = s.substring(start-1,i);
                if (!isValid(cur_str)) continue;
                int prev_path_len = path.length();

                path = path + cur_str + ".";
                pot_num++;
                traceback(s,i+1);
                pot_num--;
                path = path.substring(0,prev_path_len);
            }
        }
        if (pot_num == 3){
            String cur_str = s.substring(start-1);
            if (!isValid(cur_str)) return;
            path = path + cur_str;
            // String one_res = path;
            // res.add(one_res);
            res.add(path);
        }

    }
    public boolean isValid(String str){
        if (str.length() == 0) return false;// todo list 别忘了会传空字符串
        if (str.equals("0")) return true;// todo 只许单0,不许开头有0
        if (str.charAt(0) == '0') return false;
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > '9' || str.charAt(i) < '0') { // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (str.charAt(i) - '0');// todo String 转换 int的公式
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        restoreIpAddresses ts = new restoreIpAddresses();
        String a = "101023";
        System.out.println(ts.restoreIpAddresses(a));
    }
}
