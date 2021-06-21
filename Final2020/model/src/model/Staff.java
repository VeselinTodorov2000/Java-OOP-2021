package model;

import java.time.LocalDate;

public class Staff extends Employee{
    //data members
    private String workAt;
    private LocalDate hiredAt;

    //constructor
    public Staff(String name, double salary, String workAt, LocalDate hiredAt) {
        super(name, salary);
        this.setWorkAt(workAt);
        this.setHiredAt(hiredAt);
    }

    //setters and getters
    public String getWorkAt() {
        return workAt;
    }

    public void setWorkAt(String workAt) {
        this.workAt = workAt != null ? workAt : "Candidate";
    }

    public LocalDate getHiredAt() {
        return hiredAt;
    }

    public void setHiredAt(LocalDate hiredAt) {
        this.hiredAt = hiredAt != null ? hiredAt : LocalDate.now();
    }

    //to string
    @Override
    public String toString() {
        return String.format("%s, hired at: %s, work at: %s", super.toString(), hiredAt.toString(), workAt.toString());
    }
}
