package src30.com.employees;

public class SalesEmployee extends Employee {
    private double salesAmount;
    
    public SalesEmployee(String id, String name, double basesalary, double salesAmount) {
        super(id, name, basesalary);
        this.salesAmount = salesAmount;
    }
    
    public double calculateSalary() {
        return basesalary + (salesAmount * 0.05);
    }
    public String getEmployeeInfo() {
        return String.format("ID: %s, 姓名: %s, 基础工资: %.2f, 销售额: %.2f, 提成: %.2f, 实际工资: %.2f", 
                           id, name, basesalary, salesAmount, salesAmount * 0.05, calculateSalary());
    }
}
