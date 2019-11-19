package edu.fundamental.service;

import edu.fundamental.model.Employee;

public interface ManagementService {
    void addEmployee(Employee employee);

    int minimumNumberOfRoomsRequired();

}