import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class Word_cnt {
    public static void main(String[] args) {
        int cnt = 0;
        try(Scanner s = new Scanner(new File("./article.txt"))){
            while(s.hasNext()){
                s.next();
                cnt++;
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("文本中单词个数为" + cnt); 
    }
}
