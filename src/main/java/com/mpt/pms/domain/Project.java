package com.mpt.pms.domain;

import com.mpt.pms.domain.exceptions.AssignmentException;
import com.mpt.pms.domain.exceptions.EmployeeAssignmentException;

import java.time.LocalDate;
import java.util.*;

public class Project extends ModelBase {
    private String name;
    private LocalDate creationDate;
    private LocalDate completionDate;
    private int completionHours;
    private Company company;

    public Project(String name, LocalDate creationDate, LocalDate completionDate, int completionHours,
                   Company company) throws AssignmentException {
        this.name = name;
        this.creationDate = creationDate;
        this.completionDate = completionDate;
        this.completionHours = completionHours;
        this.company = company;
    }

    public int getCompletionHours() {
        return completionHours;
    }

    public Company getCompany() { return company; }

    public String getName() {
        return name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public ProjectManager getProjectManager() {
        return company.getProjectManager(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (completionHours != project.completionHours) return false;
        if (name != null ? !name.equals(project.name) : project.name != null) return false;
        if (creationDate != null ? !creationDate.equals(project.creationDate) : project.creationDate != null)
            return false;
        if (completionDate != null ? !completionDate.equals(project.completionDate) : project.completionDate != null)
            return false;
        return company != null ? !company.equals(project.company) : project.company != null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (completionDate != null ? completionDate.hashCode() : 0);
        result = 31 * result + completionHours;
        result = 31 * result + (company != null ? company.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", completionDate=" + completionDate +
                ", completionHours=" + completionHours +
                '}';
    }
}
