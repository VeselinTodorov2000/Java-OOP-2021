package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class Department {
    //data members
    private Manager manager;
    private String deptName;
    private List<Staff> staff;

    //constructor
    //constructors
    public Department(Manager manager, String deptName) {
        this.setManager(manager);
        this.setDeptName(deptName);
        this.staff = new ArrayList<>();
    }

    //setters
    public void setManager(Manager manager) {
        if(manager == null)
        {
            throw new java.security.InvalidParameterException("Manager cannot be null");
        }
        this.manager = manager;
    }

    public void setDeptName(String deptName) {
        if(deptName == null)
        {
            throw new java.security.InvalidParameterException("Department name cannot be null");
        }
        this.deptName = deptName;
    }

    //getters
    public List<Staff> getStaff() {
        return staff;
    }

    //to string
    @Override
    public String toString() {
        return String.format("%s, department name: %s, staff: %s", manager.toString(), deptName, staff.toString());
    }

    //appointmentHandler
    public BiConsumer<Staff, Double> appointmentHandler = (worker, workerSalary) -> {
        worker.setWorkAt(deptName);
        worker.setHiredAt(LocalDate.now());
        worker.setSalary(workerSalary);
        staff.add(worker);
    };
}
