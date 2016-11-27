package com.mpt.pms;

import com.mpt.pms.domain.*;

import java.applet.Applet;
import java.io.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        DateFormat df = new SimpleDateFormat("mm/dd/yyyy");

        Company company = new Company("MegaSoft", df.parse("01/01/1990"));

        Employee emp = new Employee("John", "Johna's", df.parse("10/10/2000"), 0);
        company.hireEmployee(emp);
        Employee emp2 = new Employee("Nina", "Williams", df.parse("11/03/1978"), 8);
        Employee emp3 = new Employee("Jack", "Nicholson", df.parse("01/08/1960"), 14);

        Project pms = new Project("pms", df.parse("10/27/2016"), df.parse("01/01/2017"), 30,
                new ProjectManager());
        pms.assignEmployee(emp);
        pms.assignEmployee(emp2);
        pms.assignEmployee(emp3);

        pms.getManager().assignTask(new NotAssignedTask("Make labs", 7), emp);
        pms.getManager().assignTask(new NotAssignedTask("Make labs", 5), emp2);

        // Should assign to emp3, because he has most free hours
        pms.getManager().assignTask(new NotAssignedTask("Make labs", 7));

        for (List<Task> t: pms.getManager().getCreatedTasks().values()) {
            System.out.println(t);
        }
    }
}
