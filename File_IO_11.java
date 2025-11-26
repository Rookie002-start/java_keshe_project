import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class File_IO_11 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("输入要写入的内容：");
        StringBuilder content = new StringBuilder();
        String line = s.nextLine();
        content.append(line).append(System.lineSeparator());
        Path fp = Paths.get("test.txt");
        try{
            Files.write(fp, content.toString().getBytes());
            System.out.println("内容成功写入！");
            System.out.println("读出内容如下：");
            String fc = new String(Files.readAllBytes(fp));
            System.out.println(fc);
        }
        catch(IOException e){
            System.err.println(e.getMessage());
        }
        finally{
            s.close();
        }
    }
}
