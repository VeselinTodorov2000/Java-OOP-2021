package model;

public class Employee {
    //data members
    private String name;
    private double salary;
    private static int cnt;
    public final String ID;

    //constructor
    public Employee(String name, double salary) {
        this.setName(name);
        this.setSalary(salary);
        ID = String.format("E-%03d", cnt);
        cnt++;
    }

    //setters and getters
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
        return String.format("id: %s, name: %s, salary: %.2f", ID, name, salary);
    }
}
