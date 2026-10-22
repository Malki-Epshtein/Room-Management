package com.example.demo.entities;



import com.example.demo.enums.RoomType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Room {

    @Id
    private int id;
    private  int roomNumber;
    @Enumerated (EnumType.STRING)//enum
    private RoomType type;
    private double pricePerNight; 
    private boolean isAvailable;

    //בנאי ריק  
    public Room() {
    }

    //בנאי מלא
    public Room(int id, int roomNumber, RoomType type, double pricePerNight, boolean isAvailable) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.isAvailable = isAvailable;
    }

    //get

    public int getId() {
        return id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomType getType() {
        return type;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
   



    //set
   

    public void setId(int id) {
        this.id = id;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    //to string
    @Override
    public String toString() {
        return "Room [id=" + id + ", roomNumber=" + roomNumber + ", type=" + type + ", pricePerNight=" + pricePerNight
                + ", isAvailable=" + isAvailable + "]";
    }

  
   

    

  


    
    



}
