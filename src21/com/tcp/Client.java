package src21.com.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 12345;
        
        try (Socket socket = new Socket(host, port);
             BufferedReader in = new BufferedReader(
                 new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader userInput = new BufferedReader(
                 new InputStreamReader(System.in))) {
            
            System.out.println("已连接到服务器 " + host + ":" + port);
            System.out.println("输入消息（输入 'exit' 退出）:");
            
            String userMessage;
            while ((userMessage = userInput.readLine()) != null) {
                if ("exit".equalsIgnoreCase(userMessage)) break;
                out.println(userMessage);
                String response = in.readLine();
                System.out.println("服务器回应: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
