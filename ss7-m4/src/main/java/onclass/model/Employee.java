package onclass.model;

public class Employee {
    private String employeeId;
    private String fullName;
    private int age;
    private double salary;

    public Employee() {
    }

    public Employee(String employeeId, String fullName, int age, double salary) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.age = age;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
