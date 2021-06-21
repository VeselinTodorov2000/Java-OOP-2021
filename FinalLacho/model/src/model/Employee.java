package model;

public class Employee {
    public final String ID; //id
    private String name; //name of employee
    private double salary; //salary of employee
    private static int cnt = 0; //private static field to hold the number of created employees

    //name getter
    public String getName() {
        return name;
    }

    //name setter
    public void setName(String name) {
        if(this.name == null)
        {
            this.name = "No Name";
            return;
        }
        this.name = name;
    }

    //salary getter
    public double getSalary() {
        return salary;
    }

    //salary setter
    public void setSalary(double salary) {
        this.salary = salary > 0 ? salary : 1000;
    }

    //general purpose constructor
    public Employee(String name, double salary) {
        this.setName(name);
        this.setSalary(salary);
        this.ID = String.format("E-%03d", cnt++);
    }

    //to string

    @Override
    public String toString() {
        return String.format("ID: %s, name: %s, salary: %.2f\n", ID, name, salary);
    }
}
