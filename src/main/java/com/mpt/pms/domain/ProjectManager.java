package com.mpt.pms.domain;

import com.mpt.pms.domain.exceptions.AssignmentException;
import com.mpt.pms.domain.exceptions.EmployeeAssignmentException;
import com.mpt.pms.domain.exceptions.TaskAssignmentException;

import java.time.LocalDate;
import java.time.temporal.TemporalUnit;
import java.util.*;

import static java.time.temporal.ChronoUnit.DAYS;

public class ProjectManager extends Employee {
    private Project managingProject;

    private List<Employee> employees;
    private Map<LocalDate, List<ProjectTask>> createdTasks;

    public ProjectManager(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate);
        createdTasks = new HashMap<>();
        employees = new ArrayList<>();
    }

    public Map<LocalDate, List<ProjectTask>> getCreatedTasks() {
        return Collections.unmodifiableMap(createdTasks);
    }

    public int getAssignedHours() {
        int assignedHours = 0;
        for (List<ProjectTask> employeeTasks : createdTasks.values()) {
            for (Task t : employeeTasks) {
                assignedHours += t.getHours();
            }
        }
        return assignedHours;
    }

    public Project getManagingProject() {
        return managingProject;
    }

    public void changeProject(Project project) throws AssignmentException {
        if (!createdTasks.isEmpty()) {
            for (List<ProjectTask> employeeTasks : createdTasks.values()) {
                for (Task t : employeeTasks) {
                    if (!t.isFinished()) {
                        throw new AssignmentException("Can't change project while current is in active state");
                    }
                }
            }
        }
        this.managingProject = project;
    }

    public void assignEmployee(Employee emp) throws EmployeeAssignmentException {
        if (!managingProject.getCompany().getEmployees().contains(emp))
            throw new EmployeeAssignmentException(String.format("Employee '%s %s' doesn't belong to this company",
                                                                emp.getFirstName(),
                                                                emp.getLastName()));
        if (employees.contains(emp)) {
            throw new EmployeeAssignmentException(String.format("Employee '%s %s' already assigned to this project",
                                                                emp.getFirstName(),
                                                                emp.getLastName()));
        }
        employees.add(emp);
    }

    public boolean removeEmployee(Employee emp) {
        if (emp.getProjects().contains(managingProject))
            emp.leaveProject(managingProject);
        return removeEmployeeTasks(emp) && employees.remove(emp);
    }

    public List<Employee> getFreeEmployees(LocalDate date) {
        List<Employee> emps = new ArrayList<>();
        for (Employee e : employees) {
            if (e.freeHours(date) > 0) {
                emps.add(e);
            }
        }
        Collections.sort(emps, (x, y) -> -(x.freeHours(date) - y.freeHours(date)));
        return emps;
    }

    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(employees);
    }

    public boolean canProjectBeFinished() {
        int assignedHours = getAssignedHours();
        int freeHours = 0;
        long daySpan = DAYS.between(managingProject.getCreationDate(), managingProject.getCompletionDate());
        for (int i = 0; i <= daySpan; i++) {
            LocalDate date = managingProject.getCreationDate().plusDays(i);
            for (Employee emp : employees) {
                freeHours += emp.freeHours(date);
            }
        }
        return managingProject.getCompletionHours() <= assignedHours + freeHours;
    }

    public void assignTask(NotAssignedTask task, Employee employee) throws TaskAssignmentException {
        if (!employees.contains(employee))
            throw new TaskAssignmentException(String.format("Project not have this employee '%s %s'",
                                                            employee.getFirstName(),
                                                            employee.getLastName()));
        ProjectTask assignedTask = new ProjectTask(task, employee, managingProject);
        if (!employee.canTakeTask(task))
            throw new TaskAssignmentException(String.format("Employee '%s %s' is out of time",
                                                            employee.getFirstName(),
                                                            employee.getLastName()));

        if (createdTasks.containsKey(task.getExecutionDate())) {
            createdTasks.get(task.getExecutionDate()).add(assignedTask);
        } else {
            ArrayList<ProjectTask> tasks = new ArrayList<>();
            tasks.add(assignedTask);
            createdTasks.put(task.getExecutionDate(), tasks);
            employee.takeTask(assignedTask);
        }
    }

    public void assignTask(NotAssignedTask task) throws TaskAssignmentException {
        List<Employee> freeEmployees = getFreeEmployees(task.getExecutionDate());
        if (freeEmployees.size() == 0) {
            throw new RuntimeException("No free employees found for this project");
        }

        assignTask(task, freeEmployees.get(0));
    }

    public void removeTask(ProjectTask task) {
        if (createdTasks.containsKey(task.getExecutionDate())) {
            createdTasks.get(task.getExecutionDate()).remove(task);
        }

        throw new IllegalArgumentException("No task created by PM");
    }

    private boolean removeEmployeeTasks(Employee emp) {
        boolean tasksFound = false;
        for (List<ProjectTask> dailyTasks : createdTasks.values()) {
            tasksFound = dailyTasks.removeIf(t -> t.getEmployee().equals(emp));
        }

        return tasksFound;
    }
}
