package com.mpt.pms.domain;

import com.mpt.pms.domain.exceptions.AssignmentException;
import com.mpt.pms.domain.exceptions.TaskAssignmentException;

import java.util.*;

public class ProjectManager extends ModelBase {
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

    public void setProject(Project project) throws AssignmentException{
        if (!createdTasks.isEmpty())
            throw new AssignmentException("Project already has tasks");
        this.project = project;
    }

    public void assignTask(NotAssignedTask task, Employee employee) throws TaskAssignmentException {
        if (!project.getEmployees().contains(employee))
            throw new TaskAssignmentException("Project not have this employee");

        ProjectTask assignedTask = new ProjectTask(task, employee, project);
        if (!employee.canTakeTask(task))
            throw new TaskAssignmentException("Employee is out of time");

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

    public void assignTask(NotAssignedTask task) throws TaskAssignmentException{
        List<Employee> freeEmployees = project.getFreeEmployees();
        if (freeEmployees.size() == 0) {
            throw new RuntimeException("No free employees found for this project");
        }

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
