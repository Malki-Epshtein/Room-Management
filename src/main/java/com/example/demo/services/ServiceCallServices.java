package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Employee;
import com.example.demo.entities.ServiceCall;
import com.example.demo.enums.CallStatus;
import com.example.demo.exceptions.EmployeeNotFoundException;
import com.example.demo.exceptions.RoomNotFoundException;
import com.example.demo.exceptions.ServiceCallNotFoundException;
import com.example.demo.repositories.ServiceCallRepositories;

@Service
public class ServiceCallServices {

@Autowired
private ServiceCallRepositories  repo;

public ServiceCallServices(ServiceCallRepositories serviceCallRepository) {
    repo = serviceCallRepository;
}


    //1
    public List<ServiceCall> getAllServiceCall()
    {
        try{
          List<ServiceCall> ServiceCalls = new ArrayList<>();//מחזיר לי ITRIBLLE

          repo.findAll().forEach(ServiceCalls::add);

          if (ServiceCalls.isEmpty()) {
                throw new ServiceCallNotFoundException("No service calls found in the database.");
            }

            return ServiceCalls;
           }
               catch (ServiceCallNotFoundException e) {
             throw e; 
        }
        
      
        catch(Exception e){
            e.printStackTrace();
            throw e;        }    
    } 

      //2
    public ServiceCall getServiceCallsyId(int id)
    {
        try {//מחזיר לי ServiceCalls
            ServiceCall ser = repo.findById(id).orElse(null);//תמיר לי ל ServiceCalls

            if (ser == null) {
                throw new EmployeeNotFoundException("ServiceCalls with ID " + id + " was not found.");
            }

            return ser;
        }
              catch (ServiceCallNotFoundException e) {
             throw e; 
        }
          
     
        catch(Exception e){
            e.printStackTrace();
            throw e;        }   
    }

     //3
    public ServiceCall addServiceCall(ServiceCall newServiceCall)//לא עושה שום המרה מביא את מה שקיבל
    {
        try{
             return repo.save(newServiceCall);
             
        }
       
        catch(Exception e){
            e.printStackTrace();
            throw e;        }  
    }

        //4
    public ServiceCall delete(int id)
    {
       try{
            ServiceCall ser = repo.findById(id).orElse(null);//תמיר לי ל ServiceCall

            if (ser == null) {
                throw new EmployeeNotFoundException("ServiceCall with ID " + id + " was not found.");
            }

             repo.deleteById(id);
             return ser;

       }
             catch (ServiceCallNotFoundException e) {
             throw e; 
        }
     
        catch(Exception e){
            e.printStackTrace();
            throw e;        }  
    }

    //5
    public ServiceCall editServiceCall(int id , ServiceCall editServiceCall)
    {
        try{
          ServiceCall ser = repo.findById(id).orElse(null);//תמיר לי ל employees

          if (ser == null) {
                throw new EmployeeNotFoundException("ServiceCall with ID " + id + " was not found.");
            }

           return repo.save(editServiceCall);
           

        }
              catch (ServiceCallNotFoundException e) {
             throw e; 
        }

       
        catch(Exception e){
            e.printStackTrace();
            throw e;        }  
    }

    //6
    private int closedCallsCount = 0; // מונה לכמה סגר

  //תהליכון כדי שזה לא יתקע לי את המחשב להרבה זמן
    public void closeOldCallsInBackground()
    {
        Runnable task = ()->{//תדרוס לי את הRUNNABLE
        try{
           System.out.println(" Java Thread started: " + Thread.currentThread().getName());
           List<ServiceCall> allCalls = getAllServiceCall();
           Thread.sleep(3000);// חייב TRY CATCH

           for(ServiceCall call:allCalls)
           {
            call.setStatus(CallStatus.CLOSED);//ENUM
            repo.save(call);
            incrementClosedCount();
           }

           
        }
         catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("A technical database error occurred. Please check the server logs.");
        }
    };

    Thread myThread = new Thread(task);//יצירת תהלכון והבאת המשימה שלי
    myThread.start();//הפעלתי אותו
   
}

    public synchronized void incrementClosedCount()// כי זה רץ כאלו מאחורי הקלעים פונקציה סכרונית שלא יוכלו לעעדכן ביחד
    {
        this.closedCallsCount++;
    }












}
