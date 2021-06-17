package task1;

public class Employee {
    //data members
    private String name;
    private double salary;

    //general purpose constructor
    public Employee(String name, double salary) {
        this.setName(name);
        this.setSalary(salary);
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name != null ? name : "No Name";
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary >= 0 ? salary : 1000;
    }

    //to string

    @Override
    public String toString() {
        return String.format("%s:%.2f", name, salary);
    }
}
