import java.io.*;
import java.util.Properties;

public class ConfigReader_24 {
    public static void main(String[] args) {
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream("config.properties")) {
            prop.load(input);
            
            String url = prop.getProperty("database.url");
            String user = prop.getProperty("database.username");
            String password = prop.getProperty("database.password");
            
            String timeout = prop.getProperty("connection.timeout", "30");
            
            System.out.println("数据库地址: " + url);
            System.out.println("用户名: " + user);
            System.out.println("密码: " + password);
            System.out.println("超时时间: " + timeout);
            
        } catch (IOException ex) {
            System.err.println("配置文件读取失败: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
