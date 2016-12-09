package com.mpt.pms.domain;

import java.time.LocalDate;

public abstract class Task extends ModelBase{
    private String description;
    private LocalDate executionDate;
    protected int hours;

    public Task(String description, int hours) {
        this(description, hours, LocalDate.now());
    }

    public Task(String description, int hours, LocalDate executionDate) {
        this.description = description;
        this.hours = hours;
        this.executionDate = executionDate;
    }

    public String getDescription() {
        return description;
    }

    public abstract boolean isFinished();

    public int getHours() {
        return hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (hours != task.hours) return false;
        return description != null ? description.equals(task.description) : task.description == null;
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + hours;
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", hours=" + hours +
                '}';
    }

    public LocalDate getExecutionDate() {
        return executionDate;
    }
}
