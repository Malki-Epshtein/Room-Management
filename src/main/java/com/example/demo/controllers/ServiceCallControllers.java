package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.ServiceCall;
import com.example.demo.services.ServiceCallServices;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entities.ServiceCall;
import com.example.demo.services.ServiceCallServices;

@RestController
@RequestMapping("/ServiceCall")
public class ServiceCallControllers {

    private ServiceCallServices service;

    public ServiceCallControllers(ServiceCallServices serviceCallServices) {
        this.service = serviceCallServices;
    }

    // 1
    @GetMapping("getAllServiceCalls")
    public List<ServiceCall> getAllServiceCalls() {
        return service.getAllServiceCall();
    }

    // 2
    @GetMapping("getServiceCallById/{id}")
    public ServiceCall getServiceCallById(@PathVariable int id) {
        return service.getServiceCallsyId(id);
    }

    // 3
    @PostMapping("addServiceCall")
    public ServiceCall addServiceCall(@RequestBody ServiceCall newServiceCall) {
        return service.addServiceCall(newServiceCall);
    }

    // 4
    @DeleteMapping("delete/{id}")
    public ServiceCall delete(@PathVariable int id) {
        return service.delete(id);
    }

    // 5
    @PutMapping("editServiceCall/{id}")
    public ServiceCall editServiceCall(@PathVariable int id, @RequestBody ServiceCall editServiceCall) {
        return service.editServiceCall(id, editServiceCall);
    }

    // 6 - הפעלת המשימה ברקע
    @PostMapping("closeOldCalls")
    public String closeOldCalls() {
        service.closeOldCallsInBackground();
        return "Background process started to close old calls.";
    }
}






