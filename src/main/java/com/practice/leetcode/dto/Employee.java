package com.practice.leetcode.dto;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
  private int id;
  private String name;
  private String department;
  private int salary;

  public Employee(int id, String name, String department, int salary) {
    this.id = id;
    this.name = name;
    this.department = department;
    this.salary = salary;
  }

  public static void main(String[] args) throws InterruptedException {
    List<Employee> employees = List.of(
            new Employee(1, "John", "IT", 60000),
            new Employee(2, "ALice", "HR", 55000),
            new Employee(3, "Bob", "IT", 75000),
            new Employee(4, "Carol", "HR", 70000),
            new Employee(5, "David", "Finance", 65000),
            new Employee(6, "Eve", "IT", 80000),
            new Employee(7, "Frank", "Finance", 64000),
            new Employee(8, "Ala", "Operations", 44000),
            new Employee(9, "Ashutosh", "Admin", 12000000)
    );

    var deptCount = employees.stream().map(Employee::getDepartment).
            collect(Collectors.groupingBy(c -> c
                    , Collectors.counting()));
    System.out.println(deptCount);
    List<String> finalOut = deptCount.entrySet().stream()
//            .sorted(Map.Entry<String,Integer>.comparingByValue(Comparator.reverseOrder())
//            .thenComparing(Map.Entry.comparingByKey()))
            .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())
                    .thenComparing(Map.Entry.comparingByKey()))
            .map(Map.Entry::getKey).toList();
    System.out.println(finalOut);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "Employee{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", department='" + department + '\'' +
            ", salary=" + salary +
            '}';
  }


}

