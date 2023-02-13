package com.example.demospring.controller;

import com.example.demospring.entity.User;
import com.example.demospring.repository.UserRepository;
import com.example.demospring.model.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
//@RequestMapping(path = "/overview")
public class UserController {

    @Autowired
    private UserRepository  userRepository;

    @GetMapping("/users")
    public List<UserInterface> getAllUsers(){
        return userRepository.selectAllUsers();
    }

//    @PostMapping("/users/delete")
//    public void deleteUser(@RequestBody String id){
//        userRepository.deleteUserById(id);
//    }
//
//    @DeleteMapping("/users/delete/{id}")
//    public void deleteUser(@PathVariable Long id){
//        userRepository.deleteById(id);
//    }

    @PostMapping("/users/delete")
    public ResponseEntity deleteUser(@RequestBody String id){
        userRepository.deleteById(Long.parseLong(id));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/users/select")
    public UserInterface selectUser(@RequestBody String id){
        return userRepository.selectUser(id);
    }


    @PostMapping("/users/edit")
    public ResponseEntity updateUser(@RequestBody User user){
        userRepository.updateUser(Long.toString(user.getId()), user.getUserName(), user.getEmail(), user.getPassword());
        return ResponseEntity.ok(HttpStatus.OK);
    }




}
