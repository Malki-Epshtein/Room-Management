package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.ServiceCall;

public interface ServiceCallRepositories extends CrudRepository<ServiceCall,Integer>{

}
