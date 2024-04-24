package com.example.Best.Buy.controller;

import com.example.Best.Buy.dto.UserDTO;
import com.example.Best.Buy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDto){
        return ResponseEntity.ok(userService.save(userDto));
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDto){
        return ResponseEntity.ok(userService.login(userDto));
    }

    @GetMapping("/user")
    public ResponseEntity<List<UserDTO>> getUser(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }


    @PutMapping("/user/{id}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDto, @PathVariable Long id){
        return ResponseEntity.ok(userService.update(userDto,id));
    }
}
