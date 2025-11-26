package src30.com.employees;

public class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String id, String name, double basesalary, double perfor){
        super(id, name, basesalary);
        this.perfor = perfor;
    }

    private double perfor;

    public double calculateSalary(){
        return basesalary + perfor;
    }
    public String getEmployeeInfo(){
        return String.format("ID: %s, 姓名: %s, 基础工资: %.2f, 绩效奖金: %.2f, 实际工资: %.2f", 
                           id, name, basesalary, perfor, calculateSalary());
    }
}
