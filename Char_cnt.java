import java.util.HashMap;
import java.util.Scanner;

public class Char_cnt {
    public static void main(String[] args) {
        HashMap<Character, Integer> chs = new HashMap<>();
        Scanner s = new Scanner(System.in);
        System.out.println("输入一串字符串：");
        String str = s.nextLine();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(chs.containsKey(ch)){
                int value = chs.get(ch);
                value++;
                chs.put(ch, value);
            }
            else{
                chs.put(ch, 1);
            }
        }
        for(char key : chs.keySet()){
            System.out.println(key + ":" + chs.get(key));
        }
        s.close();
    }
}
