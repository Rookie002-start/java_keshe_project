package src30.com.employees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Company {
    private List<Employee> employees;

    public Company(){
        this.employees = new ArrayList<>();
    }
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("添加员工成功: " + employee.name);
    }
    public boolean removeEmployee(String id) {
        boolean removed = employees.removeIf(emp -> emp.id.equals(id));
        if (removed) {
            System.out.println("删除员工成功: " + id);
        } else {
            System.out.println("未找到员工: " + id);
        }
        return removed;
    }
    public double calculateTotalSalary() {
        return employees.stream()
                       .mapToDouble(Employee::calculateSalary)
                       .sum();
    }
    public void displayEmployeesSortedBySalary() {
        List<Employee> sortedEmployees = employees.stream()
                                                 .sorted()
                                                 .collect(Collectors.toList());
        
        System.out.println("\n=== 员工工资排序（从低到高）===");
        sortedEmployees.forEach(emp -> System.out.println(emp.getEmployeeInfo()));
    }
    public Optional<Employee> findHighestPaidEmployee() {
        return employees.stream()
                       .max(Comparator.comparingDouble(Employee::calculateSalary));
    }
    public Optional<Employee> findLowestPaidEmployee() {
        return employees.stream()
                       .min(Comparator.comparingDouble(Employee::calculateSalary));
    }
    public void displayAllEmployees() {
        System.out.println("\n=== 所有员工信息 ===");
        employees.forEach(emp -> System.out.println(emp.getEmployeeInfo()));
    }
    public void displayStatistics() {
        System.out.println("\n=== 工资统计信息 ===");
        DoubleSummaryStatistics stats = employees.stream()
                                                .mapToDouble(Employee::calculateSalary)
                                                .summaryStatistics();
        
        System.out.printf("员工总数: %d\n", stats.getCount());
        System.out.printf("总工资支出: %.2f\n", stats.getSum());
        System.out.printf("平均工资: %.2f\n", stats.getAverage());
        System.out.printf("最高工资: %.2f\n", stats.getMax());
        System.out.printf("最低工资: %.2f\n", stats.getMin());
    }
}
