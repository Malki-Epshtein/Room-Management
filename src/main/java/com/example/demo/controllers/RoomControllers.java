package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.RoomService;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entities.Room;
import com.example.demo.enums.RoomType;
import com.example.demo.services.RoomService;

@RestController
@RequestMapping("/Room")
public class RoomControllers {

    private RoomService service;

    public RoomControllers(RoomService roomService) {
        this.service = roomService;
    }

    // 1
    @GetMapping("getAllRooms")
    public List<Room> getAllRooms() {
        return service.getAllRoom();
    }

    // 2
    @GetMapping("getRoomById/{id}")
    public Room getRoomById(@PathVariable int id) {
        return service.getRoomsyId(id);
    }

    // 3
    @PostMapping("addRoom")
    public Room addRoom(@RequestBody Room newRoom) {
        return service.addSRoom(newRoom);
    }

    // 4
    @DeleteMapping("delete/{id}")
    public Room delete(@PathVariable int id) {
        return service.delete(id);
    }

    // 5
    @PutMapping("editRoom/{id}")
    public Room editRoom(@PathVariable int id, @RequestBody Room editRoom) {
        return service.EditRoom(id, editRoom);
    }

    // 6 - הפעלת עדכון המחירים ברקע
    @PostMapping("addPrice/{roomType}")
    public String addPrice(@PathVariable RoomType roomType) {
        service.addPrice(roomType);
        return "Price update process has started for room type: " + roomType;
    }
}


