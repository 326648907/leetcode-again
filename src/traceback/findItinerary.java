package traceback;

import java.util.*;

public class findItinerary {
    List<String> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    boolean[] used;
    boolean finshed = false;
    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));// todo 依照票中的目的地,进行字母先后的排序
        used = new boolean[tickets.size()];
        Arrays.fill(used,false);
        traceback(tickets);
        return res;
    }
    public void traceback(List<List<String>> tickets){
        if (finshed) return;
        if (path.size() - 1 == tickets.size()){
            res = new ArrayList<>(path);
            finshed = true;
            return;
        }
        String cursite;
        if (path.size() == 0){
            path.add("JFK");
            cursite = "JFK";
        }else {
            cursite = path.getLast();
        }

        for (int i = 1; i <= tickets.size(); i++) {
            List<String> preticket = tickets.get(i-1);
            if (!used[i-1] && preticket.get(0).equals(cursite)){
                path.add(preticket.get(1));
                used[i-1] = true;
                traceback(tickets);
                used[i-1] = false;
                path.removeLast();
            }
        }
    }
    public static void main(String[] args) {

        List<String> ticket1 = new ArrayList<>(Arrays.asList("MUC","LHR"));
        List<String> ticket2 = new ArrayList<>(Arrays.asList("JFK","MUC"));
        List<String> ticket3 = new ArrayList<>(Arrays.asList("SFO","SJC"));
        List<String> ticket4 = new ArrayList<>(Arrays.asList("LHR","SFO"));
        List<List<String>> tickets = new ArrayList<>(Arrays.asList(ticket1,ticket2,ticket3,ticket4));
        findItinerary ts = new findItinerary();
        List<String> res = ts.findItinerary(tickets);
        System.out.println(res);
    }
}
