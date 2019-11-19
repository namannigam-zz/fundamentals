package edu.fundamental.calendar.service;

import edu.fundamental.calendar.model.Employee;

public interface ManagementService {
    void addEmployee(Employee employee);

    int minimumNumberOfRoomsRequired();

}