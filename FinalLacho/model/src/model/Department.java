package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class Department {
    private Manager manager;
    private String deptName;
    private List<Staff> staff;

    //biconsumer
    public BiConsumer<Staff, Double> appointmentHandler = (Staff worker, Double workerSalary) -> {
        worker.setWorkAt(deptName);
        worker.setHiredAt(LocalDate.now());
        worker.setSalary(workerSalary);
        staff.add(worker);
    };

    //manager setter
    public void setManager(Manager manager) {
        if(manager == null)
        {
            throw new java.security.InvalidParameterException("Manager can not be null");
        }
        this.manager = manager;
    }

    //dept name setter
    public void setDeptName(String deptName) {
        if(deptName == null)
        {
            throw new java.security.InvalidParameterException("Department name can not be null");
        }
        this.deptName = deptName;
    }

    //staff getter
    public List<Staff> getStaff() {
        return staff;
    }

    //general purpose constructor
    public Department(Manager manager, String deptName) {
        this.setManager(manager);
        this.setDeptName(deptName);
        staff = new ArrayList<Staff>();
    }

    //to string
    @Override
    public String toString() {
        return String.format("manager: %s, deptname: %s, staff: %s", manager.toString(), deptName, staff.toString());
    }
}

