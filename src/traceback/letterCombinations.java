package traceback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class letterCombinations {
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    HashMap<Character, String> map = new HashMap<>();
    public List<String> letterCombinations(String digits){
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        if (digits == null || digits.length() == 0) {
            return res;
        }
        traceback(1,digits);
        return res;
    }
    public void traceback(int curdeep, String digits){
        if(curdeep > digits.length()){
            res.add(new String(path));
            return;
        }
        Character curchar = digits.charAt(curdeep-1);//获得单个
        // todo 这里不可把list写出到函数头上,因为每次横向遍历时,其可选list是不变的,所以写在traceback里面保证这样
        String list = map.get(curchar);// 找到当前可选
        for (int i = 1; i <= list.length(); i++) {

            path.append(list.charAt(i-1));
            traceback(curdeep+1,digits);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "237";
        letterCombinations a = new letterCombinations();
        List<String> res = a.letterCombinations(digits);
        System.out.println(res);
    }
}
