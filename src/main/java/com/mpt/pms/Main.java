package com.mpt.pms;

import com.mpt.pms.domain.*;
import com.mpt.pms.domain.exceptions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
        DateFormat df = new SimpleDateFormat("mm/dd/yyyy");

        Company company = new Company("MegaSoft", df.parse("01/01/1990"));

        Employee emp = new Employee("John", "Johna's", LocalDate.of(1990, 10, 10));
        Employee emp2 = new Employee("Nina", "Williams", LocalDate.of(1978, 11, 03));
        Employee emp3 = new Employee("Jack", "Nicholson", LocalDate.of(1960, 01, 8));

        ProjectManager pm = new ProjectManager("Lara", "Harrison", LocalDate.of(1985, 11, 30));


        company.hireEmployee(pm);
        company.hireEmployee(emp);
        company.hireEmployee(emp3);

        Project pms = new Project("pms", LocalDate.now(), LocalDate.now().plusYears(1), 30,
                company);

        company.assignProjectManager(pms, pm);

        try {
            pm.assignEmployee(emp);
            pm.assignEmployee(emp3);
            pm.assignEmployee(emp2);
        } catch (EmployeeAssignmentException e) {
            System.out.println(e.getMessage());
        }

        try {
            pm.assignTask(new NotAssignedTask("Make labs", 7, LocalDate.now().plusDays(1)), emp);
            pm.assignTask(new NotAssignedTask("Make labs", 5, LocalDate.now().plusDays(1)), emp2);
        } catch (TaskAssignmentException e) {
            System.out.println(e.getMessage());
        }

        // Should assign to emp3, because he has most free hours
        try {
            pm.assignTask(new NotAssignedTask("Make labs", 7, LocalDate.now().plusDays(1)));
        } catch (AssignmentException e) {
            System.out.println(e.getMessage());
        }

        pm.getCreatedTasks()
                .values()
                .forEach(System.out::println);

        DomainContext ctx = new DomainContext();
        ctx.setCompany(company);
        System.out.println(ctx.getCompany());
        ctx.save("dump.bin");
        ctx.setCompany(null);
        System.out.println(ctx.getCompany());
        ctx.load("dump.bin");
        System.out.println(ctx.getCompany());
    }
}
