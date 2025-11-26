import java.io.*;
import java.util.*;

class Book {
    private String isbn;
    private String title;
    private String author;
    private int stock;

    public Book(String isbn, String title, String author, int stock) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.stock = stock;
    }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public String toString() {
        return "ISBN: " + isbn + ", 书名: " + title + ", 作者: " + author + ", 库存: " + stock;
    }
}

public class Lib_system_31 {
    private static ArrayList<Book> books = new ArrayList<>();
    private static final String FILE_NAME = "books.txt";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadBooksFromFile();
        boolean running = true;
        while (running) {
            System.out.println("\n===== 图书管理系统 =====");
            System.out.println("1. 添加图书");
            System.out.println("2. 查看所有图书");
            System.out.println("3. 借书");
            System.out.println("4. 还书");
            System.out.println("5. 退出系统");
            System.out.print("请选择操作: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewAllBooks();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    saveBooksToFile();
                    running = false;
                    System.out.println("系统已退出，图书数据已保存。");
                    break;
                default:
                    System.out.println("无效选择，请重新输入。");
            }
        }
        scanner.close();
    }
    private static void addBook() {
        System.out.print("请输入 ISBN 编号: ");
        String isbn = scanner.nextLine();
        System.out.print("请输入书名: ");
        String title = scanner.nextLine();
        System.out.print("请输入作者: ");
        String author = scanner.nextLine();
        System.out.print("请输入库存数量: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        books.add(new Book(isbn, title, author, stock));
        System.out.println("图书添加成功！");
    }
    private static void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("当前没有图书。");
            return;
        }
        books.sort(Comparator.comparing(Book::getIsbn));
        System.out.println("所有图书信息（按 ISBN 升序）:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
    private static void borrowBook() {
        System.out.print("请输入要借阅的图书 ISBN: ");
        String isbn = scanner.nextLine();
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (book.getStock() > 0) {
                    book.setStock(book.getStock() - 1);
                    System.out.println("借书成功！当前库存: " + book.getStock());
                } else {
                    System.out.println("库存不足，借书失败。");
                }
                return;
            }
        }
        System.out.println("未找到该 ISBN 的图书。");
    }
    private static void returnBook() {
        System.out.print("请输入要归还的图书 ISBN: ");
        String isbn = scanner.nextLine();
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                book.setStock(book.getStock() + 1);
                System.out.println("还书成功！当前库存: " + book.getStock());
                return;
            }
        }
        System.out.println("未找到该 ISBN 的图书。");
    }
    private static void saveBooksToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Book book : books) {
                writer.println(book.getIsbn() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.getStock());
            }
        } catch (IOException e) {
            System.out.println("保存文件时出错: " + e.getMessage());
        }
    }
    private static void loadBooksFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String isbn = parts[0];
                    String title = parts[1];
                    String author = parts[2];
                    int stock = Integer.parseInt(parts[3]);
                    books.add(new Book(isbn, title, author, stock));
                }
            }
            System.out.println("图书数据已从文件加载。");
        } catch (IOException e) {
            System.out.println("读取文件时出错: " + e.getMessage());
        }
    }
}
