package edu.fundamental.store;

import edu.fundamental.dao.EmployeeDao;
import edu.fundamental.model.Employee;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeStore implements EmployeeDao {

    @Override
    public void addEmployee(Employee employee) {
        log.info("Employee added with details {}", employee);
    }
}