package com.practice.leetcode.dto;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

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
            new Employee(8, "Ala", "Operations", 44000)
    );
  /*  Character key = employees.stream().map(Employee::getName).collect
            (Collectors.groupingBy(s -> s.charAt(0), Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    System.out.println( key);*/
    List<Integer> integers = Arrays.asList(4, 8, 15, 16, 23, 42);
//    integers.stream().collect(Collectors.groupingBy(integer -> integer,Collectors.averagingDouble(value -> value)));
    int window = 3;

    /*List<Double> range = IntStream.range(0, integers.size() - (window - 1))
            .mapToObj(index -> integers.subList(index, index + window))
            .map(i -> i.stream().mapToInt(Integer::intValue).average().orElse(0)).toList();

    System.out.println(range);*/
//    String sentence = "The quick, brown fox jumped over the lazy dog!";
//    String s = Arrays.stream(sentence.split(" ")).max(Comparator.comparing(String::length)).orElse("");
//    System.out.println(s);
//    ExecutorService executorService = Executors.newFixedThreadPool(1);
    ExecutorService customExecutor = Executors.newFixedThreadPool(4);

    // Create a ForkJoinPool using the custom ExecutorService
    ForkJoinPool customForkJoinPool = new ForkJoinPool(
            4, // parallelism level
            ForkJoinPool.defaultForkJoinWorkerThreadFactory,
            null,
            true, // async mode
            0,
            Integer.MAX_VALUE,
            1,
            null,
            1L, // use the custom ExecutorService
            TimeUnit.MILLISECONDS // timeout for managed blocker
    );
    customForkJoinPool.submit(() -> employees.parallelStream().forEach(employee -> {
//      System.out.println(employee);
      System.out.println("Thread name is: " + Thread.currentThread().getName());
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

    }));
    customForkJoinPool.shutdown();
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

