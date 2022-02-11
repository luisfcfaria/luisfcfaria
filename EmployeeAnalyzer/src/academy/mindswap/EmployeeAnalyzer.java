package academy.mindswap;

import java.util.*;
import java.util.stream.Collectors;


public class EmployeeAnalyzer {

    List<Employee> list;

    public EmployeeAnalyzer(List<Employee> list) {
        this.list = list;
    }

    public int yearsInDept(Department department, int yearsInDept){
       return (int) this.list.stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .filter(employee -> employee.getYearsInDepartment() > yearsInDept)
                .count();
    }


    public List<String> salaryList (int salary){

        return this.list.stream()
                .filter(employee -> employee.getSalary()>salary)
                .map(Employee::getName)
                .collect(Collectors.toList());
    }


    public List<Employee> oldest(int numberOfEmployees){
        return this.list.stream()
                .sorted((employee, employee1) -> Integer.compare(employee1.getAge(),employee.getAge()))
                .limit(numberOfEmployees)
                .collect(Collectors.toList());
    }

    public Employee firstOldestThan(int age){

         Optional<Employee> name =  this.list.stream()
                .filter(employee -> employee.getAge() > age)
                .findFirst();

         return name.orElse(null);


    }

    public long averageSalary(Department department){

        long numOfEmployees = this.list.stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .count();

        long salaries = this.list.stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .map(Employee::getSalary)
                .reduce(0, Integer::sum);

        return salaries/numOfEmployees;

    }


    public List<String> commonNamesInDept( Department dept1, Department dept2){
        Set<String> namesDepOne = this.list.stream()
                .filter(employee -> employee.getDepartment().equals(dept1))
                .map(Employee::getFirstName)
                .collect(Collectors.toSet());

        return this.list.stream()
                .filter(employee -> employee.getDepartment().equals(dept2))
                .map(Employee::getFirstName)
                .distinct()
                .filter(namesDepOne::contains)
                .collect(Collectors.toList());



        }


    }


