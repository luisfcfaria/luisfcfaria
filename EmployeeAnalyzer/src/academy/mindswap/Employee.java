package academy.mindswap;

public class Employee {

    private String name;
    private int age;
    private int salary;
    private int yearsInDepartment;
    Department department;


    public Employee(String name, int age, int salary, int yearsInDepartment, Department department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.yearsInDepartment = yearsInDepartment;
        this.department = department;
    }


    public String getName() {
        return name;
    }

    public String getFirstName() {
        return name.split(" ")[0];
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public int getYearsInDepartment() {
        return yearsInDepartment;
    }

    public Department getDepartment() {
        return department;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
