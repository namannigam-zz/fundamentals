package edu.fundamental.calendar.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
    String empId;
    String name;
}
