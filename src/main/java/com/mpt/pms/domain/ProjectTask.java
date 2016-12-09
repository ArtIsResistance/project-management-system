package com.mpt.pms.domain;

import java.time.LocalDate;
import java.util.Calendar;

public class ProjectTask extends Task {
    private Employee employee;
    private Project project;
    private boolean isFinished;

    public ProjectTask(String description, Employee employee, Project project, int hours, LocalDate executionDate) {
        super(description, hours, executionDate);
        this.employee = employee;
        this.project = project;
    }

    public ProjectTask(Task task, Employee employee, Project project) {
        super(task.getDescription(), task.getHours(), task.getExecutionDate());
        this.employee = employee;
        this.project = project;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Project getProject() {
         return project;
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }

    public void finish() {
        isFinished = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectTask that = (ProjectTask) o;

        if (isFinished != that.isFinished) return false;
        if (employee != null ? !employee.equals(that.employee) : that.employee != null) return false;
        return project != null ? project.equals(that.project) : that.project == null;
    }

    @Override
    public int hashCode() {
        int result = employee != null ? employee.hashCode() : 0;
        result = 31 * result + (project != null ? project.hashCode() : 0);
        result = 31 * result + (isFinished ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProjectTask{" +
                "hours=" + hours +
                ", employee=" + employee +
                ", project=" + project +
                ", isFinished=" + isFinished +
                '}';
    }
}
