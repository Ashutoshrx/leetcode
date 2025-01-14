package com.practice.leetcode;

import com.practice.leetcode.dto.Student;

import java.util.*;
import java.util.stream.Collectors;

class A {
  String name;
  int age;

  public A(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    A a = (A) o;
    return age == a.age && Objects.equals(name, a.name);
  }

  /*@Override
  public int hashCode() {
    return Objects.hash(name, age);
  }*/
}

public class Test {
  public static void main(String[] args) {

    String a = "Ashutosh";
    String b = "Ashutosh";
    String c = new String("Ashutosh");
    String d = new String("Ashutosh");
//    System.out.println(a == b);       // true
//    System.out.println(a.equals(b));  //true
//    System.out.println(c == d);       //false
//    System.out.println(c.equals(d));  //true
    System.out.println(a == c);         //false
    System.out.println(a.equals(c));  //true
    System.out.println(a.hashCode());
    System.out.println(c.hashCode());
    Map<Character, Long> collect = b.chars().mapToObj(value -> (char) value).collect(Collectors.groupingBy(character -> character,
            Collectors.counting()));
    Map.Entry<Character, Long> max =
            b.chars().mapToObj(val -> (char) val).collect(Collectors.groupingBy(val -> val,
                            Collectors.counting())).entrySet().stream().
                    max(Map.Entry.comparingByValue()).get();

    A obj1 = new A("Ashutosh", 12);
    A obj2 = new A("Ashutosh", 12);

//    System.out.println(obj1.hashCode());
//    System.out.println(obj2.hashCode());
//    System.out.println(obj1.equals(obj2));
//    System.out.println(obj1==obj2);
  }

  public static void get() {
    List<Student> students = new ArrayList<>();
    Map.Entry<String, Long> stringLongEntry = students.stream().collect(Collectors.groupingBy(Student::getFirstName, Collectors.counting())).entrySet()
            .stream().max(Map.Entry.comparingByValue()).get();
    students.stream().collect(Collectors.groupingBy(Student::getFirstName,
            Collectors.maxBy(Comparator.comparing(s -> s.getLastName().length()))));
  }
}
