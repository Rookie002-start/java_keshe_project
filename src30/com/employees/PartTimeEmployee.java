package src30.com.employees;

public class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String id, String name, double basesalary, double hoursalary, double hours){
        super(id, name, basesalary);
        this.hoursalary = hoursalary;
        this.hours = hours;
    }

    private double hoursalary;
    private double hours;

    public double calculateSalary(){
        return hoursalary * hours;
    }
    public String getEmployeeInfo(){
        return String.format("ID: %s, 姓名: %s, 基础工资: %.2f, 时薪: %.2f，工作小时: %.2f, 实际工资：%.2f", 
                           id, name, basesalary, hoursalary, hours, calculateSalary());
    }
}
