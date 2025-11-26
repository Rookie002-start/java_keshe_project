package src30.com.employees;

public class testexample {
    public static void main(String[] args) {
        Company company = new Company();
        Employee fullTime = new FullTimeEmployee("10001", "张三", 6000, 4000);
        Employee partTime = new PartTimeEmployee("20001", "李四", 0, 40, 100);
        Employee sales = new SalesEmployee("30001", "王五", 6000, 200000);
        company.addEmployee(fullTime);
        company.addEmployee(partTime);
        company.addEmployee(sales);
        company.displayAllEmployees();
        company.displayEmployeesSortedBySalary();
        company.displayStatistics();
        company.findHighestPaidEmployee().ifPresent(emp -> 
            System.out.println("\n工资最高的员工: " + emp.getEmployeeInfo()));
        company.findLowestPaidEmployee().ifPresent(emp -> 
            System.out.println("工资最低的员工: " + emp.getEmployeeInfo()));
        company.removeEmployee("20001");
        company.displayAllEmployees();
        Employee testEmp1 = new FullTimeEmployee("10002", "小六", 8000, 2000);
        Employee testEmp2 = new FullTimeEmployee("10002", "小六", 8000, 2000);
        System.out.println("\n测试equals和hashCode:");
        System.out.println("两个相同ID员工equals: " + testEmp1.equals(testEmp2));
        System.out.println("两个相同ID员工hashCode相等: " + (testEmp1.hashCode() == testEmp2.hashCode()));
    }
}
