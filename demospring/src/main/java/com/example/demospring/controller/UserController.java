package com.example.demospring.controller;

import com.example.demospring.entity.User;
import com.example.demospring.model.Payload;
import com.example.demospring.model.RequestPayload;
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

    @PostMapping("/users")
    public Payload<UserInterface> getAllUsers(){
        List<UserInterface> userList = userRepository.selectAllUsers();
        return new Payload<UserInterface>(userList, userList.size());
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

    @PostMapping("/users/remove")
    public void deleteUser(@RequestBody RequestPayload<User> payload){
        userRepository.delete(payload.getKey());
    }

    @PostMapping("/users/update")
    public void updateUser(@RequestBody RequestPayload<User> payload){
        User user = payload.getKey();
        System.out.println(user);
        userRepository.updateUser(Long.toString(user.getId()), user.getUserName(), user.getEmail(), user.getPassword());
    }




}
