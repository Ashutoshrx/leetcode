package com.practice.leetcode.concepts.streams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Java Streams practice. Needs Java 16+ (for Stream.toList()).
 * Write your answer in each TODO, run, then compare with EXPECTED at the bottom.
 */
public class StreamPractice {

  public static void main(String[] args) {
    List<Student> students = List.of(
            new Student("Ashutosh", "Karnataka", "CSE", "Male", 21, 3, List.of("9990001111", "ash@mail.com")),
            new Student("Bhavya", "karnataka", "ECE", "Female", 22, 1, List.of("bhavya@mail.com")),
            new Student("Chetan", "Odisha", "CSE", "Male", 23, 5, List.of("9990002222")),
            new Student("Deepa", "Karnataka", "MECH", "Female", 20, 2, List.of("9990003333", "deepa@mail.com")),
            new Student("Esha", "Kerala", "ECE", "Female", 21, 1, List.of("esha@mail.com")),
            new Student("Farhan", "Karnataka", "CSE", "Male", 24, 4, List.of()),
            new Student("Gita", "Odisha", "MECH", "Female", 22, 6, List.of("9990004444")),
            new Student("Harsh", "Kerala", "ECE", "Male", 23, 7, List.of("harsh@mail.com"))
    );
//    students.stream().sorted(Comparator.comparing(Student::getAge,Comparator.reverseOrder()));

    // Q1: Students from Karnataka (ignore case), sorted by name
    System.out.println("Q1 : " + students.stream().filter(stud -> "Karnataka".equalsIgnoreCase(stud.getCity()))
            .map(Student::getName).sorted().toList());

    // Q2: All contacts of all students in one flat list
    System.out.println("Q2 : " + students.stream().
            flatMap(stud -> stud.getContacts().stream()).toList());

    // Q3: Group students by department
    System.out.println("Q3 : " + students.stream().collect(Collectors.groupingBy(Student::getDept)));

    // Q4: Group by department and count
    System.out.println("Q4 : " + students.stream().collect(Collectors.groupingBy(Student::getDept,
            Collectors.counting())));

    // Q5: Department with the max student count
    System.out.println("Q5 : " + students.stream().collect(
                    Collectors.groupingBy(Student::getDept, Collectors.counting()))
            .entrySet().stream().
            max(Comparator.comparing(Map.Entry::getValue))
            .stream().findFirst().orElse(null));


    // Q6: Average age by gender
    System.out.println("Q6 : " + students.stream().collect
            (Collectors.groupingBy(Student::getGender,
                    Collectors.averagingInt(Student::getAge))));

    // Q7: Best-ranked (rank 1 = best) student in each department
    System.out.println("Q7 : " + students.stream().collect(Collectors.groupingBy(Student::getDept,
            Collectors.minBy(Comparator.comparing(Student::getRank)))));

    // Q8: Second-best distinct rank
    System.out.println("Q8 : " + students.stream()
            .map(Student::getRank).distinct()
            .sorted().skip(1).findFirst().orElseThrow());

    // Q9: Character -> occurrence count for s
    String s = "Ashutosh";
    System.out.println("Q9 : " + s.chars().mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(c -> c, Collectors.counting())));

    // Q10: Most frequent character in s
    System.out.println("Q10: " + s.chars().mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
            .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)));
  }

  static class Student {
    private final String name, city, dept, gender;
    private final int age, rank;
    private final List<String> contacts;

    Student(String name, String city, String dept, String gender,
            int age, int rank, List<String> contacts) {
      this.name = name;
      this.city = city;
      this.dept = dept;
      this.gender = gender;
      this.age = age;
      this.rank = rank;
      this.contacts = contacts;
    }

    @Override
    public boolean equals(Object o) {
      if (o == null || getClass() != o.getClass()) return false;
      Student student = (Student) o;
      return age == student.age && rank == student.rank && Objects.equals(name, student.name) && Objects.equals(city, student.city) && Objects.equals(dept, student.dept) && Objects.equals(gender, student.gender) && Objects.equals(contacts, student.contacts);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name, city, dept, gender, age, rank, contacts);
    }

    public String getName() {
      return name;
    }

    public String getCity() {
      return city;
    }

    public String getDept() {
      return dept;
    }

    public String getGender() {
      return gender;
    }

    public int getAge() {
      return age;
    }

    public int getRank() {
      return rank;
    }

    public List<String> getContacts() {
      return contacts;
    }

    @Override
    public String toString() {
      return name + "(" + dept + ",r" + rank + ")";
    }
  }
}

/*
 * EXPECTED (HashMap-based output order may differ, the content should match)
 *
 * Q1 : [Ashutosh, Bhavya, Deepa, Farhan]            (names; city 'karnataka' matches too)
 * Q2 : 9 items: [9990001111, ash@mail.com, bhavya@mail.com, 9990002222, 9990003333,
 *                deepa@mail.com, esha@mail.com, 9990004444, harsh@mail.com]
 *      (Farhan has no contacts, so he adds nothing)
 * Q3 : CSE=[Ashutosh, Chetan, Farhan], ECE=[Bhavya, Esha, Harsh], MECH=[Deepa, Gita]
 * Q4 : {CSE=3, ECE=3, MECH=2}
 * Q5 : CSE=3 or ECE=3  (a tie, so the winner depends on HashMap order)
 * Q6 : {Male=22.75, Female=21.25}
 * Q7 : CSE=Ashutosh(r3), ECE=Bhavya(r1), MECH=Deepa(r2)
 *      (ECE has a tie at rank 1 between Bhavya and Esha; minBy keeps the first one it sees)
 * Q8 : 2   (ranks are 1,1,2,3,4,5,6,7; a naive skip(1) on students returns a rank-1 student)
 * Q9 : {A=1, s=2, h=2, u=1, t=1, o=1}
 * Q10: 's' or 'h' (count 2, tie)
 *
 * BONUS: for Q5 and Q10, add a tie-breaker so the result is deterministic.
 */