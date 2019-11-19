package edu.fundamental.calendar.provider;

import com.google.inject.Inject;
import edu.fundamental.calendar.dao.EmployeeDao;
import edu.fundamental.calendar.model.Employee;
import edu.fundamental.calendar.service.ManagementService;

public class ManagementServiceProvider implements ManagementService {

    @Inject
    private EmployeeDao employeeDao;

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    public int minimumNumberOfRoomsRequired() {
        return 0;
    }
}