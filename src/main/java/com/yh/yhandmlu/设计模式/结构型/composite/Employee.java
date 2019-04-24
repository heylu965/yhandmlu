package com.yh.yhandmlu.设计模式.结构型.composite;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String name;
    private String dept;
    private int salary;

    private List<Employee> children ;

    public Employee(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.children = new ArrayList<>();
    }

    public void add(Employee e){
        children.add(e);
    }

    public void remove(Employee e){
        children.remove(e);
    }

    public List<Employee> getEmployees(){
        return children;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }
}
