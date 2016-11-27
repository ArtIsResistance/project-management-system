package com.mpt.pms.domain;

import java.util.*;

public class Project {
    private String name;
    private Set<Employee> employees;
    private Date creationDate;
    private Date completionDate;
    private int completionHours;
    protected ProjectManager manager;

    public Project(String name, Date creationDate, Date completionDate, int completionHours, ProjectManager manager) {
        this.name = name;
        this.creationDate = creationDate;
        this.completionDate = completionDate;
        this.completionHours = completionHours;
        this.manager = manager;
        manager.setProject(this);
        this.employees = new HashSet<>();
    }

    public int getCompletionHours() {
        return completionHours;
    }

    public Set<Employee> getEmployees() {
        return Collections.unmodifiableSet(employees);
    }

    public ProjectManager getManager() {
        return manager;
    }

    public String getName() {
        return name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void assignEmployee(Employee emp) {
        employees.add(emp);
    }

    public boolean removeEmployee(Employee emp) {
        if (emp.getProjects().contains(this))
            emp.leaveProject(this);

        if (manager.removeEmployeeTasks(emp) && employees.remove(emp)) {
            return true;
        }
        return false;
    }

    public List<Employee> getFreeEmployees() {
        List<Employee> emps = new ArrayList<>();
        for (Employee e : employees) {
            if (e.freeHours() > 0) {
                emps.add(e);
            }
        }

        Collections.sort(emps, (x, y) -> -(x.freeHours() - y.freeHours()));
        return emps;
    }

    public boolean canProjectBeFinished() {
        int assignedHours = manager.getAssignedHours();
        int freeHours = 0;

        for (Employee emp : employees) {
            freeHours += emp.freeHours();
        }

        return completionHours <= assignedHours + freeHours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (completionHours != project.completionHours) return false;
        if (name != null ? !name.equals(project.name) : project.name != null) return false;
        if (employees != null ? !employees.equals(project.employees) : project.employees != null) return false;
        if (creationDate != null ? !creationDate.equals(project.creationDate) : project.creationDate != null)
            return false;
        if (completionDate != null ? !completionDate.equals(project.completionDate) : project.completionDate != null)
            return false;
        return manager != null ? manager.equals(project.manager) : project.manager == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (employees != null ? employees.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (completionDate != null ? completionDate.hashCode() : 0);
        result = 31 * result + completionHours;
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", employees=" + employees +
                ", creationDate=" + creationDate +
                ", completionDate=" + completionDate +
                ", completionHours=" + completionHours +
                ", manager=" + manager +
                '}';
    }
}
