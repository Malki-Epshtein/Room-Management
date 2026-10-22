package com.example.demo.entities;

import com.example.demo.enums.CallStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class ServiceCall {

@Id
private int id;
private String description;
private int roomNumber;
@Enumerated (EnumType.STRING)//enum
private CallStatus status;


  //בנאי ריק 
public ServiceCall() {
}


 //בנאי מלא
public ServiceCall(int id, String description, int roomNumber, CallStatus status) {
    this.id = id;
    this.description = description;
    this.roomNumber = roomNumber;
    this.status = status;
}


//get
public int getId() {
    return id;
}
public String getDescription() {
    return description;
}
public int getRoomNumber() {
    return roomNumber;
}
public CallStatus getStatus() {
    return status;
}


 //set
public void setId(int id) {
    this.id = id;
}
public void setDescription(String description) {
    this.description = description;
}
public void setRoomNumber(int roomNumber) {
    this.roomNumber = roomNumber;
}
public void setStatus(CallStatus status) {
    this.status = status;
}


 //to string
@Override
public String toString() {
    return "ServiceCall [id=" + id + ", description=" + description + ", roomNumber=" + roomNumber + ", status="
            + status + "]";
}
}
