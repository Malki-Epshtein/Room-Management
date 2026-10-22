package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Employee;
import com.example.demo.exceptions.EmployeeNotFoundException;
import com.example.demo.repositories.EmployeeRepositories;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepositories repo;

    public EmployeeService(EmployeeRepositories employeeRepository) {
        repo = employeeRepository;
    }


    //1
    public List<Employee> getAllEmployee()
    {
        try{
          List<Employee> employees = new ArrayList<>();//מחזיר לי ITRIBLLE

          repo.findAll().forEach(employees::add);//תכניס את כל הערכים שלי לתוך המערך של EMPLOYEES

          if (employees.isEmpty()) {
                throw new EmployeeNotFoundException("No employees found in the database.");
            }

            return employees;

           }
        catch (EmployeeNotFoundException e) {// תבדוק את הראשון אם לא קיים לך תלך לשני
        throw e; //תזרוק למחלקה לטיפול בחריגים
         }
        
        catch(Exception e){
            e.printStackTrace();
            throw e;


        }  
    } 


  
   //2
    public Employee getEmployeeById(int id)
    {
        try {//מחזיר לי EMPLOYEE
            Employee emp = repo.findById(id).orElse(null);//תמיר לי ל employees

            if (emp == null) {
                throw new EmployeeNotFoundException("Employee with ID " + id + " was not found.");
            }

            return emp;
        }
        catch (EmployeeNotFoundException e) {
        throw e; 
        }
        
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }  
    }


    //3
    public Employee addEmployee(Employee newEmployee)//לא עושה שום המרה מביא את מה שקיבל
    {
        try{
             return repo.save(newEmployee);
             
        }
         catch (EmployeeNotFoundException e) {
        throw e; 
        }
       catch (Exception e) {
            e.printStackTrace();
             throw e;
        } 
    }

    //4
    public Employee delete(int id)
    {
       try{
            Employee emp = repo.findById(id).orElse(null);//תמיר לי ל employees

            if (emp == null) {
                throw new EmployeeNotFoundException("Employee with ID " + id + " was not found.");
            }

             repo.deleteById(id);
             return emp;

       }
        catch (EmployeeNotFoundException e) {
        throw e; 
        }
       catch(Exception e)
       {
          e.printStackTrace();
          throw e; 
       }
    }

    //5
    public Employee editEmployee(int id , Employee editEmployee)
    {
        try{
          Employee emp = repo.findById(id).orElse(null);//תמיר לי ל employees

          if (emp == null) {
                throw new EmployeeNotFoundException("Employee with ID " + id + " was not found.");
            }

           return repo.save(editEmployee);
           

        }
         catch (EmployeeNotFoundException e) {
        throw e; 
        }
       catch(Exception e)
       {
          e.printStackTrace();
           throw e; 
       }
    }

    //6
    public List<Employee> getHighSalary(double minSalary)
    {
        try{
            List<Employee> allEmployees = getAllEmployee();

            return allEmployees.stream()//גאן אני משתמשת בSTREAM
                   .filter(emp -> emp.getSalary() > minSalary)
                   .toList();

        }
         catch (EmployeeNotFoundException e) {
        throw e; 
        }
         catch(Exception e)
       {
          e.printStackTrace();
           throw e;        }
    }

    //7
     public List<Employee> getEmployeesByRole(String role)
    {
        try{
            List<Employee> allEmployees = getAllEmployee();

            return allEmployees.stream()//STREAM אני משתמשת בSTREAM
                   .filter(emp -> emp.getRole().equals(role))//אני משתמשת בLANBDA
                   .toList();

        }
         catch (EmployeeNotFoundException e) {
        throw e; 
        }
         catch(Exception e)
       {
          e.printStackTrace();
           throw e;        }
       }


   

}
