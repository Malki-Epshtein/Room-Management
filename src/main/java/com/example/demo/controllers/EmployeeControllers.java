package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employee;
import com.example.demo.services.EmployeeService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/Employee")
public class EmployeeControllers {

    private EmployeeService repo;//יצירת משתנה מסוג SERVICE

    public EmployeeControllers(EmployeeService employeeService) {
        repo = employeeService;
    }

    // 1
    @GetMapping("getAllEmployee")
    public List<Employee> getAllEmployee() {
        return repo.getAllEmployee();
    }

    // 2
    @GetMapping("getEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return repo.getEmployeeById(id);
    }

    // 3
    @PostMapping("addEmployee")
    public Employee addEmployee(@RequestBody Employee newEmployee) {
        return repo.addEmployee(newEmployee);
    }

    // 4
    @DeleteMapping("delete/{id}")
    public Employee delete(@PathVariable int id) {
        return repo.delete(id);
    }

    // 5
    @PutMapping("editEmployee/{id}")
    public Employee editEmployee(@PathVariable int id, @RequestBody Employee editEmployee) {
        return repo.editEmployee(id, editEmployee);
    }

    // 6
    @GetMapping("getHighSalary/{minSalary}")
    public List<Employee> getHighSalary(@PathVariable int minSalary) {
        return repo.getHighSalary(minSalary);
    }

    // 7
    @GetMapping("getEmployeesByRole/{role}")
    public List<Employee> getEmployeesByRole(@PathVariable String role) {
        return repo.getEmployeesByRole(role);
    }
}


