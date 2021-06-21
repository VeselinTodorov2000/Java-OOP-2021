package model;

import java.util.function.BiConsumer;

public class Manager extends Employee{
    //data members
    private BiConsumer<Staff, Double> appointRule;

    //constructor
    public Manager(String name, double salary, BiConsumer<Staff, Double> appointRule) {
        super(name, salary);
        this.setAppointRule(appointRule);
    }

    //setter
    public void setAppointRule(BiConsumer<Staff, Double> appointRule) {
        this.appointRule = appointRule;
    }

    //member
    public void onStaffAppointment(Staff member, Double newStaffMemberSalary)
    {
        this.appointRule.accept(member, newStaffMemberSalary);
    }
}
