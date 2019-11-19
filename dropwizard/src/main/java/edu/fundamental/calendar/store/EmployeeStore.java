package edu.fundamental.calendar.store;

import edu.fundamental.calendar.dao.EmployeeDao;
import edu.fundamental.calendar.model.Employee;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeStore implements EmployeeDao {

    @Override
    public void addEmployee(Employee employee) {
        log.info("Employee added with details {}", employee);
    }
}