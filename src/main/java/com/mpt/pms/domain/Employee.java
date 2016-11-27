package com.mpt.pms.domain;

import java.util.*;

public class Employee {
    protected static int workHours = 8;

    private String firstName;
    private String lastName;
    private Date birthDate;
    protected int experienceYears;
    private Set<ProjectTask> tasks;

    public Employee(String firstName, String lastName, Date birthDate, int experienceYears) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.experienceYears = experienceYears;
        tasks = new HashSet<>();
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public Set<ProjectTask> getProjectTasks() {
        return Collections.unmodifiableSet(tasks);
    }

    public boolean canTakeTask(Task t) {
        return freeHours() >= t.getHours();
    }

    public void takeTask(ProjectTask t) {
        tasks.add(t);
    }

    public List<Project> getProjects() {
        Set<Project> projects = new HashSet<Project>();
        for (ProjectTask t : tasks) {
            projects.add(t.getProject());
        }

        return new ArrayList<>(projects);
    }

    public void leaveProject(Project project) {
        boolean result = tasks.removeIf(t -> t.getProject().equals(project));

        if (project.getEmployees().contains(this))
            project.removeEmployee(this);
    }

    public int freeHours() {
        int assignedHours = 0;
        for (ProjectTask t : tasks) {
            if (!t.isFinished())
                assignedHours += t.getHours();
        }

        return workHours - assignedHours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (experienceYears != employee.experienceYears) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        return birthDate != null ? birthDate.equals(employee.birthDate) : employee.birthDate == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + experienceYears;
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", experienceYears=" + experienceYears +
                '}';
    }
}

