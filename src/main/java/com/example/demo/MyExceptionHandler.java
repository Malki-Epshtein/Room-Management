package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.exceptions.EmployeeNotFoundException;
import com.example.demo.exceptions.RoomNotFoundException;
import com.example.demo.exceptions.ServiceCallNotFoundException;

@ControllerAdvice
public class MyExceptionHandler {


    //בגלל  שזרקתי את השגיאה לשכבה למעלה לקונטרולר אז כל פעם זה לא הצליח 
    //להדפיס את השגיאה וזרק 404 ולכן בשביל זה יצרתי את התפיסת שגיאות הגלובלי

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleEmployeeNotFound(EmployeeNotFoundException e) {
        return e.getMessage(); // זה מה שיחזור ב-Postman
    }

    @ExceptionHandler(RoomNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) // 400
    @ResponseBody
    public String handleInvalidInput(RoomNotFoundException e) {
            return e.getMessage(); // זה מה שיחזור ב-Postman
  }

   @ExceptionHandler(ServiceCallNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) // 400
    @ResponseBody
    public String handleServiceCallNotFound(ServiceCallNotFoundException e) {
            return e.getMessage(); // זה מה שיחזור ב-Postman
  }

 }