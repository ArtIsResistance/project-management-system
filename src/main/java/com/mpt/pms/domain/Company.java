package com.mpt.pms.domain;

import com.mpt.pms.domain.exceptions.AssignmentException;

import java.util.*;

public class Company extends ModelBase{
    private String name;
    private Date foundationDate;
    private List<Employee> employees;
    private HashMap<Project, ProjectManager> projectManagers;

    public Company(String name, Date foundationDate) {
        this.name = name;
        this.foundationDate = foundationDate;
        employees = new ArrayList<>();
        projectManagers = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Date getFoundationDate() {
        return foundationDate;
    }

    public void assignProjectManager(Project project, ProjectManager manager) throws AssignmentException {
        if (!employees.contains(manager)) {
            throw new AssignmentException(String.format("Company '%s' doesn't have PM '%s %s'",
                                                        name,
                                                        manager.getFirstName(),
                                                        manager.getLastName()));
        }
        if (projectManagers.containsKey(project)) {
            throw new AssignmentException(String.format("Project '%s' already assigned", project.getName()));
        }
        manager.changeProject(project);
        projectManagers.put(project, manager);
    }

    public ProjectManager getProjectManager(Project project) {
        return projectManagers.get(project);
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
        return employees != null ? employees.equals(company.employees) : company.employees == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (foundationDate != null ? foundationDate.hashCode() : 0);
        result = 31 * result + (employees != null ? employees.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", foundationDate=" + foundationDate +
                ", employees=" + employees +
                '}';
    }
}
