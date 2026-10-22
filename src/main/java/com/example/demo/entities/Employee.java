package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {

@Id
private int id;
private String name;
private String role;
private double salary;

 //בנאי ריק 
public Employee() {
}


//בנאי מלא
public Employee(int id, String name, String role, double salary) {
    this.id = id;
    this.name = name;
    this.role = role;
    this.salary = salary;
}


//get
public int getId() {
    return id;
}
public String getName() {
    return name;
}
public String getRole() {
    return role;
}
public double getSalary() {
    return salary;
}


//set
public void setId(int id) {
    this.id = id;
}
public void setName(String name) {
    this.name = name;
}
public void setRole(String role) {
    this.role = role;
}
public void setSalary(double salary) {
    this.salary = salary;
}


  //to string
@Override
public String toString() {
    return "Employee [id=" + id + ", name=" + name + ", role=" + role + ", salary=" + salary + "]";
}



}
