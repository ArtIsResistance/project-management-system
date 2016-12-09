package com.mpt.pms.domain.exceptions;

public class EmployeeAssignmentException extends AssignmentException {
    public EmployeeAssignmentException() {}

    public EmployeeAssignmentException(String message){
        super(message);
    }
}
