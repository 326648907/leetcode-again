package tool;

public class stringdemo {

    public static void main(String[] args) {
        String a = "abcdefg";
        String b = a.substring(1,4);// todo substring(1,4) 注意:左闭右开 b = "bcd"
        char a_char = a.charAt(0); // todo a_char = 'a'
        System.out.println(b);
        System.out.println(a_char);
    }
}
