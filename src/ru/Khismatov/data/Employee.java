package ru.Khismatov.data;

import java.util.ArrayList;

class Department {
    private String name;
    private Employee head;
    private ArrayList<Employee> employees;

    public Department(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Department name cannot be null or empty");
        }
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void add_employee(Employee employee) {
        if (!employees.contains(employee)) {employees.add(employee);}
    }

    public void setHead(Employee head) {this.head = head;}

    public String get_name() {return name;}

    public Employee get_head() {return head;}

    public String get_employees() {
        StringBuilder sb = new StringBuilder();
        for (Employee em : employees) {
            sb.append(em.get_name()).append(", ");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }
}

class Employee {
    private String name;
    private Department department;

    public Employee(String name, Department department) {
        if (department == null || name == null || name.isEmpty()) {
            throw new NullPointerException("Department and name is null or empty");
        }
        this.name = name;
        this.department = department;
        department.add_employee(this);
    }

    public String get_name() {return name;}

    public Department get_department() {return department;}

    @Override
    public String toString() {
        if (this == department.get_head()) {return name + " начальник отдела " + department.get_name();}
        else {return name + " работает в отделе " + department.get_name() + ", начальник которого " + department.get_head().name;}
    }
}