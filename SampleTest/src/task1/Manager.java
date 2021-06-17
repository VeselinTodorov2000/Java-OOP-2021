package task1;

public class Manager extends Employee
{
    //data members
    private String manageDeptName;

    //general purpose constructor

    public Manager(String name, double salary, String manageDeptName) {
        super(name, salary);
        this.manageDeptName = manageDeptName;
    }

    //setters and getters
    public String getManageDeptName() {
        return manageDeptName;
    }

    public void setManageDeptName(String manageDeptName) {
        if(manageDeptName == null) {
            throw new java.security.InvalidParameterException("Manager department name can't be null");
        }
        this.manageDeptName = manageDeptName;
    }

    //to string
    @Override
    public String toString() {
        return String.format("%s:%s", super.toString(), manageDeptName);
    }
}
