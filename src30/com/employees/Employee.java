package src30.com.employees;

import java.util.Objects;

public abstract class Employee implements Comparable<Employee> {
    public Employee(String id, String name, double basesalary) {
        this.id = id;
        this.name = name;
        this.basesalary = basesalary;
    }

    protected String id;
    protected String name;
    protected double basesalary;

    public abstract double calculateSalary();
    public String getEmployeeInfo(){
        return String.format("ID: %s, 姓名: %s, 基础工资: %.2f, 实际工资: %.2f", 
                           id, name, basesalary, calculateSalary());
    }
    public int compareTo(Employee other) {
        return Double.compare(this.calculateSalary(), other.calculateSalary());
    }
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return Objects.equals(id, employee.id);
    }
    public int hashCode() {
        return Objects.hash(id);
    }
}
