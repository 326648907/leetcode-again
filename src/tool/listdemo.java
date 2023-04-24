package tool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class listdemo {
    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        String a = "1";
        res.add(a);
        a = "2";
        res.add(a);
        System.out.println(res); // todo res = [1,2]由此可发现,存入list的时会给予存入对应值一个新的变量,而list存的是这些新变量的地址值

        List<String> ticket1 = new ArrayList<>(Arrays.asList("MUC","LHR"));
        List<String> ticket2 = new ArrayList<>(Arrays.asList("JFK","MUC"));
        List<String> ticket3 = new ArrayList<>(Arrays.asList("SFO","SJC"));
        List<String> ticket4 = new ArrayList<>(Arrays.asList("LHR","SFO"));
        List<List<String>> tickets = new ArrayList<>(Arrays.asList(ticket1,ticket2,ticket3,ticket4));

        Collections.sort(tickets, (b, c) -> b.get(1).compareTo(c.get(1)));
    }
}
