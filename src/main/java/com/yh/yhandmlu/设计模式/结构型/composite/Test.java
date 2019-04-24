package com.yh.yhandmlu.设计模式.结构型.composite;

public class Test {

    public static void main(String[] args) {

        Employee CEO = new Employee("jack","CEO",2000);

        Employee a = new Employee("A","A",1000);
        Employee b = new Employee("B","B",1200);


        Employee a1 = new Employee("A1","A1",1000);
        Employee a2 = new Employee("A2","A1",1000);

        Employee b1 = new Employee("B1","B1",1200);
        Employee b2 = new Employee("B2","B1",1200);

        CEO.add(a);
        CEO.add(b);

        a.add(a1);
        a.add(a2);

        b.add(b1);
        b.add(b2);

        System.out.println(CEO);

        for (Employee employee : CEO.getEmployees()){
            System.out.println(employee);
            for (Employee inner : employee.getEmployees()){
                System.out.println(inner);
            }
        }


    }
}
