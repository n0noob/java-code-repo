package com.comprog.java8;

import java.util.*;
import java.util.stream.*;

/*
 * Given a Students Collection, Find all students in each department along with their percentage scores.
 */

class Student {
  private int deptId;
  private String name;
  private String gender;
  private int avgScore;
  
  public Student(int deptId, String name, String gender, int avgScore) {
    this.deptId = deptId;
    this.name = name;
    this.gender = gender;
    this.avgScore = avgScore;
  }
  
  public void setDeptId(int deptId) {
    this.deptId = deptId;
  }
  public int getDeptId() {
    return deptId;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  public String getName() {
    return name;
  }
  
  public void setGender(String gender) {
    this.gender = gender;
  }
  public String getGender() {
    return gender;
  }
  
  public void setAvgScore(int avgScore) {
    this.avgScore = avgScore;
  }
  public int getAvgScore() {
    return avgScore;
  }
  
  public String toString() {
    return "student[" + " name=" + name + " gender=" + gender +  " deptId=" + deptId + " avgScore=" + avgScore + " ]";
  }
}

class StudentPartitionStoreMax {
  public static void main(String[] args) {
    List<Student> list = new ArrayList<Student>();
    list.add(new Student(1, "Alex", "male", 77));
    list.add(new Student(2, "Priya", "female", 81));
    list.add(new Student(3, "Michelle", "female", 69));
    list.add(new Student(2, "Kabir", "male", 40));
    list.add(new Student(1, "Marilyn", "female", 82));
    
    Map<Integer, Optional<Student>> map = list.stream()
                                          .collect(
                                              Collectors.groupingBy(
                                                s -> s.getDeptId(),
                                                Collectors.maxBy((a, b) -> {
                                                  return a.getAvgScore() - b.getAvgScore();
                                                })
                                              )
                                          );
    
    System.out.println(map);
    
  }
}

