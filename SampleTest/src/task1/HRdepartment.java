package task1;

import java.util.ArrayList;

public class HRdepartment {
    //data members
    private Manager manager;
    private ArrayList<Staff> staff;

    //general purpose constructor
    public HRdepartment(Manager manager)
    {
        this.setManager(manager);
        this.staff = new ArrayList<Staff>();
    }

    //getters and setters
    public Manager getManager()
    {
        return manager;
    }

    public void setManager(Manager manager)
    {
        if(manager == null)
        {
            throw new java.security.InvalidParameterException("Manager should not be null");
        }
        this.manager = manager;
    }

    //to string
    @Override
    public String toString() {
        return manager.toString() + " " + staff.toString();
    }
}
