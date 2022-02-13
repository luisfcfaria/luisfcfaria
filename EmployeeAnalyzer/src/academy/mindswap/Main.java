package academy.mindswap;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


	// write your code here

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Luis", 28,2500,5,Department.FINANCE));
        employeeList.add(new Employee("João", 42,1500,7,Department.OPERATIONS));
        employeeList.add(new Employee("Diogo", 36,3500,12,Department.SALES));
        employeeList.add(new Employee("Mary", 18,2000,1,Department.SALES));
        employeeList.add(new Employee("Mary", 53,900,14,Department.FINANCE));
        employeeList.add(new Employee("Peter", 29,2500,3,Department.OPERATIONS));
        employeeList.add(new Employee("Luis", 52,4000,9,Department.SALES));
        employeeList.add(new Employee("Amadis", 52,850,9,Department.SALES));
        employeeList.add(new Employee("Antonio", 24,1765,9,Department.OPERATIONS));



        EmployeeAnalyzer ea = new EmployeeAnalyzer(employeeList);

        System.out.println("");
        System.out.println("Number of working more than the amount of years: " + ea.yearsInDept(Department.SALES,1));
        System.out.println("");
        System.out.println(ea.salaryList(3000));
        System.out.println("");
        System.out.println(ea.oldest(5));
        System.out.println("");
        System.out.println(ea.firstOldestThan(8));
        System.out.println("");
        System.out.println(ea.averageSalary(Department.SALES));
        System.out.println("");
        System.out.println(ea.commonNamesInDept(Department.SALES,Department.FINANCE));


    }

}
