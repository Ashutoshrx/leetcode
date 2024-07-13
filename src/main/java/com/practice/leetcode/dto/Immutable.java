package com.practice.leetcode.dto;

public final class Immutable {
  private final String firstName;
  private final String lastName;
  private final Student student;

  public Immutable(String firstName, String lastName, Student student) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.student = student;
  }

  public Student getStudent() {
//    return new Student(this.getFirstName(), this.getLastName());//this solution has problem of D of SOLID principle
    return new Student(student);
  }

  public String getFirstName() {
    return firstName;
  }

  @Override
  public String toString() {
    return "Immutable{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", student=" + student +
            '}';
  }

  public String getLastName() {
    return lastName;
  }
}
