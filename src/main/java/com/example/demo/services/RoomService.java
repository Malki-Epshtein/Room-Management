package com.example.demo.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Room;
import com.example.demo.entities.ServiceCall;
import com.example.demo.enums.RoomType;
import com.example.demo.exceptions.EmployeeNotFoundException;
import com.example.demo.exceptions.RoomNotFoundException;
import com.example.demo.exceptions.ServiceCallNotFoundException;
import com.example.demo.repositories.RoomRepositories;

@Service
public class RoomService {

    @Autowired
    private RoomRepositories repo;

    public RoomService(RoomRepositories roomRepository) {
        repo= roomRepository;
    }

    
    //1
    public List<Room> getAllRoom()
    {
        try{
          List<Room> Rooms = new ArrayList<>();//מחזיר לי ITRIBLLE

          repo.findAll().forEach(Rooms::add);

          if (Rooms.isEmpty()) {
               throw new RoomNotFoundException("No rooms found in the database.");
           }
               return Rooms;
            }
             catch (RoomNotFoundException e) {
             throw e; 
        }
        
        catch(Exception e){
            e.printStackTrace();
            throw e;        }  
    } 

      //2
    public Room getRoomsyId(int id)
    {
        try {//מחזיר לי ServiceCalls
            Room room = repo.findById(id).orElse(null);//תמיר לי ל ServiceCalls

            if (room == null) {
                throw new RoomNotFoundException("Room with ID " + id + " was not found.");
            }

            return room;
        }
            catch (RoomNotFoundException e) {
             throw e; 
        }
          
       
        catch(Exception e){
            e.printStackTrace();
            throw e;        }   
    }

     //3
    public Room addSRoom(Room newRoom)
    {
        try{
             return repo.save(newRoom);
             
        }
        
        catch(Exception e){
            e.printStackTrace();
            throw e;
        } 
    }

        //4
    public Room delete(int id)
    {
       try{
            Room room = repo.findById(id).orElse(null);//תמיר לי ל ServiceCall

            if (room == null) {
                throw new RoomNotFoundException("Room with ID " + id + " was not found.");
            }

             repo.deleteById(id);
             return room;

       }
           catch (RoomNotFoundException e) {
             throw e; 
        }
       
        catch(Exception e){
            e.printStackTrace();
            throw e;        }  
    }

    //5
    public Room EditRoom(int id , Room editRoom)
    {
        try{
          Room room = repo.findById(id).orElse(null);//תמיר לי ל Room

          if (room == null) {
                throw new RoomNotFoundException("Room with ID " + id + " was not found.");
            }

           return repo.save(editRoom);
           

        }
            catch (RoomNotFoundException e) {
             throw e; 
        }

        catch(Exception e){
            e.printStackTrace();
            throw e;        }  
    }

    //6
    @Async("myPool")//אני משתמשת בברכת התליכים שלי
    public void addPrice(RoomType roomType)
    {
        System.out.println("הבקשה התקבלה");
            try{
            List<Room> allRooms = getAllRoom();

             allRooms.stream()//STREAM
             .filter(room -> room.getType().equals(roomType))
             .forEach(room -> {
                 BigDecimal price = BigDecimal.valueOf(room.getPricePerNight());
                 room.setPricePerNight(price.add(new BigDecimal("100")).doubleValue());
             });
             
        repo.saveAll(allRooms);  
        }
        
          catch(Exception e){;
            e.printStackTrace();
            // throw new RuntimeException("A technical database error occurred. Please check the server logs.");
            //לא צריך כי זה 
            // THREAD בנפרד אז לא יהיה לי הדפסה
             throw e;
     
       }
    }
}