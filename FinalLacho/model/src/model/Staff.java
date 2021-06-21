package model;

import java.time.LocalDate;

public class Staff extends Employee
{
    private String workAt;
    private LocalDate hiredAt;

    //workAt getter
    public String getWorkAt() {
        return workAt;
    }

    //workAt setter
    public void setWorkAt(String workAt) {
        if(workAt == null)
        {
            this.workAt = "Candidate";
            return;
        }
        this.workAt = workAt;
    }

    //hiredAt getter
    public LocalDate getHiredAt() {
        return hiredAt;
    }

    //hiredAt setter
    public void setHiredAt(LocalDate hiredAt) {
        this.hiredAt = hiredAt != null ? hiredAt : LocalDate.now();
    }

    //general purpose constructor
    public Staff(String name, double salary, String workAt, LocalDate hiredAt) {
        super(name, salary);
        this.setHiredAt(hiredAt);
        this.setWorkAt(workAt);
    }

    //to string
    @Override
    public String toString() {
        return String.format("%s, workAt: %s, hiredAt: %s", super.toString(), workAt, hiredAt.toString());
    }
}
