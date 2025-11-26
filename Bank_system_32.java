import java.io.*;
import java.util.HashMap;
import java.util.Map;

class BankAccount {
    private String accountId;
    private String userName;
    private double balance;

    public BankAccount(String accountId, String userName, double initialBalance) {
        this.accountId = accountId;
        this.userName = userName;
        this.balance = initialBalance;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getUserName() {
        return userName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("余额不足");
        }
    }

    public String toString() {
        return accountId + "," + userName + "," + balance;
    }

    public static BankAccount fromString(String str) {
        String[] parts = str.split(",");
        return new BankAccount(parts[0], parts[1], Double.parseDouble(parts[2]));
    }
}

class BankSystem {
    private Map<String, BankAccount> accounts;
    private String dataFile = "accounts.dat";

    public BankSystem() {
        accounts = new HashMap<>();
        loadAccountsFromFile();
    }

    public synchronized void createAccount(String accountId, String userName, double initialBalance) {
        if (accounts.containsKey(accountId)) {
            throw new IllegalArgumentException("账户已存在");
        }
        accounts.put(accountId, new BankAccount(accountId, userName, initialBalance));
        saveAccountsToFile();
    }

    public synchronized void deposit(String accountId, double amount) {
        BankAccount account = accounts.get(accountId);
        if (account == null) {
            throw new IllegalArgumentException("账户不存在");
        }
        account.deposit(amount);
        saveAccountsToFile();
    }

    public synchronized void withdraw(String accountId, double amount) {
        BankAccount account = accounts.get(accountId);
        if (account == null) {
            throw new IllegalArgumentException("账户不存在");
        }
        account.withdraw(amount);
        saveAccountsToFile();
    }

    public synchronized double getBalance(String accountId) {
        BankAccount account = accounts.get(accountId);
        if (account == null) {
            throw new IllegalArgumentException("账户不存在");
        }
        return account.getBalance();
    }

    private void loadAccountsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                BankAccount account = BankAccount.fromString(line);
                accounts.put(account.getAccountId(), account);
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveAccountsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile))) {
            for (BankAccount account : accounts.values()) {
                writer.write(account.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Bank_system_32 {
    public static void main(String[] args) {
        BankSystem bank = new BankSystem();

        bank.createAccount("001", "张三", 1000.0);
        bank.createAccount("002", "李四", 500.0);

        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                bank.deposit("001", 10);
                bank.withdraw("001", 5);
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("账户001余额: " + bank.getBalance("001"));
    }
}
