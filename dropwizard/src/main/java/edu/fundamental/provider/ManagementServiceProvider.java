package edu.fundamental.provider;

import com.google.inject.Inject;
import edu.fundamental.dao.EmployeeDao;
import edu.fundamental.model.Employee;
import edu.fundamental.service.ManagementService;

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