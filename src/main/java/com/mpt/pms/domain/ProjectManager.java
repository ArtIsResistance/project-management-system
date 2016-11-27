package com.mpt.pms.domain;

import java.util.*;

public class ProjectManager {
    private Project project;
    private Map<Employee, List<Task>> createdTasks;

    public ProjectManager() {
        createdTasks = new HashMap<>();
    }
    public ProjectManager(Project project) {
        this();
        this.project = project;
    }

    public Map<Employee, List<Task>> getCreatedTasks() {
        return Collections.unmodifiableMap(createdTasks);
    }

    public int getAssignedHours() {
        int assignedHours = 0;

        for(List<Task> employeeTasks: createdTasks.values()) {
            for (Task t: employeeTasks) {
                assignedHours += t.getHours();
            }
        }

        return assignedHours;
    }

    public void setProject(Project project) {
        if (!createdTasks.isEmpty())
            throw new RuntimeException("Project already has tasks");
        this.project = project;
    }

    public void assignTask(NotAssignedTask task, Employee employee) {
        if (!project.getEmployees().contains(employee))
            throw new RuntimeException("Project not have this employee");

        ProjectTask assignedTask = new ProjectTask(task, employee, project);
        if (!employee.canTakeTask(task))
            throw new RuntimeException("Employee is out of time");

        if (createdTasks.containsKey(employee)) {
            createdTasks.get(employee).add(assignedTask);
        }
        else {
            ArrayList<Task> tasks = new ArrayList<>();
            tasks.add(assignedTask);
            createdTasks.put(employee, tasks);
            employee.takeTask(assignedTask);
        }
    }

    public void assignTask(NotAssignedTask task) {
        List<Employee> freeEmployees = project.getFreeEmployees();
        if (freeEmployees.size() == 0) return;

        assignTask(task, freeEmployees.get(0));
    }

    public void removeTask(ProjectTask task) {
        if (createdTasks.containsKey(task.getEmployee()))
            createdTasks.get(task.getEmployee()).remove(task);

        throw new IllegalArgumentException("No task created by PM");
    }

    public boolean removeEmployeeTasks(Employee emp) {
        return createdTasks.remove(emp) != null;
    }
}
