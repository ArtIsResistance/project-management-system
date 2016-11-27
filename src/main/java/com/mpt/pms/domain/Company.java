package com.mpt.pms.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Company {
    private String name;
    private Date foundationDate;
    private List<Project> projects;
    private List<Employee> employees;

    public Company(String name, Date foundationDate) {
        this.name = name;
        this.foundationDate = foundationDate;
        projects = new ArrayList<>();
        employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Date getFoundationDate() {
        return foundationDate;
    }

    public List<Project> getProjects() {
        return Collections.unmodifiableList(projects);
    }

    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(employees);
    }

    public void hireEmployee(Employee employee) {
        employees.add(employee);
    }

    public boolean fireEmployee(Employee employee) {
        List<Project> employeeProjects = employee.getProjects();
        for(Project p: employeeProjects) {
            employee.leaveProject(p);
        }

        return employees.remove(employee);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (name != null ? !name.equals(company.name) : company.name != null) return false;
        if (foundationDate != null ? !foundationDate.equals(company.foundationDate) : company.foundationDate != null)
            return false;
        if (projects != null ? !projects.equals(company.projects) : company.projects != null) return false;
        return employees != null ? employees.equals(company.employees) : company.employees == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (foundationDate != null ? foundationDate.hashCode() : 0);
        result = 31 * result + (projects != null ? projects.hashCode() : 0);
        result = 31 * result + (employees != null ? employees.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", foundationDate=" + foundationDate +
                ", projects=" + projects +
                ", employees=" + employees +
                '}';
    }
}
