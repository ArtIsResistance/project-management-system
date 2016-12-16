package com.mpt.pms.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Employee implements Serializable {
    protected static int workHours = 8;

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Map<LocalDate, List<ProjectTask>> tasks;

    public Employee(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        tasks = new HashMap<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Map<LocalDate, List<ProjectTask>> getProjectTasks() {
        return Collections.unmodifiableMap(tasks);
    }

    public boolean canTakeTask(Task t) {
        return freeHours(t.getExecutionDate()) >= t.getHours();
    }

    public void takeTask(ProjectTask t) {
        if (tasks.containsKey(t.getExecutionDate())) {
            tasks.get(t.getExecutionDate()).add(t);
            return;
        }

        ArrayList<ProjectTask> newProjectTasks = new ArrayList<>();
        newProjectTasks.add(t);
        tasks.put(t.getExecutionDate(), newProjectTasks);
    }

    public List<Project> getProjects() {
        Set<Project> projects = new HashSet<Project>();

        for (List<ProjectTask> projTasks : tasks.values()) {
            for (ProjectTask t : projTasks) {
                projects.add(t.getProject());
            }
        }

        return new ArrayList<>(projects);
    }

    public void leaveProject(Project project) {
        for (List<ProjectTask> dailyTasks : tasks.values()) {
            dailyTasks.removeIf(t -> t.getProject().equals(project));
        }

        ProjectManager pm = project.getProjectManager();
        if (pm.getEmployees().contains(this))
            pm.removeEmployee(this);
    }

    public int freeHours(LocalDate date) {
        int assignedHours = 0;

        List<ProjectTask> dailyTasks = tasks.get(date);
        if (dailyTasks != null) {
            for (ProjectTask t : dailyTasks) {
                if (!t.isFinished())
                    assignedHours += t.getHours();
            }
        }
        return workHours - assignedHours;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        return birthDate != null ? birthDate.equals(employee.birthDate) : employee.birthDate == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}

