package task1;

public class Staff extends Employee
{
    //data members
    private String workAt;

    //general purpose constructor


    public Staff(String name, double salary, String workAt) {
        super(name, salary);
        this.setWorkAt(workAt);
    }

    //setters and getters
    public String getWorkAt() {
        return workAt;
    }

    public void setWorkAt(String workAt) {
        this.workAt = workAt != null ? workAt : "Candidate";
    }

    //to string

    @Override
    public String toString() {
        return String.format("%s:%s", super.toString(), workAt);
    }
}
